package dataStructure.list.linkerlist;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    @Test
    @DisplayName("링크드리스트 사이즈 및 Empty 테스트")
    void listSizeTest() {
        LinkedList<Integer> list = new LinkedList<>();
        assertEquals(0, list.size());
        assertTrue(list.isEmpty());
    }

    @Test
    @DisplayName("링크드리스트 노드 추가 테스트")
    void addNodeTest() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.retrieve();
        assertEquals(4, list.size());
    }

    @Test
    @DisplayName("링크드리스트 노드 삭제 테스트")
    void removeLinkedList() {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.retrieve();
        list.remove(3);

        assertEquals(3, list.size());
    }


}