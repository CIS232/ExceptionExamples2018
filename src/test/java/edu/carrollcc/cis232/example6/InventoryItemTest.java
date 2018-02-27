package edu.carrollcc.cis232.example6;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class InventoryItemTest {

	@Test
	public void setDescriptionThrowsException() {
		InventoryItem item = new InventoryItem("description");
		try{
			item.setDescription("");
			fail("IllegalArgumentException should have been thrown");
		} catch (IllegalArgumentException e){
			assertThat(e.getMessage(), is("Description is an empty string."));
		}
	}

	@Test
	public void setUnits() {
	}

	@Test
	public void getDescription() {
	}

	@Test
	public void getUnits() {
	}
}