import java.util.*;

class MostFrequentNumberFollowingKeyInAnArray {
    public int mostFrequent(int[] nums, int key) {
        Map<Integer, Integer> count = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n - 1; i++) {
            if (nums[i] == key) {
                count.compute(nums[i + 1], (k, v) -> v == null ? 1 : v + 1);
            }
        }
        int max = 0;
        int maxCount = 0;
        for (Map.Entry<Integer, Integer> e : count.entrySet()) {
            if (e.getValue() > maxCount) {
                maxCount = e.getValue();
                max = e.getKey();
            }
        }
        return max;
    }
}