package algorithm.path;

import java.util.PriorityQueue;
import java.util.Scanner;

class Edge implements Comparable<Edge> {

    int start;
    int end;
    int weight;


    public Edge(int start, int end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
        return Integer.compare(this.weight, o.weight);
    }
}

class UnionFind {
    private int[] parentGroup;

    public UnionFind(int size) {
        this.parentGroup = new int[size];
        for (int i = 0; i < parentGroup.length; i++) {
            parentGroup[i] = i;
        }
    }

    public void print() {
        for (int i : parentGroup) {
            System.out.print(i + " ");
        }
        System.out.println("");
    }
    public int findParent(int point) {
        while(true) {
            int parent = parentGroup[point];
            if(point == parentGroup[point]) {
                return parent;
            }
            point = parentGroup[point];
        }
    }

    public void chageParent(int nowPoint, int parentPoint) {
        parentGroup[nowPoint] = parentPoint;
    }
    public boolean sameGroup(int startPoint, int endPoint) {
        int parentOfStart = findParent(startPoint);
        int parentOfEnd = findParent(endPoint);

        return parentOfStart == parentOfEnd;
    }

}
public class Kruskal {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String firstLine = in.nextLine();

        int pointCount = Integer.parseInt(firstLine.split(" ")[0]);
        int edgeCount = Integer.parseInt(firstLine.split(" ")[1]);

        PriorityQueue<Edge> queue = new PriorityQueue();
        for(int i = 0; i < edgeCount; i++) {
            String edgeInfos = in.nextLine();
            int startPoint = Integer.parseInt(edgeInfos.split(" ")[0]);
            int endPoint = Integer.parseInt(edgeInfos.split(" ")[1]);
            int weight = Integer.parseInt(edgeInfos.split(" ")[2]);
            queue.add(new Edge(startPoint-1, endPoint-1, weight));
        }

        Kruskal kruskal = new Kruskal();

        System.out.println(kruskal.solution(pointCount, queue));
    }

    public int solution(int pointCount, PriorityQueue<Edge> queue) {
        int totalWeight = 0;
        int edgeNumOfMST = 0; // MST 정점의 개수
        UnionFind unionFind = new UnionFind(pointCount);

        while (edgeNumOfMST < pointCount && !queue.isEmpty()) {
            Edge edge = queue.poll();
            int start = edge.start;
            int end = edge.end;
            int weight = edge.weight;
            if(!unionFind.sameGroup(start, end)) {
                unionFind.chageParent(start, end);
                totalWeight +=weight;
                edgeNumOfMST++;
            }
        }

        return totalWeight;

    }
}
