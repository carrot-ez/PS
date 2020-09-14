package Line;

public class No3 {
    public static void main(String args[]) {
        int n = 1100007;
        new No3().solution(n);
    }

    public int[] solution(int n) {
        int answer = 0;
        String s = Integer.toString( n);
        while(s.length() > 1) {
            int div = (s.length() - 1) / 2; // 나눌 위치
            int opt = 0; // 연산 횟수
            int dist = 0; // 0일경우 div와 떨어진 정도 비교

            if(s.charAt(div+1) == '0') {
                // div 정하기
                div = getDiv(s);
            }
            int n1 = Integer.parseInt(s.substring(0, div+1));
            int n2 = Integer.parseInt(s.substring(div+1, s.length()));
            n = n1 + n2;
            s = Integer.toString(n);
            answer += 1;
            if(s.length() == 1) {
                break;
            }
        }

        int result[] = new int[2];
        result[0] = answer;
        result[1] = n;
        return result;
    }

    public int getDiv(String s) {
        int divRight = (s.length() - 1) / 2;
        int distRight = 0;
        // count right
        while(s.charAt(divRight+1) == '0' && divRight+1 < s.length()) {
            divRight += 1;
            distRight += 1;
        }

        int divLeft = (s.length() - 1) / 2;
        int distLeft = 0;
        // count left
        while(s.charAt(divLeft) == '0' && divLeft > 0) {
            divLeft -= 1;
            distLeft += 1;
        }

        if(distLeft < distRight) {
            return divLeft - 1;
        }
        else {
            return divRight;
        }
    }
}
