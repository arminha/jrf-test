package erni.example.jfr.brackets;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Stack<T> {

    private final List<T> backingList = new ArrayList<>();

    public void push(T item) {
        Objects.requireNonNull(item);
        backingList.addFirst(item);
    }

    public T pop() {
        if (isEmpty()) {
            return null;
        }
        return backingList.removeFirst();
    }

    public boolean isEmpty() {
        return backingList.isEmpty();
    }
}
