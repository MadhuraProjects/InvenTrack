package com.program.order_service.orderDTO;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderLineItemsDTO {
    @Id
    //@GeneratedValue(strategy= GenerationType.IDENTITY)
    private ObjectId id;
    private String skuCode;
    private int price;
    private int quantity;
}
