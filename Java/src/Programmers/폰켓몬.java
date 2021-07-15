import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 폰켓몬 {

    public static void main(String[] args) {

        int[] nums = {3, 1, 2, 3};
        new 폰켓몬().solution(nums);
    }

    public int solution(int[] nums) {

        Set set = new HashSet();
        for (int e : nums) {
            set.add(e);
        }

        int pick = nums.length / 2;

        return Math.min(pick, set.size());
    }
}
