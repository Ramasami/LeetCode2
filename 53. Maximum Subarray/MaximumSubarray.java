public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int minSum = 0;
        int sum = 0;
        int ans = 0;
        boolean nonNegative = false;
        int minNegative = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            ans = Math.max(sum - minSum, ans);
            minSum = Math.min(minSum, sum);
            if (nums[i] >= 0)
                nonNegative = true;
            else
                minNegative = Math.max(minNegative, nums[i]);
        }
        return nonNegative ? ans : minNegative;
    }
}
