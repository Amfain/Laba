package Labs.lab4_1;

public interface MinStack<T extends Number> {
    void push(T value);

    T pop();

    T top();

    T min();
}
