package katas.exercises;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StockTraderTest {
    StockTrader stockTrader=new StockTrader();
    @Test
    @DisplayName("valid ")
    public void test1() {
        int[] stockPrices = {7, 1, 5, 3, 6, 4};
        assertEquals(5, stockTrader.maxProfit(stockPrices));
    }
}
