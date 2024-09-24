package com.program.order_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

//@Entity
//@Table(name="t_order")
@Document(value="t_order")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    //@GeneratedValue(strategy =GenerationType.AUTO)
    private ObjectId id;
    private String orderNo;
    @OneToMany(cascade = CascadeType.ALL)
    private List<OrderLineItems> orderLineItemsList;
}
