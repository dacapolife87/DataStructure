package algorithm.shortestpath;

import java.util.*;

public class Dijkstra {

    private static final int INF = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String firstLine = in.nextLine();

        int point = Integer.parseInt(firstLine.split(" ")[0]);
        int edge = Integer.parseInt(firstLine.split(" ")[1]);
        int startPoint = in.nextInt();
        in.nextLine();
        List<Point>[] pathWeight = new ArrayList[point];
        for(int i = 0; i < point; i ++) {
            pathWeight[i] = new ArrayList<>();
        }

        for(int i = 0; i < edge; i++) {
            String edgeInput = in.nextLine();
            String[] edgeInfos = edgeInput.split(" ");
            int startPosition = Integer.parseInt(edgeInfos[0]);
            int endPosition = Integer.parseInt(edgeInfos[1]);
            int weight = Integer.parseInt(edgeInfos[2]);

            pathWeight[startPosition-1].add(new Point(endPosition-1, weight));
        }
//        int[][] pathWeight = {{0,2,3,1000,1000},{1000,0,4,5,1000},{1000,1000,0,6,1000},{1000,1000,1000,0,1000},{1,1000,1000,1000,0}};
        Dijkstra dijkstra = new Dijkstra();
        dijkstra.solution(point, startPoint-1, pathWeight);
    }

    public void solution(int points, int startPoint, List<Point>[] pathWeigh) {
        boolean[] touchPoint = new boolean[points];
        int[] weightPoint = new int[points];
        Arrays.fill(weightPoint,INF);

        PriorityQueue<Point> queue = new PriorityQueue();
        queue.add(new Point(startPoint, 0 ));
        while (!queue.isEmpty()) {
            Point poll = queue.poll();
            int startPosition = poll.dest;

            if(touchPoint[startPosition]) {
                continue;
            }
            touchPoint[startPosition] = true;
            for(Point point : pathWeigh[startPosition]) {
                if(weightPoint[startPosition] == INF) {
                    weightPoint[startPosition] = 0;
                }
                if(weightPoint[point.dest] >= weightPoint[startPosition] + point.weight) {
                    weightPoint[point.dest] = weightPoint[startPosition] + point.weight;
                    System.out.println(point.dest + " : "+ weightPoint[point.dest]);
                    queue.add(new Point(point.dest,weightPoint[point.dest]));
                }
            }
        }

        printWeight(weightPoint);
    }

    public void printWeight(int[] weightPoint) {
        for (int i : weightPoint) {
            if(i == INF) {
                System.out.println("INF");
            }else{
                System.out.println(i);
            }

        }
    }
}
class Point implements Comparable<Point>{
    int dest;
    int weight;

    public Point(int dest, int weight) {
        this.dest = dest;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Point{" +
                "dest=" + dest +
                ", weight=" + weight +
                '}';
    }

    @Override
    public int compareTo(Point o) {
        return Integer.compare(this.weight, o.weight);
    }
}
