package com.rhapsody.sale;

import java.util.ArrayList;
import java.util.List;

/** Order class consists of all sale items. 
* It can calculate its own totalSaleTax and order total
* @author Emily Hoang
* 
*/
public class Order {
	protected List<SaleItem> items;
	protected double totalSaleTax;
	protected double total;
	protected OrderHelper helper = OrderHelper.getInstance();
	Order() {
		super();
		items = new ArrayList<SaleItem>();
	}
	
	Order(List<SaleItem> items) {
		this.items = items;
	}
	
	/** 
	 * Constructor of order
	 * Populate list of saleItems from orderLines
	 * @param orderLines
	 * 
	 */
	Order(String[] orderLines) {
		items = new ArrayList<SaleItem>();
		for(String orderLine : orderLines ) {
			 addToOrder(orderLine);
		}
	}
	
	/**
	 * Add to order from each orderline string
	 * @param orderLine
	 */
	public void addToOrder(String orderLine) {
		addToOrder(helper.convertToSaleItem(orderLine));
	}
	
	public void addToOrder(SaleItem item) {
		items.add(item);
		calculateTotalTax();
	}
	
	public double getTotalSaleTax() {
		return this.totalSaleTax;
	}
	
	public double getTotal() {
		return this.total;
	}
	
	/**
	 * Calculate order totalTax and order total
	 * by summing up all taxes and totals of all orderline
	 */
	private void calculateTotalTax() {
		this.totalSaleTax = 0;
		this.total = 0;
		for(SaleItem item: this.items) {
			totalSaleTax += item.getSaleTax();
			total += item.getTotalSalePrice();
		}
	}
	
	/**
	 * String output of order
	 */
	public String toString() {
		StringBuffer output = new StringBuffer();
		for(SaleItem item: this.items) {
			output.append(item.toString());
			output.append("\n");
		}
		calculateTotalTax();
		output.append("Sales Tax: "+OrderHelper.convertDecimal(this.totalSaleTax));
		output.append("\n");
		output.append("Total: " +OrderHelper.convertDecimal(this.total));
		return output.toString();
	}
}
