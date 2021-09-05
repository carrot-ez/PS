package Programmers;

import java.util.*;

public class 오픈채팅방 {

    public static void main(String[] args) {

    }

    Map<String, String> map = new HashMap<>();
    Queue<ChatInfo> queue = new LinkedList<>();

    public String[] solution(String[] record) {

        ArrayList<String> list = new ArrayList<>();

        for (String msg : record) {
            process(msg);
        }

        while (!queue.isEmpty()) {
            String msg = queue.poll().print();
            if (msg != null) {
                list.add(msg);
            }
        }

        return list.toArray(String[]::new);
    }

    public void process(String msg) {

        String[] splits = msg.split(" ");
        String command = splits[0];
        String id, nickname;

        switch (command) {
            case "Leave" :
                id = splits[1];
                queue.offer(new ChatInfo(command, id));
                break;
            case "Enter" :
            case "Change" :
                id = splits[1];
                nickname = splits[2];
                queue.offer(new ChatInfo(command, id));
                map.put(id, nickname);
                break;
        }
    }

    class ChatInfo {
        String command;
        String id;

        public ChatInfo(String command, String id) {
            this.command = command;
            this.id = id;
        }

        public String print() {
            switch (command) {
                case "Enter":
                    return map.get(id)+"님이 들어왔습니다.";
                case "Leave":
                    return map.get(id)+"님이 나갔습니다.";
            }

            return null;
        }
    }
}
