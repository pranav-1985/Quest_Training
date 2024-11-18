package com.quest.test;

import java.util.Scanner;

public class StockMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter details for Equity Stock:");
        System.out.print("Stock Name: ");
        String eName = sc.nextLine();
        System.out.print("Stock Symbol: ");
        String eSymbol = sc.nextLine();
        System.out.print("Sector: ");
        String sector = sc.nextLine();
        System.out.print("Number of days: ");
        int n = sc.nextInt();
        int[] ePrices = new int[n];
        System.out.println("Enter prices:");
        for (int i = 0; i < n; i++) {
            ePrices[i] = sc.nextInt();
        }

        EquityStockAnalyzer equityStock = new EquityStockAnalyzer(eName, eSymbol, ePrices, sector);
        sc.nextLine();

        System.out.println("\nEnter details for Commodity Stock:");
        System.out.print("Stock Name: ");
        String cName = sc.nextLine();
        System.out.print("Stock Symbol: ");
        String cSymbol = sc.nextLine();
        System.out.print("Commodity Type: ");
        String commodityType = sc.nextLine();
        System.out.print("Number of days: ");
        int m = sc.nextInt();
        int[] cPrices = new int[m];
        System.out.println("Enter prices:");
        for (int i = 0; i < m; i++) {
            cPrices[i] = sc.nextInt();
        }

        CommodityStockAnalyzer commodityStock = new CommodityStockAnalyzer(cName, cSymbol, cPrices, commodityType);


        System.out.println("\nStock Analysis Results:");
        equityStock.displayAnalysis();
        commodityStock.displayAnalysis();

        System.out.println("comparison results:");
        double equityAvg = equityStock.calculateAveragePrice();
        double commodityAvg = commodityStock.calculateAveragePrice();
        if (equityAvg > commodityAvg) {
            System.out.println("\nStock with Highest Average Price: Equity Stock - " +
                    equityStock.stockName + " with Average Price: " + equityAvg);
        } else {
            System.out.println("\nStock with Highest Average Price: Commodity Stock - " +
                    commodityStock.stockName + " with Average Price: " + commodityAvg);
        }

        int[] equityTrend = equityStock.findLongestIncreasingTrend();
        int[] commodityTrend = commodityStock.findLongestIncreasingTrend();
        if (equityTrend[2] > commodityTrend[2]) {
            System.out.println("\nStock with longest increasing trend is equity trend\n" +
                    "name= " + equityStock.stockName + " with " +
                    equityTrend[2] + " days");
        } else if (equityTrend[2] < commodityTrend[2]) {
            System.out.println("\nStock with longest increasing trend is commodity trend\n" +
                    "name= " + commodityStock.stockName + " with " +
                    commodityTrend[2] + " days");
        } else {
            System.out.println("\nBoth have same trend length");
        }
    }
}
