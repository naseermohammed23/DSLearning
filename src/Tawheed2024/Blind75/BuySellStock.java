package Tawheed2024.Blind75;

public class BuySellStock {

    public static void main(String[] args) {
        int[] prices = new int[]{2,1,2,1,0,1,2};

        System.out.println(maxProfit(prices));
    }
    
    public static int maxProfit(int[] prices) {
        
        int buyIdx = 0;
        int bestBuyPrice = prices[0];
        // buy the stock , get the stock day idx
        for (int i=1;i<prices.length;i++) {
            if (prices[i] != 0 && i != prices.length -1 && prices[i] < bestBuyPrice) {
                bestBuyPrice = prices[i];
                buyIdx = i;
            } 
        }

        int bestSellPrice = prices[buyIdx];
        //sell the stock on the best day after buy stock idx 
        for (int i=buyIdx+1;i<prices.length;i++) {
            if (prices[i] > bestSellPrice) {
                bestSellPrice = prices[i];
            }
        }

        return bestSellPrice - bestBuyPrice;
    }
}
