package Kakao.y2022;

import java.util.*;

public class sol1 {

    class Solution {
        public int[] solution(String[] id_list, String[] report, int k) {

            // set map
            Map<String, Integer> countMap = new HashMap<>();
            Map<String, List<String>> reportMap = new HashMap<>();
            for (String s : id_list) {
                countMap.put(s, 0);
                reportMap.put(s, new ArrayList<>());
            }

            // set set
            Set<String> set = new HashSet<>();
            for (String s : report) {
                set.add(s);
            }

            // counting
            for (String s : set) {
                String[] splits = s.split(" ");
                String source = splits[0];
                String target = splits[1];

                countMap.replace(target, countMap.get(target) + 1);
                List<String> targetList = reportMap.get(source);
                targetList.add(target);
            }

            // get answer
            int[] answer = new int[id_list.length];
            for (int i = 0; i < id_list.length ; i++) {
                List<String> targetList = reportMap.get(id_list[i]);

                int res = 0;
                for (String target : targetList) {
                    Integer count = countMap.get(target);
                    if (count >= k) {
                        res += 1;
                    }
                }

                answer[i] = res;
            }

            return answer;
        }
    }
}
