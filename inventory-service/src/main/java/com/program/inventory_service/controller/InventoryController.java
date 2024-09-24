package com.program.inventory_service.controller;

import com.program.inventory_service.inventoryDTO.InventoryResponse;
import com.program.inventory_service.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {
    @Autowired
    InventoryService inventoryService;
    // http://localhost:8092/api/inventory/iphone-13,kindle 420,airpod56 -- path variable format

    // http://localhost:8092/api/inventory?sku-code=iphone-13&kindle420&airpod56 -- request param format

    @GetMapping
    public ResponseEntity<List<InventoryResponse>> isInStock(@RequestParam List<String> skuCode)
    {
        return inventoryService.isInStock(skuCode);
    }
}
