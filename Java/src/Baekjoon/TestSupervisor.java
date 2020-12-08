package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestSupervisor {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int numClasses = Integer.parseInt(br.readLine()); // 시험장의 수
        int[] numStudents = new int[numClasses]; // 각 시험장의 수험생 수

        String[] splits = br.readLine().split(" ");
        for(int i=0; i<numClasses; i++) {
            numStudents[i] = Integer.parseInt(splits[i]);
        }

        splits = br.readLine().split(" ");
        int[] numSupervision = new int[2]; // 각 감독관이 감시할 수 있는 응시자 수, @idx 0:총감독관(1명), @idx 1:부감독관(n명)
        for(int i=0; i<2; i++) {
            numSupervision[i] = Integer.parseInt(splits[i]);
        }

        long result = 0L; // 최종적으로 필요한 감독관 수


        /**
         * 1. 총 감독관이 감시할 수 있는 대상을 뺀다.
         * 2. 만약 감시해야 할 응시자가 남아있다면, n 명의 부 감독관을 통해 감독할 수 있게 한다.
         * 3. 1+n의 값을 결과 값에 더한다.
         */
        for(int i=0; i<numClasses; i++) {
            numStudents[i] = numStudents[i] - numSupervision[0];
            result += 1;

            if(numStudents[i] <= 0) {
                continue;
            }

            if(numStudents[i] % numSupervision[1] == 0) {
                result += numStudents[i]/numSupervision[1];
            }
            else {
                result += numStudents[i]/numSupervision[1] + 1;
            }
        }

        System.out.println(result);
    }
}
