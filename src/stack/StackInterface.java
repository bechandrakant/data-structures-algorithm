package stack;

public interface StackInterface<T> {
    void push(T element);
    T pop();
    T peek();
    int search(T element);
    boolean empty();
}
