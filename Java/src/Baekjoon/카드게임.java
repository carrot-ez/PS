package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 카드게임 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine()); // 테스트케이스 수

        for(int i=0; i<T; i++) {
             int N = Integer.parseInt(br.readLine()); // 카드 수
            int[] cards = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            // TWO POINTER
            int left = 0;
            int right = cards.length - 1;

            boolean turn = true; // true == 근우의 턴
            int sum = 0;

            while(left <= right) {
                if (cards[left] < cards[right]) {
                    if(turn) sum += cards[right];
                    right -= 1;
                }
                else {
                    if(turn) sum += cards[left];
                    left += 1;
                }
                turn = !turn; // 턴을 바꾼다.
            }

            System.out.println(sum);
        }
    }
}
