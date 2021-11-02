package Programmers.level1;

public class 가운데_숫자_가져오기 {
    public String solution(String s) {

        // s의 길이가 홍수면 가운데 1글자, 짝수면 가운데 2글자 가져오기
        int len = s.length();
        if (len % 2 != 0) {
            int left = len / 2;
            int right = (len + 1) / 2;

            return s.substring(left, right);
        } else {
            int mid = len / 2;

            return s.substring(mid - 1, mid + 1);
        }
    }
}
