package com.quest.test;

public class EquityStockAnalyzer extends StockAnalyzer {
    private String sector;

    public EquityStockAnalyzer(String stockName, String stockSymbol, int[] prices, String sector) {
        super(stockName, stockSymbol, prices);
        this.sector = sector;
    }

    @Override
    public int findMaxPrice() {
        int max = prices[0];
        for (int i : prices) {
            if (i > max) max = i;
        }
        return max;
    }

    @Override
    public int findMinPrice() {
        int min = prices[0];
        for (int i : prices) {
            if (i < min) min = i;
        }
        return min;
    }

    @Override
    public double calculateAveragePrice() {
        double avg = 0;
        for (double i : prices) {
            avg += i;
        }
        return avg / prices.length;
    }

    @Override
    public int[] findLongestIncreasingTrend() {
        int maxLength = 0;
        int start = 0;
        int end = 0;
        int currentStart = 0;
        int length = 1;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                length++;
                if (length > maxLength) {
                    maxLength = length;
                    start = currentStart;
                    end = i;
                }
            } else {
                length = 1;
                currentStart = i;
            }
        }
        return new int[]{start, end, maxLength};
    }

    @Override
    public void displayAnalysis() {
        int[] trend = findLongestIncreasingTrend();
        System.out.println("Analysis for Equity Stock:\n" +
                " Name: " + stockName +
                "\nStock Symbol: " + stockSymbol +
                "\nSector: " + sector +
                "\nHighest Price: " + findMaxPrice() +
                "\nLowest Price: " + findMinPrice() +
                "\nAverage Price: " + calculateAveragePrice() +
                "\nLongest Increasing Trend: Start Day " + (trend[0] + 1) +
                ", End Day " + (trend[1] + 1) + ", Length: " + trend[2] + " days"
        );
    }
}
