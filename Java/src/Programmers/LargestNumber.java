package Programmers;

import java.util.*;

public class LargestNumber {
    public static void main(String args[]) {
        System.out.println("hello world");
        int numbers[] = {7, 77};

        String result = new LargestNumber().new Solution().solution(numbers);
        System.out.println(result);
    }

    class Solution {
        public String solution(int[] numbers) {
            Map<Integer, Integer> map = new HashMap<>();

            // adjust numbers length
            for(int i=0; i< numbers.length; i++) {
                String numString = Integer.toString(numbers[i]);
                if(numString.length() < 4) {
                    switch (numString.length()) {
                        case 1:
                            numString = numString + numString + numString + numString;
                            break;
                        case 2:
                            numString = numString + numString;
                            break;
                        case 3:
                            numString = numString + numString.charAt(0);
                            break;
                    }
                }

                int weightedNum = Integer.parseInt(numString);
                map.put(i, weightedNum);
            }

            // sort map by values
            List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(map.entrySet());
            Collections.sort(entryList, new Comparator<Map.Entry<Integer, Integer>>() {
                @Override
                public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                    return o2.getValue() - o1.getValue();
                }
            });

            // insert numbers into sb
            StringBuilder sb = new StringBuilder();
            for(Map.Entry entry : entryList) {
                sb.append(numbers[(int)entry.getKey()]);
            }

            if(sb.charAt(0) == '0') {
                return "0";
            }
            else {
                return sb.toString();
            }
        }

        public String solution_string(int[] numbers) {
            // int array to string array
            String s[] = new String[numbers.length];
            for(int i=0; i<numbers.length; i++) {
                s[i] = Integer.toString(numbers[i]);
            }

            // sort by each merged strings
            Arrays.sort(s, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return (o2+o1).compareTo(o1+o2);
                }
            });

            StringBuilder sb = new StringBuilder();
            for(String se : s) {
                sb.append(se);
            }

            String answer;
            // error handling if 0 appear more than once
            if(sb.charAt(0) == '0') {
                answer = "0";
            }
            else {
                answer = sb.toString();
            }
            return answer;
        }
    }
}
