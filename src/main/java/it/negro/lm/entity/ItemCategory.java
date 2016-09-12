package it.negro.lm.entity;

public class ItemCategory {
	
	private Integer id;
	private String name;
	private Double importTaxRate = 0.00;
	private Double saleTaxRate = 0.00;
	private boolean taxExempt;
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
	public void setImportTaxRate(Double importTaxRate) {
		this.importTaxRate = importTaxRate;
	}
	public Double getImportTaxRate() {
		return importTaxRate;
	}
	public boolean isTaxExempt() {
		return taxExempt;
	}
	public void setSaleTaxRate(Double saleTaxRate) {
		this.saleTaxRate = saleTaxRate;
	}
	public Double getSaleTaxRate() {
		return saleTaxRate;
	}
	
}
