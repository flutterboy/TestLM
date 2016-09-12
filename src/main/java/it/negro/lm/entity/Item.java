package it.negro.lm.entity;

import it.negro.lm.LmUtils;

public class Item {

	private Integer id;
	private String name;
	private Double nominalPrice;
	private boolean imported;
	private Double saleTaxRate;
	private Double importTaxRate;
	private Integer quantity;
	private ItemCategory category;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setNominalPrice(Double nominalPrice) {
		this.nominalPrice = nominalPrice;
	}
	public Double getNominalPrice() {
		return Math.round(nominalPrice * 100) / 100.0;
	}
	public ItemCategory getCategory() {
		return category;
	}
	public void setCategory(ItemCategory category) {
		this.category = category;
	}
	public boolean isTaxExempt(){
		return this.category != null && this.getCategory().isTaxExempt();
	}
	public void setImported(boolean imported) {
		this.imported = imported;
	}
	public boolean isImported() {
		return imported;
	}
	public Double getSaleTaxRate() {
		return saleTaxRate;
	}
	public void setSaleTaxRate(Double saleTaxRate) {
		this.saleTaxRate = saleTaxRate;
	}
	public Double getImportTaxRate() {
		return importTaxRate;
	}
	public void setImportTaxRate(Double importTaxRate) {
		this.importTaxRate = importTaxRate;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public Double getAmount() {
		return Math.round(nominalPrice * quantity * 100) / 100.0;
	}
	public Double getSaleTaxAmount(){
		if (this.isTaxExempt())
			return 0.00;
		Double rateToUse = null;
		if (this.saleTaxRate != null)
			rateToUse = this.saleTaxRate;
		else
			rateToUse = this.category.getSaleTaxRate();
		Double saleTaxAmount = nominalPrice * quantity * rateToUse / 100;
		return LmUtils.roundUp05(saleTaxAmount);
	}
	public Double getImportTaxAmount(){
		if (!isImported())
			return 0.00;
		Double rateToUse = null;
		if (this.importTaxRate != null)
			rateToUse = this.importTaxRate;
		else
			rateToUse = this.category.getImportTaxRate();
		Double importTaxAmount = nominalPrice * quantity * rateToUse / 100;
		return LmUtils.roundUp05(importTaxAmount);
	}
	public Double getTotalTaxAmount(){
		return getImportTaxAmount() + getSaleTaxAmount();
	}
	public Double getFinalPrice(){
		Double p = nominalPrice * quantity + getTotalTaxAmount();
		return Math.round(p * 100) / 100.0;
	}

}
