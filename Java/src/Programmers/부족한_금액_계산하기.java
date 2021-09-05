package Programmers;

public class 부족한_금액_계산하기 {

    class Solution {
        public long solution(int price, int money, int count) {

            long totalPrice = getTotalPrice(price, count);
            long longMoney = money;
            longMoney -= totalPrice;

            return longMoney < 0 ? -longMoney : 0;
        }

        public long getTotalPrice(int price, int count) {

            long totalPrice = 0;
            for (int i = 1; i < count + 1; i++) {
                totalPrice += (long) price * i;
            }

            return totalPrice;
        }
    }
}
