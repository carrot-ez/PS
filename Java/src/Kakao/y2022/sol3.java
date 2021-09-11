package Kakao.y2022;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class sol3 {
    class Solution {

        private static final String IN = "IN";
        private static final String OUT = "OUT";

        public int[] solution(int[] fees, String[] records) {

            // params
            int basicTime = fees[0];
            int basicFee = fees[1];
            int extraTime = fees[2];
            int extraFee = fees[3];

            Map<String, TimeCalculator> map = new HashMap<>();

            for (String record : records) {
                String[] splits = record.split(" ");
                String time = splits[0];
                String carId = splits[1];
                String inOut = splits[2];

                TimeCalculator calculator = map.containsKey(carId) ? map.get(carId) : new TimeCalculator();
                calculator.calc(time, inOut);
                map.put(carId, calculator);
            }

            return map.keySet().stream()
                    .sorted(String::compareTo)
                    .mapToInt(e -> {
                        TimeCalculator timeCalculator = map.get(e);
                        int totalTime = timeCalculator.getTotalTime();
                        System.out.println(totalTime);
                        return calcFee(basicTime, basicFee, extraTime, extraFee, totalTime);
                    })
                    .toArray();
        }

        public int calcFee(int basicTime, int basicFee, int extraTime, int extraFee, int totalTime) {

            int res = 0;

            if (totalTime <= basicTime) {
                return basicFee;
            }

            totalTime -= basicTime;
            res += basicFee;

            double divTime = totalTime / (double) extraTime;
            int extras = (int) Math.ceil(divTime);
            res += extras * extraFee;
            return res;
        }

        class TimeCalculator {
            int totalTime;
            int recentMinutes;
            String inOut;

            public TimeCalculator() {
                this.totalTime = 0;
            }

            public void calc(String time, String inOut) {
                String[] splits = time.split(":");
                String hours = splits[0];
                String minutes = splits[1];
                int convertedTime = Integer.parseInt(hours) * 60 + Integer.parseInt(minutes);

                if (inOut.equals(IN)) {
                    this.recentMinutes = convertedTime;
                    this.inOut = IN;
                } else if (inOut.equals(OUT)) {
                    int gap = convertedTime - recentMinutes;

                    this.totalTime += gap;
                    this.recentMinutes = convertedTime;
                    this.inOut = OUT;
                }
            }

            public int getTotalTime() {
                if (inOut.equals(IN)) {
                    int gap = 1439 - recentMinutes; // 1439 = 23:59
                    totalTime += gap;
                    return totalTime;
                } else if (inOut.equals(OUT)) {
                    return totalTime;
                }
                throw new RuntimeException();
            }
        }
    }
}
