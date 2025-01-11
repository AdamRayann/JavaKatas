package katas.exercises;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class RoundRobinLoadBalancerTest {

    private RoundRobinLoadBalancer loadBalancer;

    @BeforeEach
    void setUp() {
        loadBalancer = new RoundRobinLoadBalancer();
    }

    @Test
    void testAddServerAndRouteRequest() {
        RoundRobinLoadBalancer.IP server1 = new RoundRobinLoadBalancer.IP("192.168.0.1");
        RoundRobinLoadBalancer.IP server2 = new RoundRobinLoadBalancer.IP("192.168.0.2");

        loadBalancer.addServer(server1);
        loadBalancer.addServer(server2);

        assertEquals(server1, loadBalancer.routeRequest(), "First request should be routed to the first server");
        assertEquals(server2, loadBalancer.routeRequest(), "Second request should be routed to the second server");
        assertEquals(server1, loadBalancer.routeRequest(), "Third request should cycle back to the first server");
    }

    @Test
    void testInvalidIP() {
        assertThrows(IllegalArgumentException.class, () -> new RoundRobinLoadBalancer.IP("999.999.999.999"), "Invalid IP address should throw an exception");
        assertThrows(IllegalArgumentException.class, () -> new RoundRobinLoadBalancer.IP("not.an.ip.address"), "Invalid IP format should throw an exception");
    }

    @Test
    void testValidIP() {
        RoundRobinLoadBalancer.IP validIP = new RoundRobinLoadBalancer.IP("192.168.1.1");
        assertNotNull(validIP, "Valid IP should be created successfully");
    }
}
