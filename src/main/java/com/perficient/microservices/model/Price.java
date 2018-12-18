package com.perficient.microservices.model;

import java.math.BigDecimal;

public class Price extends MongoDbBase{

	private BigDecimal basePrice;
	private BigDecimal shippingCharge;
	private BigDecimal discount;
	private BigDecimal total;

	public BigDecimal getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(BigDecimal basePrice) {
		this.basePrice = basePrice;
	}

	public BigDecimal getShippingCharge() {
		return shippingCharge;
	}

	public void setShippingCharge(BigDecimal shippingCharge) {
		this.shippingCharge = shippingCharge;
	}

	public BigDecimal getDiscount() {
		return discount;
	}

	public void setDiscount(BigDecimal discount) {
		this.discount = discount;
	}

	public BigDecimal getTotal() {
		this.total = (this.basePrice.add(this.shippingCharge)).subtract(this.discount);
		return total;
	}

	@Override
	public String toString() {
		return "Price [basePrice=" + basePrice + ", shippingCharge=" + shippingCharge + ", discount=" + discount
				+ ", total=" + total + "]";
	}

}