import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n && nums[i] <= 0; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                find(i, nums, ans, n);
            }
        }
        return ans;
    }

    private void find(int i, int[] nums, List<List<Integer>> ans, int n) {
        int l = i + 1;
        int r = n - 1;
        while (l < r) {
            int sum = nums[i] + nums[l] + nums[r];
            if (sum == 0) {
                ans.add(Arrays.asList(nums[i], nums[l], nums[r]));
                l++;
                r--;
                while (l < r && nums[l] == nums[l - 1])
                    ++l;
            } else if (sum > 0)
                r--;
            else
                l++;
        }
    }
}