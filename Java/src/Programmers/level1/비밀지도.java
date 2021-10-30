package Programmers.level1;

public class 비밀지도 {

    public String[] solution(int n, int[] arr1, int[] arr2) {

        String[] secretMap = new String[n];

        for (int i = 0; i < n; i++) {
            // 두 지도 합치기
            int secretRow = arr1[i] | arr2[i];

            // binary값으로 변환하여 지도에 입력하기
            StringBuilder sb = new StringBuilder();
            for (int k = 0; k < n; k++) {
                if ((secretRow & 1) == 1) {
                    sb.insert(0, '#');
                } else {
                    sb.insert(0, ' ');
                }

                secretRow >>= 1;
            }
            secretMap[i] = sb.toString();
        }

        return secretMap;
    }
}
