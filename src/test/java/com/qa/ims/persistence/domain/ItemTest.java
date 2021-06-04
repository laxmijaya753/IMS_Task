package com.qa.ims.persistence.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;



import nl.jqno.equalsverifier.EqualsVerifier;

public class ItemTest {
	private Item item ;
	
	Long item_id=(long) 5;
	 String name="cap";
	 Double value1=(double) 5;
	
	@Test
	public void testEquals() {
		EqualsVerifier.simple().forClass(Item.class).verify();
	}
	
	@Test
	public void ConstructorOneTest()
	
	{
		item=new Item(item_id,name,value1);
		
		
		//assertEquals(item,item.getItem());
		assertEquals(item_id,item.getItem_id());
		assertEquals(name,item.getName());
		assertEquals(value1,item.getValue1());
		//assertEquals("Ram",customer.getSurname());
		
		assertTrue(item instanceof Item);
		assertNotNull(item);
	}

	
	@Test
	public void ConstructorTwoTest()
	
	{
   item=new Item(item_id,name,value1);
		
		
		//assertEquals(item,item.getItem());
		assertEquals(item_id,item.getItem_id());
		assertEquals(name,item.getName());
		assertEquals(value1,item.getValue1());
		//assertEquals("Ram",customer.getSurname());
		
		assertTrue(item instanceof Item);
		assertNotNull(item);
	}
	
	
	

}
