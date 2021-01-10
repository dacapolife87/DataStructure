package queue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {

    @Test
    @DisplayName("큐에  데이터 삽입 테스트")
    void pushQTest() {
        Queue<Integer> queue = new Queue();
        queue.add(1);
        queue.add(2);
        queue.add(3);

        assertEquals(3, queue.size());
        assertFalse(queue.isEmpty());

    }

    @Test
    @DisplayName("큐 데이터 추출 테스트")
    void popQTest() {
        Queue<Integer> queue = new Queue();
        queue.add(1);
        queue.add(2);
        queue.add(3);

        int removedData = queue.remove();

        assertEquals(1, removedData);
        assertEquals(2, queue.size());
        assertFalse(queue.isEmpty());
    }

    @Test
    @DisplayName("큐 첫번째 데이터 확인 테스트")
    void peekQTest() {
        Queue<Integer> queue = new Queue();
        queue.add(1);
        queue.add(2);
        queue.add(3);

        int firstData = queue.peek();

        assertEquals(1, firstData);
        assertFalse(queue.isEmpty());
    }

    @Test
    @DisplayName("큐 Empty 테스트")
    void emptyQTest() {
        Queue<Integer> queue = new Queue();
        queue.add(1);
        queue.add(2);

        queue.remove();
        queue.remove();

        assertEquals(0, queue.size());
        assertTrue(queue.isEmpty());
    }
}