package leetcode;

public class _3Sum_Closet {

    class Solution {

        private int ans = 0;
        private int gap = Integer.MAX_VALUE;
        private boolean[] visited;

        public int threeSumClosest(int[] nums, int target) {

            visited = new boolean[nums.length];

            backTracking(nums, target, 0, 0, 0);

            return ans;
        }

        public void backTracking(int[] nums, int target, int idx, int depth, int sum) {

            if (depth == 3) {
                int gapCurr = Math.abs(target - sum);
                if (gapCurr < gap) {
                    ans = sum;
                    gap = gapCurr;
                }
                return;
            }

            for (int i = idx; i < nums.length; i++) {
                if (visited[i])
                    continue;

                visited[i] = true;
                backTracking(nums, target, i + 1, depth + 1, sum + nums[i]);
                visited[i] = false;
            }
        }

        public void print() {
            for (int i = 0; i < visited.length; i++) {
                if (visited[i])
                    System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
