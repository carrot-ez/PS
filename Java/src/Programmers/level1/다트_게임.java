package Programmers.level1;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class 다트_게임 {

    public int solution(String dartResult) {

        String numbers = "0123456789";
        String bonuses = "SDT";
        String options = "*#";

        Stack<Integer> scores = new Stack<>();

        for (int i = 0; i < dartResult.length(); i++) {

            char c = dartResult.charAt(i);

            // 숫자 처리
            if (numbers.indexOf(c) >= 0) {
                // 10
                if (numbers.indexOf(dartResult.charAt(i + 1)) >= 0) {
                    scores.push(10);
                    i += 1;
                }
                // 0 ~ 9
                else {
                    scores.push(Character.getNumericValue(c));
                }
            }
            // 보너스 처리
            if (bonuses.indexOf(c) >= 0) {
                Integer e = scores.pop();
                switch (c) {
                    case 'D':
                        e = (int) Math.pow(e, 2);
                        break;
                    case 'T' :
                        e = (int) Math.pow(e, 3);
                        break;
                }
                scores.push(e);
            }
            // 옵션 처리
            if (options.indexOf(c) >= 0) {
                switch (c) {
                    case '*':
                        Integer first = scores.pop();
                        if (scores.isEmpty()) {
                            first = first * 2;
                            scores.push(first);
                            break;
                        }
                        Integer second = scores.pop();

                        first *= 2;
                        second *= 2;
                        scores.push(second);
                        scores.push(first);
                        break;
                    case '#' :
                        Integer e = scores.pop();
                        scores.push(-e);
                        break;
                }
            }
        }

        int answer = 0;
        for (Integer e : scores) {
            answer += e;
        }

        return answer;
    }
}
