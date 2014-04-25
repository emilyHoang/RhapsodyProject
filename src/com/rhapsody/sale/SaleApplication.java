package com.rhapsody.sale;
/**
 * Main application to test Order system
 * 
 * @author Emily Hoang
 * 
 */
public class SaleApplication {
	public static void main (String[] args) {
		String[] orderLines = { "1 book at 12.49", "1 music CD at 14.99" , "1 chocolate bar at 0.85" };
		Order order = new Order(orderLines);
		System.out.println(order.toString());
		
		String[] orderLines2 = { "1 imported box of chocolates at 10.00", "1 imported bottle of perfume at 47.50" };
		Order order2 = new Order(orderLines2);
		System.out.println(order2.toString());
		
		String[] orderLines3 = { "1 imported bottle of perfume at 27.99", "1 bottle of perfume at 18.99" , "1 packet of headache pills at 9.75" , "1 box of imported chocolates at 11.25"};
		Order order3 = new Order(orderLines3);
		System.out.println(order3.toString());

	}
}
