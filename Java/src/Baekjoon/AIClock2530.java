package Baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AIClock2530 {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // init var
        String[] splits = br.readLine().split(" ");
        int hour = Integer.parseInt(splits[0]);
        int minute = Integer.parseInt(splits[1]);
        int second = Integer.parseInt(splits[2]);

        int cookTime = Integer.parseInt(br.readLine());

        // calender
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, minute);
        calendar.set(Calendar.SECOND, second);

        // add time
        calendar.add(Calendar.SECOND, cookTime);

        SimpleDateFormat sdf = new SimpleDateFormat("H m s");

//        System.out.println(calendar.get(Calendar.HOUR_OF_DAY) +" "+ calendar.get(Calendar.MINUTE)+" "+ calendar.get(Calendar.SECOND));
        System.out.println(sdf.format(calendar.getTime()));
    }
}
