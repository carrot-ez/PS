package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TileDiagonal2168 {
    /*
        subset이 있는 경우를 배제하기 위해 최대공약수로 나눠준다.
        최대공약수로 나눠진 직사각형은 시작점과 끝점을 제외한 어떠한 꼭지점도 지나지 않는다.
        따라서 대각선이 지나는 사각형은 width + height - 1 이 된다.
        이 결과를 최대공약수로 곱해주면 된다.
     */
    public static void main(String args[]) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        String[] splits = br.readLine().split(" ");
        int width = Integer.parseInt(splits[0]);
        int height = Integer.parseInt(splits[1]);
        int gcd = getGCD(width, height);

        width /= gcd;
        height /= gcd;

        System.out.println((width + height - 1) * gcd);
    }

    // 유클리드 호제법으로 최대공약수 구하는 함수
    public static int getGCD(int x, int y) {
        while(x > 0) {
            int tmp = x;
            x = y % x;
            y = tmp;
        }
        return y;
    }
}
