package Programmers;

public class Country124 {
    public static void main(String args[]) {
        int n = 1;
        for(int i=1; i<10; i++) {
            String result = new Country124().solution(i);
            System.out.println(result);
        }
    }

    public String solution(int n) {
        StringBuilder sb = new StringBuilder();

        while(n > 0) {
            switch(n % 3) {
                case 0 :
                    sb.insert(0, "4");
                    break;
                case 1:
                    sb.insert(0, "1");
                    break;
                case 2:
                    sb.insert(0, "2");
                    break;
            }
            n = (n-1)/3;
        }

        return sb.toString();
    }
}
