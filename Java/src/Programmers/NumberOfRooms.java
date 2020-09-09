package Programmers;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class NumberOfRooms {
    public static void main(String args[]) {
        int[] arrows = {6, 6, 6, 4, 4, 4, 2, 2, 2, 0, 0, 0, 1, 6, 5, 5, 3, 6, 0};
        int result = new NumberOfRooms().solution(arrows);

        Map<Pair<Integer, Integer>, Boolean> map = new HashMap<>();
        map.put(Pair.of(1, 3), true);

        System.out.println(result);
    }

    public int solution(int[] arrows) {
        // graph를 어떤 형태로 만들 것인가?
        // cycle의 갯수 세기
        int answer = 0;
        int x = 0;
        int y = 0;
        int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
        int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};

        // 방문한 노드를 저장하는 map
        Map<Pair<Integer, Integer>, Boolean> visitVertex = new HashMap<>();
        // 방문한 엣지를 저장하는 map
        Map<Pair<Pair<Integer, Integer>, Pair<Integer, Integer>>, Boolean> visitEdge = new HashMap<>();

        visitVertex.put(Pair.of(x, y), true);

        for(int e : arrows) {
            // 교차점을 고려하기 위해 2번 반복
            for(int i=0; i<2; i++) {
                int prevX = x + dx[e];
                int prevY = y + dy[e];

                if(visitVertex.containsKey(Pair.of(prevX, prevY))) {
                    if(!visitEdge.containsKey(Pair.of(Pair.of(x, y), Pair.of(prevX, prevY))) ||
                            !visitEdge.containsKey(Pair.of(Pair.of(prevX, prevY), Pair.of(x, y)))) {
                        answer += 1;
                    }
                }

                visitVertex.put(Pair.of(prevX, prevY), true);
                visitEdge.put(Pair.of(Pair.of(prevX, prevY), Pair.of(x, y)), true);
                visitEdge.put(Pair.of(Pair.of(x, y), Pair.of(prevX, prevY)), true);

                x = prevX;
                y = prevY;
            }
        }
        return answer;
    }
}

class Pair<U, V> {
    public final U first;
    public final V second;

    private Pair(U first, V second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) {
            return true;
        }

        if(obj == null || getClass() != obj.getClass())
            return false;

        Pair<?, ?> pair = (Pair<?, ?>) obj;

        if(!first.equals(pair.first))
            return false;
        return second.equals(pair.second);
    }

    @Override
    public int hashCode() {
        return 31 * first.hashCode() + second.hashCode();
    }

    public static<U, V> Pair<U, V> of (U a, V b) {
        return new Pair<>(a, b);
    }
}
