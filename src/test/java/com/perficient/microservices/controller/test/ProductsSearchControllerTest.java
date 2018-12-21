package com.perficient.microservices.controller.test;

import com.perficient.microservices.controller.ProductsSearchController;
import com.perficient.microservices.model.*;
import com.perficient.microservices.service.ProductsSearchService;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.ArrayList;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ProductsSearchControllerTest {
	
	static List<Product> products;
	static Product product;
	static Product product2;
	
	
	
	@Mock
	ProductsSearchService productService;
	
	ProductsSearchController productController = new ProductsSearchController();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		product = new Product();
		product.setId(String.valueOf("28481675540731914413735584123"));
		product.setBandwidth("100MB");
		product.setBuildingExtn("100200");
		product.setName("STORM");
		product.setRouter("NETGEAR");
		product.setTransport("NTP");
		Price price = new Price();
		price.setBasePrice(BigDecimal.valueOf(20));
		price.setDiscount(BigDecimal.valueOf(0));
		price.setShippingCharge(BigDecimal.valueOf(2));
		product.setPrice(price);
		
		product2 = new Product();
		product2.setId(String.valueOf("28481675540731914413735584125"));
		product2.setBandwidth("150MB");
		product2.setBuildingExtn("104500");
		product2.setName("THUNDER");
		product2.setPrice(price);
		
		products = new ArrayList<Product>();
		products.add(product);
		products.add(product2);
	}

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		
		Mockito.when(productService.retrieveAll()).thenReturn(products);
		
		Mockito.when(productService.find(String.valueOf("28481675540731914413735584123"))).thenReturn(product);
		Mockito.when(productService.find(String.valueOf("28481675540731914413735584125"))).thenReturn(product2);
		
		Mockito.when(productService.findByName("STORM")).thenReturn(product);
		Mockito.when(productService.findByName("THUNDER")).thenReturn(product2);
		
		
		productController.setProductSearchSrvc(productService);
	}

	@Test
	public void testGetAllProducts() {
		assertNotNull(productController.getAllProducts());
		assertEquals(2, productController.getAllProducts().size());
	}

	

	@Test
	public void testFindProductByID() {
		assertEquals("STORM" , productController.findProductByID(String.valueOf("28481675540731914413735584123")).getName());		
		assertEquals("THUNDER" , productController.findProductByID(String.valueOf("28481675540731914413735584125")).getName());	
	}

	@Test
	public void testFindProductByName() {
		assertEquals("100MB" , productController.findProductByName("STORM").getBandwidth());		
		assertEquals("150MB" , productController.findProductByName("THUNDER").getBandwidth());	
	}

	

}
