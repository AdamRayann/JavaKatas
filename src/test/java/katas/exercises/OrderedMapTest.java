package katas.exercises;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OrderedMapTest {

    private OrderedMap<String, Integer> orderedMap;

    @BeforeEach
    void setUp() {
        orderedMap = new OrderedMap<>();
    }

    @Test
    void testPutAndGet() {
        orderedMap.put("One", 1);
        orderedMap.put("Two", 2);

        assertEquals(1, orderedMap.get("One"), "Value for key 'One' should be 1");
        assertEquals(2, orderedMap.get("Two"), "Value for key 'Two' should be 2");
    }

    @Test
    void testPutDuplicateKey() {
        orderedMap.put("One", 1);
        orderedMap.put("One", 11);

        assertEquals(11, orderedMap.get("One"), "Value for duplicate key 'One' should be updated to 11");
        assertEquals(1, orderedMap.size(), "Size should remain 1 after updating a duplicate key");
    }

    @Test
    void testKeysOrder() {
        orderedMap.put("One", 1);
        orderedMap.put("Two", 2);
        orderedMap.put("Three", 3);

        List<String> keys = orderedMap.keys();
        assertEquals(List.of("One", "Two", "Three"), keys, "Keys should be in insertion order");
    }

    @Test
    void testRemove() {
        orderedMap.put("One", 1);
        orderedMap.put("Two", 2);

        orderedMap.remove("One");

        assertNull(orderedMap.get("One"), "Removed key 'One' should return null");
        assertEquals(1, orderedMap.size(), "Size should decrease after removing a key");
        assertEquals(List.of("Two"), orderedMap.keys(), "Remaining keys should match the updated order");
    }

    @Test
    void testRemoveNonExistentKey() {
        orderedMap.put("One", 1);
        assertThrows(UnsupportedOperationException.class, () -> orderedMap.remove("Two"), "Removing a non-existent key should throw an exception");
    }

    @Test
    void testSize() {
        assertEquals(0, orderedMap.size(), "Size should be 0 for an empty map");

        orderedMap.put("One", 1);
        orderedMap.put("Two", 2);

        assertEquals(2, orderedMap.size(), "Size should be 2 after adding two elements");
    }

    @Test
    void testClear() {
        orderedMap.put("One", 1);
        orderedMap.put("Two", 2);
        orderedMap.clear();

        assertEquals(0, orderedMap.size(), "Size should be 0 after clearing the map");
        assertTrue(orderedMap.keys().isEmpty(), "Keys should be empty after clearing the map");
    }

    @Test
    void testGetNonExistentKey() {
        assertNull(orderedMap.get("NonExistent"), "Getting a non-existent key should return null");
    }
}
