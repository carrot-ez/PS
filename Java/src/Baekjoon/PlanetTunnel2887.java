package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class PlanetTunnel2887 {
    private static int[] root;
    private static Planet[] planets;
    private static PriorityQueue<Node> pq;

    public static void main(String args[]) throws IOException {
        int result = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numPlanet = Integer.parseInt(br.readLine());

        // initialize variables
        root = new int[numPlanet];
        planets = new Planet[numPlanet];
        pq = new PriorityQueue<>();

        for(int i=0; i<numPlanet; i++) {
            // init planets
            String[] splits = br.readLine().split(" ");
            int x = Integer.parseInt(splits[0]);
            int y = Integer.parseInt(splits[1]);
            int z = Integer.parseInt(splits[2]);
            planets[i] = new Planet(i, x, y, z);

            // init root
            root[i] = i;

        }

        // x에 대해 정렬한 후 인접한 두 노드만 확인
        Arrays.sort(planets, new Comparator<Planet>() {
            @Override
            public int compare(Planet o1, Planet o2) {
                return o1.x - o2.x;
            }
        });
        for(int i=1; i<numPlanet; i++) {
            int distance = Math.abs(planets[i-1].x - planets[i].x);
            pq.add(new Node(planets[i-1].index, planets[i].index, distance));
        }

        // y
        Arrays.sort(planets, new Comparator<Planet>() {
            @Override
            public int compare(Planet o1, Planet o2) {
                return o1.y - o2.y;
            }
        });
        for(int i=1; i<numPlanet; i++) {
            int distance = Math.abs(planets[i-1].y - planets[i].y);
            pq.add(new Node(planets[i-1].index, planets[i].index, distance));
        }

        // z
        Arrays.sort(planets, new Comparator<Planet>() {
            @Override
            public int compare(Planet o1, Planet o2) {
                return o1.z - o2.z;
            }
        });
        for(int i=1; i<numPlanet; i++) {
            int distance = Math.abs(planets[i-1].z - planets[i].z);
            pq.add(new Node(planets[i-1].index, planets[i].index, distance));
        }

        while(!pq.isEmpty()) {
            Node n = pq.poll();
            if(find(n.start) == find(n.end))
                continue;
            union(n.start, n.end);
            result += n.distance;
        }

        System.out.println(result);
    }

    public static int find(int x) {
        if(x == root[x]) {
            return x;
        }
        return root[x] = find(root[x]);
    }

    public static boolean union(int x, int y) {
        x = find(x);
        y = find(y);
        if(x == y)
            return false;
        root[y] = x;
        return true;
    }
}

class Planet {
    int index;
    int x;
    int y;
    int z;

    public Planet(int index, int x, int y, int z) {
        this.index = index;
        this.x = x;
        this.y = y;
        this.z = z;
    }
}

class Node implements Comparable<Node> {
    int start;
    int end;
    int distance;

    public Node(int start, int end, int distance) {
        this.start = start;
        this.end = end;
        this.distance = distance;
    }

    @Override
    public int compareTo(Node o) {
        return this.distance - o.distance;
    }
}