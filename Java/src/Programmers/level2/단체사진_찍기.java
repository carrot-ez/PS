package Programmers.level2;

public class 단체사진_찍기 {
    private static String[] friends = {"A", "C", "F", "J", "M", "N", "R", "T"};
    private static boolean[] isVisited = new boolean[friends.length];
    private static int answer = 0;

    public static void main(String[] args) {
        String[] data = {"N~F=0", "R~T>2"};
        new 단체사진_찍기().solution(2, data);
    }

    public int solution(int n, String[] data) {

        backTracking(new StringBuilder(), data, 0);

        return answer;
    }

    public void backTracking(StringBuilder sb, String[] data, int startIdx) {
        if (sb.length() == friends.length) {
            if (isMatchCondition(sb, data)) {
                answer += 1;
            }
            return;
        }

        for (int i = 0; i < friends.length; i++) {
            if (isVisited[i]) continue;

            sb.append(friends[i]);
            isVisited[i] = true;
            backTracking(sb, data, i + 1);
            sb.deleteCharAt(sb.lastIndexOf(friends[i]));
            isVisited[i] = false;
        }

    }

    public boolean isMatchCondition(StringBuilder sb, String[] data) {
        for (String e : data) {
            String[] split = e.split("");
            int from = sb.indexOf(split[0]);
            int to = sb.indexOf(split[2]);
            int dif = Math.abs(from - to) - 1;
            int distance = Integer.parseInt(split[4]);
            switch (split[3]) { // operator
                case "=":
                    if (dif != distance) {
                        return false;
                    }
                    break;
                case ">" :
                    if (dif <= distance) {
                        return false;
                    }
                    break;
                case "<" :
                    if (dif >= distance) {
                        return false;
                    }
                    break;
            }
        }
        return true;
    }
}
