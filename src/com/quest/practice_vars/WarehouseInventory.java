package com.quest.practice_vars;

public class WarehouseInventory {

    public static void main(String[] args) {
        // Step 1: Initialize product names, warehouse quantities, and branch stock
        String[] productNames = {"Laptop", "Phone", "Tablet", "Headphones", "Smartwatch"};
        int[] warehouseStock = {120, 150, 100, 200, 80};
        int[][] branchStock = {
                {50, 30, 60},  // Laptop stock across 3 branches
                {40, -1, 60},  // Phone stock (missing in Branch 2)
                {30, 20, 15},  // Tablet stock
                {100, 90, 80}, // Headphones stock
                {50, 55, -1}   // Smartwatch stock (missing in Branch 3)
        };

//        // Step 2: Call methods to perform the required tasks
//        // Task 1: Calculate and print total stock for each product
//        calculateTotalStock(productNames, warehouseStock, branchStock);
//
//        // Task 2: Find and print product with the maximum total stock
//        findMaxStockProduct(productNames, warehouseStock, branchStock);
//
//        // Task 3: Rank products by total stock and print ranking
//        rankProductsByStock(productNames, warehouseStock, branchStock);
//
//        // Task 4: Detect and print missing stock data
//        detectMissingData(productNames, branchStock);
    }

}