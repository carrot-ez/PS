package Programmers;

import java.util.LinkedList;

public class Printer {
    public static void main(String args[]) {
        int[] priorities = {1, 1, 9, 1, 1, 1};
        int location = 0;

        int result = new Printer().solution(priorities, location);

        System.out.println(result);
    }

    // programmers
    public int solution(int[] priorities, int location) {
        int answer = 0;
        int maxPriority = -1;
        LinkedList<Node> queue = new LinkedList<>();

        for(int i = 0; i<priorities.length; i++) {
            queue.add(new Node(priorities[i], i));
            maxPriority = Math.max(maxPriority, priorities[i]);
        }

        while(!queue.isEmpty()) {
            Node n = queue.poll();
            if(n.getPriority() == maxPriority) {
                answer += 1;
                if(n.getLocation() == location) {
                    return answer;
                }
                maxPriority = updateMaxPriority(queue);
            }
            else {
                queue.add(n);
            }
        }

        return answer;
    }

    public int updateMaxPriority(LinkedList<Node> queue) {
        int max = -1;
        for(Node n : queue) {
            max = Math.max(max, n.getPriority());
        }
        return max;
    }

    // data class
    class Node {
        private final int priority;
        private final int location;

        public Node(int priority, int location) {
            this.priority = priority;
            this.location = location;
        }

        public int getPriority() {
            return priority;
        }

        public int getLocation() {
            return location;
        }

    }
    // programmers
}
