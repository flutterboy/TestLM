package it.negro.lm.entity;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.LinkedList;
import java.util.List;

import it.negro.lm.LmUtils;

public class Receipt {

	private List<Item> items = new LinkedList<Item>();
	private Double amount = 0.00;
	private Double taxesAmount = 0.00;

	public void addItems(List<Item> items) {
		for (Item item : items)
			addItem(item);
	}
	
	public List<Item> getItems() {
		return items;
	}

	public Double getAmount() {
		return Math.round(amount * 100) / 100.0;
	}

	public Double getTaxesAmount() {
		return LmUtils.roundUp05(taxesAmount);
	}

	public void addItem(Item item) {
		this.items.add(item);
		this.amount += item.getFinalPrice();
		this.taxesAmount += item.getTotalTaxAmount();
	}

	public void removeItem(Item item) {
		boolean removed = items.removeIf(i -> i.getId().equals(item.getId()));
		if (removed){
			this.amount -= item.getTotalTaxAmount();
			this.taxesAmount -= item.getTotalTaxAmount();
		}
	}
	
	@Override
	public String toString() {
		DecimalFormatSymbols symbols = new DecimalFormatSymbols();
		symbols.setDecimalSeparator('.');
		symbols.setGroupingSeparator(',');
		DecimalFormat format = new DecimalFormat("0.00", symbols);
		StringBuilder sb = new StringBuilder();
		sb.append("##############################");
		sb.append('\n');
		items.forEach(i -> {
			sb.append(i.getQuantity());
			sb.append(" ");
			sb.append(i.getName());
			sb.append(" at ");
			sb.append(format.format(i.getFinalPrice()));
			sb.append('\n');
		});
		sb.append("Sales Taxes: ");
		sb.append(format.format(getTaxesAmount()));
		sb.append('\n');
		sb.append("Total: ");
		sb.append(format.format(getAmount()));
		sb.append('\n');
		sb.append("##############################");
		return sb.toString();
	}

}
