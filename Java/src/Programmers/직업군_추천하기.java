package Programmers;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class 직업군_추천하기 {

    class Solution {
        public String solution(String[] table, String[] languages, int[] preference) {

            PriorityQueue<JobDiv> pq = new PriorityQueue<>();

            for (String s : table) {
                String[] splits = s.split(" ");
                String title = splits[0];
                Map<String, Integer> map = new HashMap<>();
                map.put(splits[1], 5);
                map.put(splits[2], 4);
                map.put(splits[3], 3);
                map.put(splits[4], 2);
                map.put(splits[5], 1);

                JobDiv jobDiv = new JobDiv(title, map);
                jobDiv.calcScore(languages, preference);

                pq.offer(jobDiv);
            }

            return pq.poll().title;
        }
    }

    class JobDiv implements Comparable<JobDiv> {
        String title;
        Map<String, Integer> langs;
        int score;

        public JobDiv(String title, Map<String, Integer> langs) {
            this.title = title;
            this.langs = langs;
        }

        public void calcScore(String[] languages, int[] preference) {

            int totalScore = 0;
            for (int i = 0; i < languages.length; i++) {
                int langsScore = 0;
                if (langs.containsKey(languages[i])) {
                    langsScore = langs.get(languages[i]);
                }

                totalScore += langsScore * preference[i];
            }

            this.score = totalScore;
        }

        @Override
        public int compareTo(JobDiv o) {
            int scoreCompare = Integer.compare(o.score, this.score);
            return scoreCompare == 0 ? scoreCompare : this.title.compareTo(o.title);
        }
    }
}
