package Programmers;

/**
 * 처리 미흡했던 부분:
 * 1. 갯수를 세는 과정에서 1개씩 덜 세어 틀림. ex) 15a10b -> 14a9b 로 세어 틀림
 * 2. 한 개의 input인 경우 처리 미흡.
 *     ex)
 *      for-loop 에서 1개인 경우 i = 1 ~ 0 이므로 돌지 않아 default 값 리턴
 *      for-loop 들어가기 전 초깃값을 구하는 것으로 해결
 */
public class 문자열_압축 {

    public static void main(String[] args) {
        int len = new Solution().compression("a", 1);
        System.out.println("len = " + len);
    }

    static class Solution {
        public int solution(String s) {

            int answer = compression(s, 1);

            for (int i = 2; i < s.length() / 2 + 1; i++) {
                answer = Math.min(answer, compression(s, i));
            }

            return answer;
        }

        public int compression(String s, int gap) {

            int pos = gap;
            String pattern = s.substring(0, pos);
            int len = s.length();
            int cnt = 0;

            while (pos + gap <= s.length()) {
                String comp = s.substring(pos, pos + gap);

                if (pattern.equals(comp)) {
                    cnt += 1;
                } else if (cnt > 0) {
                    len -= gap * cnt;
                    len += Integer.toString(cnt + 1).length();
                    cnt = 0;
                }

                pos += gap;
                pattern = comp;
            }

            if (cnt > 0) {
                len -= gap * cnt;
                len += Integer.toString(cnt + 1).length();
            }

            return len;
        }
    }
}
