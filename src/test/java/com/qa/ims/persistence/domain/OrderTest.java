
package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;



import nl.jqno.equalsverifier.EqualsVerifier;

public class OrderTest {
	private  Order order ;
	 Long order_id=(long) 1;
			Long customer_id=(long) 1;
		 Long item_id1=(long) 1;
	 String item_name="phone";
		Long quantity=(long) 25.00;
		 Double cost=1.25;
	
//Long id=(long) 1;
	@Test
	public void testEquals() {
		EqualsVerifier.simple().forClass(Order.class).verify();
	}
	
	@Test
	public void ConstructorOneTest()
	
	{
		order=new Order(order_id,customer_id, item_id1,item_name,quantity,cost);
		
		assertEquals(order_id,order.getOrder_id());
		assertEquals(customer_id,order.getCustomer_id());
		assertEquals(item_id1,order.getItem_id1());
		assertEquals(item_name,order.getItem_name());
		assertEquals(quantity,order.getQuantity());
		assertEquals(cost,order.getCost());
		
		assertTrue(order instanceof Order);
		assertNotNull(order);
	}

	@Test
	public void ConstructorTwoTest()
	
	{
		order=new Order(customer_id, item_id1,item_name,quantity,cost);
		
		//assertEquals(order_id,order.getOrder_id());
		assertEquals(customer_id,order.getCustomer_id());
		assertEquals(item_id1,order.getItem_id1());
		assertEquals(item_name,order.getItem_name());
		assertEquals(quantity,order.getQuantity());
		assertEquals(cost,order.getCost());
		
		assertTrue(order instanceof Order);
		assertNotNull(order);
	}

	
	

}
