package Line;

import java.util.LinkedList;
import java.util.Queue;

public class No5 {
    public static void main(String args[]) {
        int[] card = {10, 13, 10, 1, 2, 3, 4, 5, 6, 2};
        int result = new No5().solution(card);

        System.out.println(result);
    }

    public int solution(int[] cards) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        for(int e : cards) {
            if(e > 9)
                queue.add(10);
            else
                queue.add(e);
        }

        while(queue.size() > 3) {
            int[] player = new int[2];
            int[] dealer = new int[2];
            int openCard = 0;
            // player 1턴
            addScore(player, queue.poll());
            // dealer 1턴
            addScore(dealer, queue.poll());
            // player 2턴
            addScore(player, queue.poll());
            // dealer 2턴
            openCard = queue.poll();
            addScore(dealer, openCard);

            // player가 21을 받은 경우
            if(player[0] == 21 || player[1] == 21) {
                if(dealer[0] < 21 && dealer[1] < 21)
                    answer += 3;
                continue;
            }

            if(openCard == 1 || openCard >= 7) {
                // 17 이상이 될때까지 받기
                try {
                    while ((player[0] < 17 && player[1] < 17)) {
                        addScore(player, queue.poll());
                    }
                } catch(Exception e) {
                    break;
                }
                // bust
                if(player[0] > 21 && player[1] > 21) {
                    answer -= 2;
                    continue;
                }
            }
            else if(openCard == 4 || openCard == 5 || openCard == 6) {
                // 받지 않기
            }
            else if(openCard == 2 || openCard == 3) {
                // 12 이상이 될 때 까지 받기
                try {
                    while ((player[0] < 12 && player[1] < 12)) {
                        addScore(player, queue.poll());
                    }
                } catch(Exception e){
                    break;
                }
                // bust
                if(player[0] > 21 && player[1] > 21) {
                    answer -= 2;
                    continue;
                }
            }

            // dealer 17이상까지 카드받기
            try {
                while (dealer[0] < 17 && dealer[1] < 17) {
                    addScore(dealer, queue.poll());
                }
            } catch(Exception e) {
                break;
            }
            // dealer bust
            if(dealer[0] > 21 && dealer[1]  > 21) {
                answer += 2;
                continue;
            }

            //System.out.println(Math.max(player[0], player[1])+" vs "+ Math.max(dealer[0], dealer[1]);
            // 이긴 경우
            if(Math.max(player[0], player[1]) > Math.max(dealer[0], dealer[1])) {
                answer += 2;
            }
            // 진 경우
            else if(Math.max(player[0], player[1]) < Math.max(dealer[0], dealer[1])) {
                answer -= 2;
            }

        }
        return answer;
    }

    public void addScore(int[] player, int card) {
        if(card == 1) {
            player[0] += 1;
            player[1] += 11;
        }
        else {
            player[0] += card;
            player[1] += card;
        }
    }
}
