package stack;

public class ArrayBasedStack<T> implements StackInterface<T> {
    private final T[] stack;
    private int count;
    private int stackSize;

    public ArrayBasedStack() {
        this.count = 0;
        this.stackSize = 10;
        this.stack = (T[]) new Object[this.stackSize];
    }

    public ArrayBasedStack(int stackSize) {
        this.count = 0;
        this.stackSize = stackSize;
        this.stack = (T[]) new Object[stackSize];
    }

    public void push(T element) {
        stack[count] = element;
        count++;
    }

    public synchronized T pop() {
        if (empty())
            throw new IllegalArgumentException("Empty Stack");
        return stack[--count];
    }

    public synchronized T peek() {
        if (empty())
            throw new IllegalArgumentException("Empty Stack");
        return stack[count - 1];
    }

    public int search(T element) {
        for (int i = 0; i < count; i++) {
            if (stack[i].equals(element)) return i + 1;
        }
        return -1;
    }

    public boolean empty() {
        return (count == 0);
    }
}
