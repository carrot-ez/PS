package Programmers;

public class WhatDay2016 {
    public static void main(String args[]) {
        int a = 5;
        int b = 24;
        System.out.println(new WhatDay2016().solution(a, b));
    }

    public String solution(int a, int b) {
        String dayOfTheWeek[] = {"FRI","SAT", "SUN","MON","TUE","WED","THU"};
        int days = -1;
        switch(a) {
            case 12 :
                days += 30;
            case 11:
                days += 31;
            case 10:
                days += 30;
            case 9:
                days += 31;
            case 8:
                days += 31;
            case 7:
                days += 30;
            case 6:
                days += 31;
            case 5:
                days += 30;
            case 4:
                days += 31;
            case 3:
                days += 29;
            case 2:
                days += 31;
        }

        days += b;

        days = days % 7;
        String answer = dayOfTheWeek[days];

        return answer;
    }
}
