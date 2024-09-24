package com.program.order_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

//@Entity
@Document(value="t_orderlineitems")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderLineItems {
    @Id
    //@GeneratedValue(strategy= GenerationType.IDENTITY)
    private ObjectId id;
    private String skuCode;
    private int price;
    private int quantity;

}
