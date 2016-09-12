package it.negro.lm.rest;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import it.negro.lm.entity.Item;
import it.negro.lm.entity.ItemCategory;
import it.negro.lm.entity.Receipt;
import it.negro.lm.service.CategoryService;
import it.negro.lm.service.ReceiptService;

@RestController
public class LmRestController {

    private CategoryService categoryService;
    private ReceiptService receiptService;
    
    @Autowired
    public void setReceiptService(ReceiptService receiptService) {
		this.receiptService = receiptService;
	}
    
    @Autowired
    public void setCategoryService(CategoryService categoryService) {
		this.categoryService = categoryService;
	}

    @RequestMapping(value = "/receipt", method = RequestMethod.POST)
    public @ResponseBody Receipt getReceipt(@RequestBody Item[] items){
    	List<Item> itemList = Arrays.asList(items);
    	return receiptService.calutate(itemList);
    }
    
    @RequestMapping("/categories")
    public List<ItemCategory> getCategories(){
    	return categoryService.getAll();
    }
    
}
