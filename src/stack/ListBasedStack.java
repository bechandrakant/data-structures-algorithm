package stack;

import java.util.ArrayList;
import java.util.List;

public class ListBasedStack<T> implements StackInterface<T> {
    private final List<T> stack;
    private int count;

    public ListBasedStack() {
        this.stack = new ArrayList<T>();
        count = 0;
    }

    public ListBasedStack(int stackSize) {
        this.stack = new ArrayList<T>();
        this.count = 0;
    }

    public void push(T element) {
        stack.add(element);
        count++;
    }

    public T pop() {
        if (empty())
            throw new IllegalArgumentException("Empty Stack");
        return stack.remove(--count);
    }

    public T peek() {
        if (empty())
            throw new IllegalArgumentException("Empty Stack");
        return stack.get(count - 1);
    }

    public int search(T element) {
        for (int i = 0; i < count; i++) {
            if (stack.get(i).equals(element)) return i + 1;
        }
        return -1;
    }

    public boolean empty() {
        return (count == 0);
    }
}
