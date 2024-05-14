package erni.example.jfr.brackets;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    Stack<Integer> stack;

    @BeforeEach
    void setup() {
        stack = new Stack<>();
    }

    @Test
    void newlyCreatesStackIsEmpty() {
        assertTrue(stack.isEmpty());
    }

    @Test
    void stackAfterPushIsNotEmpty() {
        stack.push(1);
        assertFalse(stack.isEmpty());
    }

    @Test
    void popOnAnEmptyStackReturnsEmpty() {
        assertNull(stack.pop());
    }

    @Test
    void popOnNomEmptyStackReturnsLastPushedItem() {
        stack.push(1);
        stack.push(2);

        assertEquals(2, stack.pop());
    }
}
