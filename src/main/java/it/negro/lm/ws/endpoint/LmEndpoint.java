package it.negro.lm.ws.endpoint;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import it.negro.lm.entity.Item;
import it.negro.lm.entity.ItemCategory;
import it.negro.lm.entity.Receipt;
import it.negro.lm.service.CategoryService;
import it.negro.lm.service.ReceiptService;
import it.negro.lm.ws.GetCategoriesRequest;
import it.negro.lm.ws.GetCategoriesResponse;
import it.negro.lm.ws.GetCategoriesResponse.Categories;
import it.negro.lm.ws.GetCategoriesResponse.Categories.Category;
import it.negro.lm.ws.GetReceiptRequest;
import it.negro.lm.ws.GetReceiptResponse;

@Endpoint
public class LmEndpoint {

	private ReceiptService receiptService;
	private CategoryService categoryService;

	@Autowired
	public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}
	
	@Autowired
	public void setReceiptService(ReceiptService receiptService) {
		this.receiptService = receiptService;
	}

	@PayloadRoot(namespace = "http://negro.it/lm/ws", localPart = "getReceiptRequest")
	@ResponsePayload
	public GetReceiptResponse getReceipt(@RequestPayload GetReceiptRequest request) {
		GetReceiptResponse response = new GetReceiptResponse();
		List<Item> items = new ArrayList<Item>();
		request.getItems().getItem().forEach(i -> {
			Item item = new Item();
			item.setId(i.getId());
			item.setImported(i.isImported());
			item.setName(i.getName());
			item.setNominalPrice(i.getNominalPrice());
			item.setQuantity(i.getQuantity());
			ItemCategory ic = categoryService.get(i.getCategoryId());
			item.setCategory(ic);
			items.add(item);
		});
		response.setItems(new GetReceiptResponse.Items());
		Receipt receipt = receiptService.calutate(items);
		receipt.getItems().forEach(i -> {
			GetReceiptResponse.Items.Item item = new GetReceiptResponse.Items.Item();
			item.setFinalPrice(i.getFinalPrice());
			item.setId(i.getId());
			item.setName(i.getName());
			item.setQuantity(i.getQuantity());
			response.getItems().getItem().add(item);
		});
		response.setAmount(receipt.getAmount());
		response.setTaxesAmount(receipt.getTaxesAmount());
		return response;
	}
	
	@PayloadRoot(namespace = "http://negro.it/lm/ws", localPart = "getCategoriesRequest")
	@ResponsePayload
	public GetCategoriesResponse getCategories(@RequestPayload GetCategoriesRequest request) {
		GetCategoriesResponse response = new GetCategoriesResponse();
		List<ItemCategory> categories = categoryService.getAll();
		Categories wsCategories = new Categories();
		categories.forEach(c -> {
			Category wsCat = new Category();
			wsCat.setId(c.getId());
			wsCat.setName(c.getName());
			wsCat.setImportTaxRate(c.getImportTaxRate());
			wsCat.setSaleTaxRate(c.getSaleTaxRate());
			wsCat.setTaxExempt(c.isTaxExempt());
			wsCategories.getCategory().add(wsCat);
		});
		response.setCategories(wsCategories);
		return response;
	}
}
