package stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StringArrayBasedStackTest {
    private StackInterface stack;
    @BeforeEach
    void initializeStack() {
        stack = new ArrayBasedStack<String>();
    }

    @Test
    void canPushElement() {
        stack.push("ABC");
        checkStack("ABC", false);
        stack.push("BCD");
        checkStack("BCD", false);
        stack.push("CDE");
        checkStack("CDE", false);
        stack.push("DEF");
        checkStack("DEF", false);
    }
    @Test
    void canPopElement() {
        stack.push("ABC");
        stack.push("BCD");
        assertEquals("BCD", stack.pop());
        assertEquals("ABC", stack.pop());
    }
    @Test
    void canPeekElement() {
        stack.push("ABC");
        assertEquals("ABC", stack.peek());
        stack.push("BCD");
        assertEquals("BCD", stack.peek());
        stack.pop();
        assertEquals("ABC", stack.peek());
    }
    @Test
    void canSearchAnElement() {
        stack.push("ABC");
        stack.push("BCD");
        stack.push("CDE");
        assertEquals(2, stack.search("BCD"));
        assertEquals(1, stack.search("ABC"));
        assertEquals(3, stack.search("CDE"));
        assertEquals(-1, stack.search("XYZ"));
    }
    @Test
    void canCheckForEmptyStack() {
        assertEquals(true, stack.empty());
        stack.push("ABC");
        assertEquals(false, stack.empty());
        stack.pop();
        assertEquals(true, stack.empty());
    }

    private void checkStack(String topElement, boolean isEmpty) {
        assertEquals(topElement, stack.peek());
        assertEquals(isEmpty, stack.empty());
    }
}