package katas.exercises;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ListFlattenTest {
    ListFlatten listFlatten = new ListFlatten(); // Instance no longer static


    @Nested
    @DisplayName("Tests for valid input")
    class ValidInput {

        @Test
        @DisplayName("valid string")
        void test1() {
            List<Object> nestedList = new ArrayList<>();

            nestedList.add(1);
            nestedList.add(List.of(2, 3));
            nestedList.add(List.of(4, List.of(5, 6)));
            nestedList.add(7);

            assertEquals( List.of(1, 2, 3, 4, 5, 6, 7) , listFlatten.flattenList(nestedList));
        }



    }
}
