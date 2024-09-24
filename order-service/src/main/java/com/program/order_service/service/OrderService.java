package com.program.order_service.service;

import com.program.order_service.config.WebClientConfig;
import com.program.order_service.model.Order;
import com.program.order_service.model.OrderLineItems;
import com.program.order_service.orderDTO.InventoryResponse;
import com.program.order_service.orderDTO.OderRequest;
import com.program.order_service.orderDTO.OrderLineItemsDTO;
import com.program.order_service.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriBuilder;

import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import static org.hibernate.boot.model.process.spi.MetadataBuildingProcess.build;

@Service
@Transactional
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private WebClient.Builder webClientBuilder;

    // this method will convert orderRequest to order object
    public ResponseEntity<String> placeOrder(OderRequest orderRequest) {
        Order order=new Order();
        order.setOrderNo(UUID.randomUUID().toString());
        // method to convert orderLineItemsDTO(in orderRequest) to orderLineItems(in order class)
        // since orderLineItemsDTOList is a list of items so get will give a List
        //so we need to set the value to OrderLineItems one by one
        List<OrderLineItems> orderLineItemsList=orderRequest.getOrderLineItemsDTOList().stream().map(orderLineItemsDTO->mapDTOToModel(orderLineItemsDTO))
                .toList();
        order.setOrderLineItemsList(orderLineItemsList);

        // collect all th skucodes for the orderLineItems
        List<String> skuCodes=order.getOrderLineItemsList().stream().map(OrderLineItems::getSkuCode).toList();
        // url: http://localhost
        InventoryResponse[] inventoryResponseArray=webClientBuilder.build().get().uri("http://localhost:8092/api/inventory",
                        uriBuilder->uriBuilder.queryParam("skuCode",skuCodes).build())
                        .retrieve().bodyToMono(InventoryResponse[].class).block();

        if (inventoryResponseArray != null) {
            for (InventoryResponse inventoryResponse : inventoryResponseArray) {
                System.out.println(inventoryResponse.getSkuCode());
            }
        } else {
            System.out.println("Inventory response array is null.");
        }
        // if even 1 item is not in stock allProductsInStock will return false
        boolean allProductsInStock= Arrays.stream(inventoryResponseArray)
                .allMatch(InventoryResponse::isInStock);

        // if all the products is in stock then it will save or else it will throw an error
        if(allProductsInStock)
        {
            orderRepository.save(order);
        }
        else
        {
            throw new IllegalArgumentException("Product is not in stock");
        }
        orderRepository.save(order);
        return new ResponseEntity<>("success", HttpStatus.CREATED);
    }
    // method to convert the (each) of the items ordered from its DTO class to model object
    private OrderLineItems mapDTOToModel(OrderLineItemsDTO orderLineItemsDTO) {
        OrderLineItems orderLineItems=new OrderLineItems();
        orderLineItems.setSkuCode(orderLineItemsDTO.getSkuCode());
        orderLineItems.setPrice(orderLineItemsDTO.getPrice());
        orderLineItems.setQuantity(orderLineItemsDTO.getQuantity());
        return orderLineItems;
    }



}
