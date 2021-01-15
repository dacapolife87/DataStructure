package dataStructure.list.linkerlist;

public class LinkedList<T> {

    Node header;

    static class Node<T> {
        T data;
        Node next = null;
    }

    public LinkedList() {
        this.header = new Node();
    }

    public void add(T data) {
        Node endNode = new Node();
        endNode.data = data;

        Node node = header;
        while (node.next != null) {
            node = node.next;
        }
        node.next = endNode;
    }

    public void remove(T data) {
        Node node = header;
        while (node.next != null) {
            if(node.next.data.equals(data)) {
                node.next = node.next.next;
            }else{
                node = node.next;
            }
        }
    }

    public void retrieve() {
        Node node = header.next;
        while (node.next != null) {
            System.out.print(node.data + " -> ");
            node = node.next;
        }
        System.out.println(node.data);
    }

    public int size() {
        int listCount = 0;
        Node node = header;
        while (node.next != null) {
            listCount++;
            node = node.next;
        }

        return listCount;
    }

    public boolean isEmpty() {
        return header.next == null;
    }
}


