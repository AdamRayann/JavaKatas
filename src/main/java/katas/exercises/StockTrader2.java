package katas.exercises;

import java.util.ArrayList;
import java.util.List;

public class StockTrader2 {

    /**
     * Finds the maximum profit that can be achieved by buying and selling the stock MULTIPLE times.
     *
     * O(n) is the best complexity
     *
     * @param prices an array of prices on each day
     * @return the maximum profit, or 0 if no profit can be achieved
     */
    public static int maxProfit(int[] prices) {

        int len=prices.length,res=0;
        List<Integer>  localMaximums;
        List<Integer>  localMinimums;
        if(len<=1)
            return res;

        localMinimums=getlocalMinimumsIndx(prices,len);
        //System.out.println(localMinimums);

        localMaximums=getLocalMaximumsIndx(prices,len);
        //System.out.println(localMaximums);

        for(int i=0;i<localMinimums.size();i++)
        {
            res+=localMaximums.get(i)- localMinimums.get(i);
        }

        return res;
    }

    private static List<Integer> getlocalMinimumsIndx(int[] arr,int len) {
        List<Integer>  res=new ArrayList<>();
        for(int i=0; i<len ; i++)
        {
            if(i==0)
            {
                if(len>1 && arr[i]<arr[i+1])
                {
                    res.add(arr[i]);
                }
            }
            else {
                if(arr[i-1]>=arr[i])
                {
                    if(i<len-1 && arr[i]<arr[i+1])
                    {
                        res.add(arr[i]);
                    }
                }
            }
        }
        return res;
    }

    private static List<Integer> getLocalMaximumsIndx(int[] arr, int len) {
        List<Integer>  res=new ArrayList<>();
        for(int i=0; i<len ; i++)
        {
            if(i!=0) {
                if(arr[i]>=arr[i-1])
                {
                    if(i<len-1 && arr[i]>arr[i+1])
                    {
                        res.add(arr[i]);
                    }
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int[] stockPrices = {7, 1, 5, 3, 6, 4};
        int profit = maxProfit(stockPrices);
        System.out.println("Maximum Profit: " + profit);  // should be 7
    }
}
