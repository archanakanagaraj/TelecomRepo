package com.perficient.microservices.model;

import org.springframework.data.annotation.Id;

public class MongoDbBase {
	
	@Id
	private String _id;

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

}
