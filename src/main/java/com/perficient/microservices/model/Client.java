package com.perficient.microservices.model;

import org.apache.commons.lang.StringUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
@Document(collection = "client")
public class Client {

	@Id
	private String company;
	private String name;
	private String email;
	private String phone;
	private Address address;
	private Product product;
	// private String status;

	// Defines the enumeration of acceptable values for the Client - Action
	// field
	// Accepted values are C - Create and U - Update
	public enum ClientAction {
		C, U;
	}

	// Defines the enumeration of acceptable values for the Client - Status
	// field
	// Accepted values are P- Processing, A - Activate and D - Deactivate
	public enum ClientStatus {
		/*P, A, D;

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return super.toString();
		}*/
		 P("P"),
		    A("A"),
		    D("D");

		    private String shortName;

		    ClientStatus (String shortName) {
		        this.shortName = shortName;
		    }

		    @Override
		    public String toString() {
		        return shortName;
		    }

		    @JsonCreator
		    public static ClientStatus create (String value) {
		        if(StringUtils.isBlank(value)) {
		        	return ClientStatus.P;
		        }
		        for(ClientStatus v : values()) {
		            if(value.equals(v.getShortName())) {
		                return v;
		            }
		        }
		        throw new IllegalArgumentException();
		    }

		    public String getShortName() {
		        return shortName;
		    }
		
	}

	private ClientAction action;

	private ClientStatus status;

	public ClientAction getAction() {
		return action;
	}

	public void setAction(ClientAction action) {
		this.action = action;
	}

	public ClientStatus getStatus() {
		return status;
	}

	public void setStatus(ClientStatus status) {
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	/*
	 * public String getStatus() { return status; }
	 * 
	 * public void setStatus(String status) { this.status = status; }
	 */
}
