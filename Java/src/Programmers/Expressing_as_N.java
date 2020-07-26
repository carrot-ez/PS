package Programmers;

import java.util.HashSet;
import java.util.Set;

public class Expressing_as_N {
    public static void main(String args[]) {
        int result = new Expressing_as_N().new Solution().solution(5, 12);
        System.out.println(result);
    }

    class Solution {
        private Set<Integer> sets[];
        public int solution(int N, int number) {
            // init
            int answer = - 1;
            sets = new Set[8]; // sets[i] : all possible elements in i times.

            int n = 0;
            for(int i = 0; i < sets.length; i++) {
                sets[i] = new HashSet<>();
                n = n*10 + N;
                sets[i].add(n);
            }

            // calculate each sets[j] elements and set[i-j-1] elements
            for(int i = 0; i< sets.length; i++) {
                for(int j=0; j<i; j++) {
                    for(int cur: sets[j]) {
                        for(int prev : sets[i-j-1]) {
                            sets[i].add(cur + prev);
                            sets[i].add(cur - prev);
                            sets[i].add(cur * prev);
                            if(prev != 0) {
                                sets[i].add(cur/prev);
                            }
                        }
                    }
                }

                if(sets[i].contains(number)) {
                    answer = i+1;
                    break;
                }
            }

            return answer;
        }
    }
}
