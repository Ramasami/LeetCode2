import java.util.HashMap;
import java.util.Map;

public class MaximumSizeSubbarraySumEqualsK {
    public int maxSubArrayLen(int[] nums, int k) {
        Map<Integer, Integer> cSum = new HashMap<>();
        cSum.put(0, -1);
        int sum = 0;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (cSum.containsKey(sum - k)) {
                ans = Math.max(ans, i - cSum.get(sum - k));
            }
            cSum.putIfAbsent(sum, i);
        }
        return ans;
    }
}