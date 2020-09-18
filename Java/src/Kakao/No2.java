import java.util.*;

public class No2 {
    public static void main(String args[]) {
        String[] orders = {"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
        int[] course = {2, 3, 5};

        String[] result = new No2().solution(orders, course);
        for(String s : result) {
            System.out.println(s);
        }
    }

    public String[] solution(String[] orders, int[] course) {
        Map<String, Integer> map = new HashMap<>();


        for(int i=0; i< orders.length - 1; i++) {
            boolean[] check = new boolean[26];
            for(char c : orders[i].toCharArray()) {
                check[c-'A'] = true;
            }

            for(int j=i+1; j<orders.length; j++) {
                StringBuilder sb = new StringBuilder();
                for(char c : orders[j].toCharArray()) {
                    if(check[c-'A'])
                        sb.append(c);
                }
                addMap(map, sb.toString());
                partition(map, sb.toString());
            }
        }

        int[] max = new int[11];
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            for(int e : course) {
                if(entry.getKey().length() == e) {
                    if(max[e] < entry.getValue())
                        max[e] = entry.getValue();
                }
            }
        }

        List<String> resultList = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            for(int e : course) {
                if(entry.getKey().length() == e && entry.getValue() == max[e]) {
                    resultList.add(entry.getKey());
                }
            }
        }

        Collections.sort(resultList);
        return resultList.toArray(new String[0]);
    }

    public void partition(Map<String, Integer> map, String s) {
        if(s.length() > 1) {
            for (int i = 0; i < s.length(); i++) {
                StringBuffer sb = new StringBuffer(s);
                sb.deleteCharAt(i);
                addMap(map, sb.toString());
                partition(map, sb.toString());
            }
        }
    }

    public void addMap(Map<String, Integer> map, String s) {
        if(map.containsKey(s)) {
            map.put(s, map.get(s) + 1);
        }
        else {
            map.put(s, 1);
        }
    }
}