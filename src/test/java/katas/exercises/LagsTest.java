package katas.exercises;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class LagsTest {

    @Test
    void testMaximizeProfitBasicCase() {
        List<Lags.Request> requests = new ArrayList<>();
        requests.add(new Lags.Request("REQ01", 0, 5, 50));
        requests.add(new Lags.Request("REQ02", 3, 7, 80));
        requests.add(new Lags.Request("REQ03", 5, 4, 60));
        requests.add(new Lags.Request("REQ04", 6, 3, 70));

        int maxProfit = Lags.maximizeProfit(requests);
        assertEquals(120, maxProfit); // Expected max profit
    }

    @Test
    void testMaximizeProfitNoOverlappingRequests() {
        List<Lags.Request> requests = new ArrayList<>();
        requests.add(new Lags.Request("REQ01", 0, 2, 30));
        requests.add(new Lags.Request("REQ02", 3, 2, 40));
        requests.add(new Lags.Request("REQ03", 6, 2, 50));

        int maxProfit = Lags.maximizeProfit(requests);
        assertEquals(120, maxProfit); // All requests can be taken
    }

    @Test
    void testMaximizeProfitSingleRequest() {
        List<Lags.Request> requests = new ArrayList<>();
        requests.add(new Lags.Request("REQ01", 0, 5, 50));

        int maxProfit = Lags.maximizeProfit(requests);
        assertEquals(50, maxProfit);
    }

    @Test
    void testMaximizeProfitNoValidRequests() {
        List<Lags.Request> requests = new ArrayList<>();

        int maxProfit = Lags.maximizeProfit(requests);
        assertEquals(0, maxProfit);
    }

    @Test
    void testMaximizeProfitOverlappingRequests() {
        List<Lags.Request> requests = new ArrayList<>();
        requests.add(new Lags.Request("REQ01", 0, 4, 50));
        requests.add(new Lags.Request("REQ02", 2, 3, 70));
        requests.add(new Lags.Request("REQ03", 4, 5, 60));

        int maxProfit = Lags.maximizeProfit(requests);
        assertEquals(110, maxProfit); // Choosing REQ01 + REQ03
    }
}