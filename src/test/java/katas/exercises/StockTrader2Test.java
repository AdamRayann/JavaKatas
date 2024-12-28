package katas.exercises;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StockTrader2Test {
    StockTrader2 stockTrader2=new StockTrader2();
    @Test
    @DisplayName("valid ")
    public void test1() {
        int[] stockPrices = {7, 1, 5, 3, 6, 4};
        assertEquals(7, stockTrader2.maxProfit(stockPrices));
    }
}
