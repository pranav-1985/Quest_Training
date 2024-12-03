package com.quest.collections.questions;

import java.util.Map;
import java.util.TreeMap;

public class ProductMap {
    public static void main(String[] args) {
        Map<String, Integer> product = new TreeMap<String, Integer>();
        product.put("Apple", 100);
        product.put("Banana", 20);
        product.put("Orange", 90);
        product.put("Grapes", 200);
        product.put("Pineapple", 50);

        product.put("Orange", 80);

        String highestPriceProduct = "";
        int highestPrice = 0;
        
        for (Map.Entry<String, Integer> entry : product.entrySet()) {
            if (entry.getValue() > highestPrice) {
                highestPrice = entry.getValue();
                highestPriceProduct = entry.getKey();
            }
        }

        System.out.println("Highest priced product: " + highestPriceProduct + " - " + highestPrice);
    }
}
