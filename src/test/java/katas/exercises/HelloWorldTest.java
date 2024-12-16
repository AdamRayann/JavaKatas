package katas.exercises;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Test;

public class HelloWorldTest {

    @Test
    public void testHelloWorld() {
        String result = HelloWorld.helloWorld();
        assertEquals("hello world", result, "The helloWorld method should return 'hello world'");
    }
}
