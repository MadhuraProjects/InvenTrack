package com.program.product_service.productDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {
    private ObjectId id;
    private String name;
    private String description;
    private int price;
}
