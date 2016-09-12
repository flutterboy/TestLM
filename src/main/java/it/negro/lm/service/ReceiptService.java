package it.negro.lm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import it.negro.lm.entity.Item;
import it.negro.lm.entity.Receipt;

@Service
public class ReceiptService {
	
	public Receipt calutate(List<Item> items){
		Receipt summary = new Receipt();
		summary.addItems(items);
		return summary;
	}
	
}
