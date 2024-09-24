package com.program.product_service;

import com.program.product_service.productDTO.ProductRequest;
import com.program.product_service.repository.ProductRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.shaded.com.fasterxml.jackson.databind.ObjectMapper;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Testcontainers
class ProductServiceApplicationTests {
//	@Container
//	static MongoDBContainer mongoDBContainer=new MongoDBContainer("mongo:7.0.12");
//	@Autowired
//	private MockMvc mockMvc;
//	@Autowired
//	private ObjectMapper objectMapper;
//	@Autowired
//	private ProductRepository productRepository;

//	@DynamicPropertySource
//	static void setProperties(DynamicPropertyRegistry dynamicPropertyRegistry)
//	{
//		dynamicPropertyRegistry.add("spring.data.mongodb.uri", mongoDBContainer::getReplicaSetUrl);
//	}

//	@Test
//	void shouldCreateProduct() throws Exception{
//		ProductRequest productRequest=getProductRequest();
//		String productRequestString=objectMapper.writeValueAsString(productRequest);
//		mockMvc.perform(MockMvcRequestBuilders.post("/api/product")
//				.contentType(MediaType.APPLICATION_JSON).content(productRequestString)
//				.andExpect(status().isCreated()));
		//Assertions.assertEquals(1,productRepository.findAll().size());
//	}

//	private ProductRequest getProductRequest() {
//		return ProductRequest.builder().name("iPhone").description("iphone12").price(1200).build();
//	}

}
