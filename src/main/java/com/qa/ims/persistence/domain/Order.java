package com.qa.ims.persistence.domain;

public class Order {

	private Long order_id;
	private	Long customer_id;
	private Long item_id1;
	private String item_name;
	private Long quantity;
	private Double cost;
	
	

	public Order(Long customer_id, Long item_id1,String item_name,Long quantity,Double cost) {
		this.setCustomer_id(customer_id);
		this.setItem_id1(item_id1);
		this.setItem_name(item_name);
		this.setQuantity(quantity);
		this.setCost(cost);
		
	}

	

	public Order(Long order_id,Long customer_id, Long item_id1,String item_name,Long quantity,Double cost) {
		this.setOrder_id(order_id);
		this.setCustomer_id(customer_id);
		this.setItem_id1(item_id1);
		this.setItem_name(item_name);
		this.setQuantity(quantity);
		this.setCost(cost);
		
	}
	
	
	
	
	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost= cost;
	}

	

	public void setItem_name(String item_name) {
		this.item_name= item_name;
	}
	
	public String getItem_name() {
		return item_name;
	}
	
	

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity= quantity;
	}
	
	
	

	public Long getOrder_id() {
		return order_id;
	}

	public void setOrder_id(Long order_id) {
		this.order_id = order_id;
	}

	public Long getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(Long customer_id) {
		this.customer_id =customer_id;
	}

	public Long getItem_id1() {
		return item_id1;
	}

	public void setItem_id1(Long item_id1) {
		this.item_id1 = item_id1;
	}

	@Override
	public String toString() {
		return " Order id:" +  order_id + " Customer id:" + customer_id + " Item id:" + item_id1 + " Item Name:" + item_name + " Quantity:" + quantity+ " Cost:" + cost ;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customer_id == null) ? 0 :customer_id.hashCode());
		result = prime * result + ((order_id == null) ? 0 : order_id.hashCode());
		result = prime * result + ((item_id1 == null) ? 0 : item_id1.hashCode());
		result = prime * result + ((item_name== null) ? 0 : item_name.hashCode());
		result = prime * result + ((quantity== null) ? 0 : quantity.hashCode());
		result = prime * result + ((cost== null) ? 0 : cost.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (getCustomer_id() == null) {
			if (other.getCustomer_id() != null)
				return false;
		} else if (!getCustomer_id().equals(other.getCustomer_id()))
			return false;
		if (order_id == null) {
			if (other.order_id != null)
				return false;
		} else if (!order_id.equals(other.order_id))
			return false;
		if (item_id1 == null) {
			if (other.item_id1 != null)
				return false;
		} else if (!item_id1.equals(other.item_id1))
			return false;
		
		
	
		if (item_name == null) {
			if (other.item_name != null)
				return false;
		} else if (!item_name.equals(other.item_name))
			return false;
		
		

		if (quantity == null) {
			if (other.quantity != null)
				return false;
		} else if (!quantity.equals(other.quantity))
			return false;
		


		if (cost == null) {
			if (other.cost!= null)
				return false;
		} else if (!cost.equals(other.cost))
			return false;
		
		
		
		return true;
	}

}
