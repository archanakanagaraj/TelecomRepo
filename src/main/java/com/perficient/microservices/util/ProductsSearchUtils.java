package com.perficient.microservices.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.perficient.microservices.model.Product;
import com.perficient.microservices.model.Error;

@Component
public class ProductsSearchUtils {

	@Autowired
	Gson gson;

	public String toJson(Object o) {

		return gson.toJson(o);
	}

	public String defaultErrorServiceInaccessible() {

		Product p = new Product();
		Error error = new Error("ERR2", "The Product Search Service is inaccessible");
		p.setError(error);
		return toJson(p);

	}

}
