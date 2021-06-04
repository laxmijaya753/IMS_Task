package com.qa.ims.persistence.domain;

public class Item {

	private Long item_id;
	private String name;
	//private Double value;
	private Double value1;

	public Item(String name, Double value1) {
		this.setName(name);
		this.setValue1(value1);
	}

	public Item(Long item_id, String name, Double value1) {
		this.setItem_Id(item_id);
		this.setName(name);
		this.setValue1(value1);
	}

	public void setItem_Id(Long item_id) {
		this.item_id = item_id;
	}





	public Long getItem_id() {
		return item_id;
	}

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getValue1() {
		return value1;
	}

	public void setValue1(Double value1) {
		this.value1 = value1;
	}
	
	
	
	
	

	@Override
	public String toString() {
		return "id:" + item_id + " item name:" + name + " value:" + value1;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((item_id == null) ? 0 : item_id.hashCode());
		result = prime * result + ((value1 == null) ? 0 : value1.hashCode());
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
		Item other = (Item) obj;
		if (getName() == null) {
			if (other.getName() != null)
				return false;
		} else if (!getName().equals(other.getName()))
			return false;
		if (item_id == null) {
			if (other.item_id != null)
				return false;
		} else if (!item_id.equals(other.item_id))
			return false;
		if (value1== null) {
			if (other.value1 != null)
				return false;
		} else if (!value1.equals(other.value1))
			return false;
		return true;
	}

}
