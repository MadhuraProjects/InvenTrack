package com.program.inventory_service.service;

import com.program.inventory_service.inventoryDTO.InventoryResponse;
import com.program.inventory_service.model.Inventory;
import com.program.inventory_service.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class InventoryService {
    @Autowired
    InventoryRepository inventoryRepository;
    @Transactional(readOnly = true)
    // method to check if a product with a skuCode is in stock or not
    public ResponseEntity<List<InventoryResponse>> isInStock(List<String> skuCode){
        List<InventoryResponse> inventoryResponseList= inventoryRepository.findBySkuCodeIn(skuCode).stream()
                .map(inventory ->
                    InventoryResponse.builder().skuCode(inventory.getSkuCode())
                            .isInStock(inventory.getQuantity()>0)
                            .build()).toList();

        System.out.println("******");

//        int len=inventoryResponseList.size();
//        if(len==0)
//        {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        } else if () {
//            for(int i=0;i<len;i++)
//            {
//                inventoryResponseList.get(i).getSkuCode()
//            }
//
//        }

        // isInStock variable of the InventoryResponse will return true value if the quantity of the product >0 or else false
        return new ResponseEntity<>(inventoryResponseList, HttpStatus.OK);
    }
}
