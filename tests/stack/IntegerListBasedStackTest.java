package stack;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IntegerListBasedStackTest {
    private StackInterface stack;
    @BeforeEach
    void initializeStack() {
        stack = new ListBasedStack<Integer>();
    }

    @Test
    void canPushElement() {
        stack.push(10);
        checkStack(10, false);
        stack.push(11);
        checkStack(11, false);
        stack.push(12);
        checkStack(12, false);
        stack.push(13);
        checkStack(13, false);
        stack.push(14);
        checkStack(14, false);
    }
    @Test
    void canPopElement() {
        stack.push(10);
        stack.push(20);
        assertEquals(20, stack.pop());
        assertEquals(10, stack.pop());
    }
    @Test
    void canPeekElement() {
        stack.push(10);
        assertEquals(10, stack.peek());
        stack.push(20);
        assertEquals(20, stack.peek());
        stack.pop();
        assertEquals(10, stack.peek());
    }
    @Test
    void canSearchAnElement() {
        stack.push(10);
        stack.push(11);
        stack.push(12);
        assertEquals(2, stack.search(11));
        assertEquals(1, stack.search(10));
        assertEquals(3, stack.search(12));
        assertEquals(-1, stack.search(15));
    }
    @Test
    void canCheckForEmptyStack() {
        assertEquals(true, stack.empty());
        stack.push(5);
        assertEquals(false, stack.empty());
        stack.pop();
        assertEquals(true, stack.empty());
    }

    private void checkStack(int topElement, boolean isEmpty) {
        assertEquals(topElement, stack.peek());
        assertEquals(isEmpty, stack.empty());
    }
}