package algorithm.path;


import java.util.LinkedList;

class Graph {
    class Node {
        int data;
        boolean marked;
        LinkedList<Node> adjacent;

        Node(int data) {
            this.data = data;
            this.marked = false;
            this.adjacent = new LinkedList<>();
        }
    }
    Node[] nodes;

    public Graph (int size) {
        nodes = new Node[size];
        for (int i = 0; i < size; i++) {
            nodes[i] = new Node(i);
        }
    }

    void addEdge(int i1, int i2) {
        Node n1 = nodes[i1];
        Node n2 = nodes[i2];
        if( !n1.adjacent.contains(n2)) {
            n1.adjacent.add(n2);
        }

        if( !n2.adjacent.contains(n1)) {
            n2.adjacent.add(n1);
        }
    }
    
    void initMarks() {
        for (Node node : nodes) {
            node.marked = false;
        }
    }

    boolean search(int i1, int i2) {
        return search(nodes[i1], nodes[i2]);
    }

    boolean search(Node start, Node end) {
        initMarks();

        LinkedList<Node> queue = new LinkedList<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            Node root = queue.removeFirst();

            if(root == end) {
                return true;
            }

            for(Node node : root.adjacent) {
                if(node.marked == false) {
                    node.marked = true;
                    queue.add(node);
                }
            }
        }
        return false;
    }
}


public class GraphPath {

    public static void main(String[] args) {
/*
  0
 /
1 -- 3    7
|  / | \ /
| /  |  5
2 -- 4   \
          6 -- 8
* */
        Graph graph = new Graph(9);
        graph.addEdge(0,1);
        graph.addEdge(1,2);
        graph.addEdge(1,3);
        graph.addEdge(2,4);
        graph.addEdge(2,3);
        graph.addEdge(3,4);
        graph.addEdge(3,5);
        graph.addEdge(5,6);
        graph.addEdge(5,7);
        graph.addEdge(6,8);

        System.out.println(graph.search(1,8));
/*
  0
 /
1 -- 3    7
|  / |   /
| /  |  5
2 -- 4   \
          6 -- 8
* */

        Graph graph2 = new Graph(9);
        graph2.addEdge(0,1);
        graph2.addEdge(1,2);
        graph2.addEdge(1,3);
        graph2.addEdge(2,4);
        graph2.addEdge(2,3);
        graph2.addEdge(3,4);
        graph2.addEdge(5,6);
        graph2.addEdge(5,7);
        graph2.addEdge(6,8);
        System.out.println(graph2.search(1,8));

    }
}
