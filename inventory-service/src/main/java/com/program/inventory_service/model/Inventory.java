package com.program.inventory_service.model;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value="t_inventory")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Inventory {
    @Id
    private ObjectId id;
    private String skuCode;
    // the item can be listed in inventory but have quantity as 0/threshold- then it will not be in stock
    private Integer quantity;
}
