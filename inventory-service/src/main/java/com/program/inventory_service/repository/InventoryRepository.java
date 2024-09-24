package com.program.inventory_service.repository;

import com.program.inventory_service.model.Inventory;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface InventoryRepository extends MongoRepository<Inventory, ObjectId>{
    // So we are giving a List of skucodes and springdata JPA will give us a List of inventory objects that match the skucodes
    List<Inventory> findBySkuCodeIn(List<String> skuCode);

    public Inventory findBySkuCode(String skuCode);
}
