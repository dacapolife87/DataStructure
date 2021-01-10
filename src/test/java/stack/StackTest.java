package stack;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {

    @Test
    @DisplayName("Stack push테스트")
    void pushTest() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertEquals(3, stack.size());
    }

    @Test
    @DisplayName("Stack pop테스트")
    void popTest() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        int pop = stack.pop();

        assertEquals(3, pop);
        assertEquals(2, stack.size());
    }

    @Test
    @DisplayName("Stack peek테스트")
    void peekTest() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        int peek = stack.peek();
        assertEquals(3, peek);
        assertEquals(3, stack.size());
    }


    @Test
    @DisplayName("Stack isEmpty테스트")
    void isEmptyTest() {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);

        stack.pop();
        stack.pop();

        assertTrue(stack.isEmpty());
        assertEquals(0, stack.size());
    }

}