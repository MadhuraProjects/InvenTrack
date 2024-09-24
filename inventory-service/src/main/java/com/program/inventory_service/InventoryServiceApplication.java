package com.program.inventory_service;

import com.program.inventory_service.model.Inventory;
import com.program.inventory_service.repository.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData(InventoryRepository inventoryRepository)
	{
		return args -> {
			Inventory iphone13Red=inventoryRepository.findBySkuCode("iphone_13_red");
			if(null!=iphone13Red)
			{
				iphone13Red.setQuantity(iphone13Red.getQuantity()+1);
				inventoryRepository.save(iphone13Red);
			}
			else
			{
				Inventory inventory=new Inventory();
				inventory.setSkuCode("iphone_13_red");
				inventory.setQuantity(1);
				inventoryRepository.save(inventory);
			}
//			Inventory inventory=new Inventory();
//			inventory.setSkuCode("iphone_13_red");
//			inventory.setQuantity(0);

			Inventory iphone13Blue=inventoryRepository.findBySkuCode("iphone_13_blue");
			if(null!=iphone13Blue)
			{
				iphone13Blue.setQuantity(iphone13Blue.getQuantity()+1);
				inventoryRepository.save(iphone13Blue);
			}
			else
			{
				Inventory inventory1=new Inventory();
				inventory1.setSkuCode("iphone_13_blue");
				inventory1.setQuantity(1);
				inventoryRepository.save(inventory1);

			}

//			Inventory inventory1=new Inventory();
//			inventory1.setSkuCode("iphone_13_blue");
//			inventory1.setQuantity(10);



//			inventoryRepository.save(inventory);
//			inventoryRepository.save(inventory1);
		};
	}
}
