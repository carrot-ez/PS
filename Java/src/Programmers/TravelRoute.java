package Programmers;

import java.util.*;

public class TravelRoute {
    List<String> resultList;
    public static void main(String args[]) {
        String tickets[][] = {{"ICN", "BOO"}, {"ICN", "COO"}, {"COO", "DOO"}, {"DOO", "COO"}, {"BOO", "DOO"}, {"DOO", "BOO"}, {"BOO", "ICN"}, {"COO", "BOO"}};
        String result[] = new TravelRoute().solution(tickets);
        for(String e : result) {
            System.out.print(e+" ");
        }
    }

    public String[] solution(String[][] tickets) {
        resultList = new ArrayList<>();

        for(int i=0; i< tickets.length; i++) {
            if(tickets[i][0].equals("ICN")) {
                // dfs
                List<String[]> list = new ArrayList<>(Arrays.asList(tickets));
                list.remove(tickets[i]);
                dfs(tickets[i], list, new ArrayList<String>());
            }
        }
//        for(String s : resultList) {
//            System.out.println(s);
//        }
        Collections.sort(resultList);
        return resultList.get(0).split(" ");
    }

    public void dfs(String[] start, List<String[]> list, List<String> result) {
        result.add(start[0]);
        if(list.isEmpty()) {
            result.add(start[1]);
            StringBuilder builder = new StringBuilder();
            for(String s : result) {
                builder.append(s).append(" ");
            }
            resultList.add(builder.toString());
            result.remove(result.lastIndexOf(start[0]));
            result.remove(result.lastIndexOf(start[1]));
            return;
        }

        for(String[] arr : list) {
            if(start[1].equals(arr[0])) {
                List<String[]> tmp = new ArrayList<>(list);
                tmp.remove(arr);
                dfs(arr, tmp, result);
            }
        }
        result.remove(result.lastIndexOf(start[0]));
    }

//    public String[] getResult(List<String[]> resultList) {
//        String[] result = null;
//        for(String[] arr : resultList) {
//            if(result == null) {
//                result = arr;
//                continue;
//            }
//            for(int i=0; i<arr.length; i++) {
//                if(result[i].compareTo(arr[i]) < 0) {
//                    break;
//                }
//                else if(result[i].compareTo(arr[i]) > 0) {
//                    result = arr;
//                    break;
//                }
//            }
//        }
//        return result;
//    }
}
