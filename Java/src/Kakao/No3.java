package Kakao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class No3 {
    public static void main(String args[]) {
        String[] info = { "java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
        String[] query = {"java and frontend and senior and chicken 135" };

        int[] result = new No3().solution(info, query);
        for(int e : result) {
            System.out.println(e);
        }
    }

    public int[] solution(String[] info, String[] query) {
        List<Integer> resultList = new ArrayList<>();
        HashMap<Integer, List<Node>> map = new HashMap<>();

        // hash값을 이용해 분류
        for(String s : info) {
            String[] splits = s.split(" ");
            int hash[] = new int[16];
            hash[0] = splits[0].hashCode() + splits[1].hashCode() + splits[2].hashCode() + splits[3].hashCode();
            hash[1] = splits[0].hashCode() + splits[1].hashCode() + splits[2].hashCode() + "-".hashCode();
            hash[2] = splits[0].hashCode() + splits[1].hashCode() + "-".hashCode() + splits[3].hashCode();
            hash[3] = splits[0].hashCode() + "-".hashCode() + splits[2].hashCode() + splits[3].hashCode();
            hash[4] = "-".hashCode() + splits[1].hashCode() + splits[2].hashCode() + splits[3].hashCode();
            hash[5] = splits[0].hashCode() + splits[1].hashCode() + "-".hashCode() + "-".hashCode();
            hash[6] = splits[0].hashCode() + "-".hashCode() + splits[2].hashCode() + "-".hashCode();
            hash[7] = "-".hashCode() + splits[1].hashCode() + splits[2].hashCode() + "-".hashCode();
            hash[8] = splits[0].hashCode() + "-".hashCode() + "-".hashCode() + splits[3].hashCode();
            hash[9] = "-".hashCode() + splits[1].hashCode() + "-".hashCode() + splits[3].hashCode();
            hash[10] = "-".hashCode() + "-".hashCode() + splits[2].hashCode() + splits[3].hashCode();
            hash[11] = splits[0].hashCode() + "-".hashCode() + "-".hashCode() + "-".hashCode();
            hash[12] = "-".hashCode() + splits[1].hashCode() + "-".hashCode() + "-".hashCode();
            hash[13] = "-".hashCode() + "-".hashCode() + splits[2].hashCode() + "-".hashCode();
            hash[14] = "-".hashCode() + "-".hashCode() + "-".hashCode() + splits[3].hashCode();
            hash[15] = "-".hashCode() + "-".hashCode() + "-".hashCode() + "-".hashCode();

            Node node = new Node(splits[0], splits[1], splits[2], splits[3], Integer.parseInt(splits[4]));
            for(int i=0; i<hash.length; i++) {
                if(!map.containsKey(hash[i])) {
                    map.put(hash[i], new ArrayList<>());
                }
                map.get(hash[i]).add(node);
            }
        }

        for(String s :  query) {
            String[] splits = s.split(" and ");
            String[] splits2 = splits[3].split(" ");
            int hash = splits[0].hashCode() + splits[1].hashCode() + splits[2].hashCode() + splits2[0].hashCode();
            int score = Integer.parseInt(splits2[1]);
            int cnt = 0;

            List<Node> list = null;
            if(map.containsKey(hash)) {
                list = map.get(hash);
            }

            if(list != null && !list.isEmpty()) {
                for(Node n : list) {
                    if(n.score >= score) {
                        cnt += 1;
                    }
                }
            }
            resultList.add(cnt);
        }



        int[] answer = resultList.stream().mapToInt(i->i).toArray();
        return answer;
    }

    class Node {
        String language;
        String work;
        String career;
        String food;
        int score;

        public Node(String language, String work, String career, String food, int score) {
            this.language = language;
            this.work = work;
            this.career = career;
            this.food = food;
            this.score = score;
        }
    }
}
