import java.util.*;

class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> continuousSum = new HashMap<>();
        int ans = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            ans += continuousSum.getOrDefault(sum - k, 0);
            if (sum == k)
                ans++;
            continuousSum.compute(sum, (key, value) -> {
                if (value == null)
                    value = 0;
                return value + 1;
            });
        }
        return ans;
    }
}