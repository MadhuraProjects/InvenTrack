package com.program.order_service.orderDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OderRequest {
    private List<OrderLineItemsDTO> orderLineItemsDTOList;

}

