package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 곱셈 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int num1 = Integer.parseInt(br.readLine());
        int num2 = Integer.parseInt(br.readLine());

        int ret = num1 * num2;

        for (int i = 0; i < 3; i++) {
            System.out.println(num1 * (num2 % 10));
            num2 /= 10;
        }

        System.out.println(ret);
    }
}
