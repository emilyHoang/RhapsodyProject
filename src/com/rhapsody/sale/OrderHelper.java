package com.rhapsody.sale;

import java.math.BigDecimal;
import java.util.Hashtable;

/**
 * OrderHelper class consists static functionalities which help creating order
 * 
 * @author Emily Hoang
 * 
 */
public class OrderHelper {
	private static Hashtable<String, Integer> orderType;
	private static final int SALE_ITEM = 10;
	private static final int EXEMPT_ITEM = 0;
	private static final int IMPORTED_ITEM = 5;

	private static OrderHelper instance = null;
	/**
	 * Constructor of OrderHelper to populate hashtable
	 * to test if orderline contains certain type of item
	 * This hashtable helps figuring out tax value
	 */
	private OrderHelper() {
		orderType = new Hashtable<String, Integer>();
		orderType.put("book", EXEMPT_ITEM);
		orderType.put("CD", SALE_ITEM);
		orderType.put("perfume", SALE_ITEM);
		orderType.put("chocolate", EXEMPT_ITEM);
		orderType.put("pill", EXEMPT_ITEM);
		orderType.put("imported", IMPORTED_ITEM);
	}

	/**
	 * Singleton to only return one OrderHelper
	 * @return
	 */
	public static OrderHelper getInstance() {
		if (instance == null) {
			instance = new OrderHelper();
		}
		return instance;
	}

	/**
	 * Convert orderLine in form of string to saleItem object
	 * @param orderLine
	 * @return SaleItem
	 */
	public SaleItem convertToSaleItem(String orderLine) {

		int amount = Character.getNumericValue(orderLine.charAt(0));
		int indexOfAt = orderLine.lastIndexOf("at");
		String item = orderLine.substring(1, indexOfAt);
		String salePriceString = orderLine.substring(indexOfAt + 2);
		double salePrice = Double.parseDouble(salePriceString);
		int itemType = 0;
		
		for (String key : orderType.keySet()) {
			if (item.contains(key)) {
				itemType += (orderType.get(key)).intValue();
			}
		}
		
		return new SaleItem(amount, salePrice, item, itemType);
	}

	/**
	 * Static function to convert to 2 decimals
	 * @param value
	 * @return double
	 */
	public static double convertDecimal(double value) {
		return new BigDecimal(String.valueOf(value)).setScale(2,
				BigDecimal.ROUND_HALF_UP).doubleValue();
	}
}
