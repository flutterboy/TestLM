package it.negro.lm.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import it.negro.lm.entity.Item;
import it.negro.lm.entity.Receipt;
import it.negro.lm.service.ReceiptService;

public class TaxCalculationTest {

	@Test
	public void testInput1() throws IOException {
		ReceiptService stcs = new ReceiptService();
		Receipt ps = stcs.calutate(getItems("items_1.json"));
		System.out.println(ps);
		assertNotNull(ps.getItems());
		assertEquals(3, ps.getItems().size());
		assertEquals(12.49, ps.getItems().get(0).getFinalPrice(), 0.01);
		assertEquals(16.49, ps.getItems().get(1).getFinalPrice(), 0.01);
		assertEquals(0.85, ps.getItems().get(2).getFinalPrice(), 0.01);
		assertEquals(1.5, ps.getTaxesAmount(), 0.0);
		assertEquals(29.83, ps.getAmount(), 0.1);
	}
	
	@Test
	public void testInput2() throws IOException {
		ReceiptService stcs = new ReceiptService();
		Receipt ps = stcs.calutate(getItems("items_2.json"));
		System.out.println(ps);
		assertNotNull(ps.getItems());
		assertEquals(2, ps.getItems().size());
		assertEquals(10.50, ps.getItems().get(0).getFinalPrice(), 0.01);
		assertEquals(54.65, ps.getItems().get(1).getFinalPrice(), 0.01);
		assertEquals(7.65, ps.getTaxesAmount(), 0.0);
		assertEquals(65.15, ps.getAmount(), 0.01);
	}

	@Test
	public void testInput3() throws IOException {
		ReceiptService stcs = new ReceiptService();
		Receipt ps = stcs.calutate(getItems("items_3.json"));
		System.out.println(ps);
		assertNotNull(ps.getItems());
		assertEquals(4, ps.getItems().size());
		assertEquals(32.19, ps.getItems().get(0).getFinalPrice(), 0.01);
		assertEquals(20.89, ps.getItems().get(1).getFinalPrice(), 0.01);
		assertEquals(9.75, ps.getItems().get(2).getFinalPrice(), 0.01);
		assertEquals(11.85, ps.getItems().get(3).getFinalPrice(), 0.01);
		assertEquals(6.70, ps.getTaxesAmount(), 0.0);
		assertEquals(74.68, ps.getAmount(), 0.1);
	}
	
	private List<Item> getItems(String file) throws IOException {
		InputStream itemStream = null;
		List<Item> result = null;
		try {
			itemStream = Thread.currentThread().getContextClassLoader().getResourceAsStream(file);
			ObjectMapper om = new ObjectMapper();
			Item[] itemsArray = om.readValue(itemStream, Item[].class);
			result = Arrays.asList(itemsArray);
		} finally {
			if (itemStream != null)
				itemStream.close();
		}

		return result;
	}

}
