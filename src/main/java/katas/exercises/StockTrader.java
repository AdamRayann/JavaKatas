package katas.exercises;

import java.util.Arrays;

public class StockTrader {

    /**
     * Finds the maximum profit that can be achieved by buying and selling the stock ONCE.
     *
     * Aim for O(n)
     *
     * @param prices an array of prices on each day
     * @return the maximum profit, or 0 if no profit can be achieved
     */
    public static int maxProfit(int[] prices) {
        int min=0,res=0,i =0;
        if(prices.length>=2)
        {
            min=Arrays.stream(prices).min().getAsInt();
            for( i =0 ; i<prices.length ; i++)
            {
                prices[i]-=min;

            }
            i=0;
            while (prices[i] !=0)
            {
                i++;
            }
            for (;i<prices.length;i++)
            {
                if(res<prices[i])
                    res=prices[i];

            }
        }
        else
            return 0;
        return res;
    }

    public static void main(String[] args) {
        int[] stockPrices = {7, 1, 5, 3, 6, 4};
        int profit = maxProfit(stockPrices);
        System.out.println("Maximum Profit: " + profit);  // should be 5
    }
}
