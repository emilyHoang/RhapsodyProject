package com.rhapsody.sale;

import java.math.BigDecimal;

/** Sale Item contains all attributes such as price, percentage tax, 
* total sale tax, amount of the same item. It will be able to calculate
* its own tax given amount, salePrice, name, and tax percentage
* 
* @author Emily Hoang
* 
*/
public class SaleItem {
	protected double salePrice;
	protected int taxPercentage;
	protected double saleTax;
	protected double totalSalePrice;
	protected int amount;
	protected String name;
	
	/** Constructor of sale tax
	 *
	 */
	
	SaleItem(int amount, double salePrice, String name, int taxPercentage){
		this.taxPercentage = taxPercentage;
		this.amount = amount;
		this.salePrice = salePrice;
		this.name = name;
	}
	public double getSalePrice() {
		return salePrice;
	}
	public void setSalePrice(float salePrice) {
		this.salePrice = salePrice;
	}
	public int getTaxPercentage() {
		return taxPercentage;
	}
	
	/** Calculation of sale tax
	 * 
	 * @return			value of sale tax - double
	 */
	public double getSaleTax() {
		this.saleTax = this.amount * salePrice * (taxPercentage/100.0);	
		double reducedVal = new BigDecimal(String.valueOf(this.saleTax)).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
		int difference = (int) (reducedVal*100);
		if(difference%5 != 0)
			reducedVal += (5-(difference%5))/100.0;
		return this.saleTax = OrderHelper.convertDecimal(reducedVal);
	}
	
	/** Calculation of total price for the sale item
	 * 
	 * @return			value of total price - double
	 */
	public double getTotalSalePrice() {
		getSaleTax();
		return this.totalSalePrice = OrderHelper.convertDecimal(this.amount * this.salePrice + this.saleTax);
	}
	
	
	public String toString() {
		getTotalSalePrice();
		return amount + " " + name + " : " + this.totalSalePrice;
	}
}
