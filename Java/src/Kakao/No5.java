import java.util.Arrays;

public class No5 {
    public static void main(String args[]) {
        String paly_time = "02:03:55";
        String adv_time = "00:14:15";
        String[] logs = {"01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30"};

        String result = new No5().solution(paly_time, adv_time, logs);
    }

    public String solution(String play_time, String adv_time, String[] logs) {
        // logs를 정렬하자.
        Arrays.sort(logs);
        for(String s : logs) {
            String[] splits = s.split("-");
            String startTime = splits[0];
            String endTime = splits[1];
        }



        String answer = "";
        return answer;
    }

}
