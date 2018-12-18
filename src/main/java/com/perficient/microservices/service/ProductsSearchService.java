package com.perficient.microservices.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.perficient.microservices.model.Product;

@FeignClient(name = "product-micro-service")
public interface ProductsSearchService {

	/**
	 * Fetch Product string by Product ID
	 * 
	 * @param id - Product ID
	 * @return - Product Object
	 */
	@RequestMapping(method = RequestMethod.GET, path = "/products/search/id/{id}", produces = "application/json")
	public Product find(String id);

	/**
	 * Fetch Product string by Product name
	 * 
	 * @param id - Product name
	 * @return - Product Object
	 */
	@RequestMapping(method = RequestMethod.GET, path = "/products/search/name/{name}", produces = "application/json")
	public Product findByName(String name);

	/**
	 * Retrieve all Products with their product id's
	 * 
	 * @return Map of <Product ID, Product>
	 */
	@RequestMapping(method = RequestMethod.GET, produces = "application/json", path = "/products/all")
	public List<Product> retrieveAll();

	/**
	 * @param product
	 * @return
	 */
	@RequestMapping(path = "/products/create", produces = "application/json", consumes = "application/json")
	public Product create(Product product);

	/**
	 * @param p
	 * @return
	 */
	@RequestMapping(path = "/products/delete", produces = "application/json", consumes = "application/json")
	public Boolean delete(Product p);

	/**
	 * @param id
	 * @return
	 */
	@RequestMapping(path = "/products/delete/{id}", produces = "application/json")
	public Boolean delete(String id);

	/**
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET, produces = "application/json", path = "/produces/list")
	public List<String> retrieveProductNames();

}
