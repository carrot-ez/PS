package Programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class WordConversion {
    PriorityQueue<Integer> pq;

    public static void main(String args[]) {
        String begin = "hit";
        String target = "cog";
        String words[] = {"hot", "dot", "dog", "lot", "log", "cog"};

        System.out.println(new WordConversion().stringDif("hit", "hot"));

        int result = new WordConversion().solution(begin, target, words);
        System.out.println(result);
    }

    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        pq = new PriorityQueue<Integer>();
        List<String> list = new ArrayList<>();
        for(int i=0; i<words.length; i++) {
            list.add(words[i]);
        }
        dfs(begin, target, list, 0);

        if(pq.isEmpty()) {
            return 0;
        }
        else {
            return pq.peek();
        }
    }

    public void dfs(String begin, String target, List<String> list, int level) {
//        System.out.println("begin="+begin+", target="+target);
        if(begin.equals(target)) {
            pq.add(level);
            return;
        }
        if(list.isEmpty()) {
            return;
        }

        for(String s : list) {
            if(stringDif(begin, s) == 1) {
//                System.out.println("===> s="+s+", begin="+begin);
                List<String> tmp = new ArrayList<>(list);
                tmp.remove(s);
                dfs(s, target, tmp, level +1);
            }
        }
    }

    public int stringDif(String str1, String str2) {
        int count = 0;
        for(int i=0; i<str1.length(); i++) {
            if(str1.charAt(i) != str2.charAt(i)) {
                count += 1;
            }
        }
        return count;
    }
}
