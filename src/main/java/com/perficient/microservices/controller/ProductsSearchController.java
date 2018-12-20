package com.perficient.microservices.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.perficient.microservices.model.Product;
import com.perficient.microservices.service.ProductsSearchService;
import com.perficient.microservices.model.Error;
import com.perficient.microservices.util.ProductsSearchUtils;

import io.swagger.annotations.ApiOperation;

@CrossOrigin
@RestController
@RequestMapping(path = "/products")
public class ProductsSearchController {

	private static final Logger log = LoggerFactory.getLogger(ProductsSearchController.class);

	@Autowired
	ProductsSearchService productSearchSrvc;

	@Autowired
	ProductsSearchUtils productsSearchUtils;

	@Autowired
	Gson gson;

	@RequestMapping(method = RequestMethod.GET, produces = "application/json", path = "/all")
	@ApiOperation(value = "Retrieve all Products from Database")
	public List<Product> getAllProducts() {

		System.out.println("getAllProducts");
		List<Product> products = productSearchSrvc.retrieveAll();
		return products;// productsSearchUtils.toJson(products);
	}

	@RequestMapping(method = RequestMethod.GET, produces = "application/json", path = "/list")
	public List<String> listProductNames() {
		System.out.println("listProductNames: ");

		List<String> products = productSearchSrvc.retrieveProductNames();
		return products;
	}

	@RequestMapping(method = RequestMethod.GET, path = "/search/id/{id}", produces = "application/json")
	@ApiOperation(value = "Retrieve a Product from DB based on its ID")
	public String findProductByID(@PathVariable("id") String id) {

		return productsSearchUtils.toJson(productSearchSrvc.find(id));
	}

	@RequestMapping(method = RequestMethod.GET, path = "/search/name/{name}", produces = "application/json")
	@ApiOperation(value = "Retrieve a Product from DB based on its name")
	public String findProductByName(@PathVariable("name") String name) {

		return productsSearchUtils.toJson(productSearchSrvc.findByName(name));
	}

	@RequestMapping(path = "/delete/{id}", produces = "application/json")
	@ApiOperation(value = "Remove document by Product id")
	public String deleteById(@PathVariable("id") String id) {

		Product prod = productSearchSrvc.find(id);

		if (!productSearchSrvc.delete(id)) {
			Product p = new Product();
			p.setId(id);
			Error error = new Error("ERR1", "Product could not be found");
			p.setError(error);
			return productsSearchUtils.toJson(p);
		}

		return productsSearchUtils.toJson(prod);

	}

	@RequestMapping(path = "/delete", produces = "application/json", consumes = "application/json")
	@ApiOperation(value = "Remove document by Product request body")
	public String deleteByProduct(@RequestBody Product p) {

		if (!productSearchSrvc.delete(p.getId())) {
			Error error = new Error("ERR1", "Product could not be found");
			p.setError(error);
			return productsSearchUtils.toJson(p);
		}

		return productsSearchUtils.toJson(p);

	}

	@RequestMapping(path = "/create", produces = "application/json", consumes = "application/json")
	@ApiOperation(value = "Create a new Product")
	public Product insert(@RequestBody Product p) {

		Product productInserted = productSearchSrvc.create(p);
		return productInserted;
	}

}
