package com.quest.test;

public abstract class StockAnalyzer {
    public String stockName;
    public String stockSymbol;
    public int[] prices;

    public StockAnalyzer(String stockName, String stockSymbol, int[] prices) {
        this.stockName = stockName;
        this.stockSymbol = stockSymbol;
        this.prices = prices;
    }

    public abstract int findMaxPrice();

    public abstract int findMinPrice();

    public abstract double calculateAveragePrice();

    public abstract int[] findLongestIncreasingTrend();

    public abstract void displayAnalysis();
}
