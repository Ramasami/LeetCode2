import java.util.*;

public class MissingRanges {

    private List<String> add(int a, int b, List<String> ans) {
        if (a == b)
            ans.add(String.valueOf(a));
        else
            ans.add(a + "->" + b);
        return ans;
    }

    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        if (nums.length == 0)
            return add(lower, upper, new ArrayList());
        int n = nums.length;
        List<String> ans = new ArrayList<>();

        if (nums[0] > lower && nums[0] <= upper)
            add(lower, (nums[0] - 1), ans);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < lower) {
                if (nums[i + 1] < lower)
                    continue;
                if (nums[i + 1] != lower)
                    add(lower, Math.min(nums[i + 1], upper), ans);
            } else if (nums[i] < upper) {
                if (nums[i + 1] > upper)
                    add(nums[i] + 1, upper, ans);
                else if (nums[i + 1] - nums[i] > 1)
                    add((nums[i] + 1), (nums[i + 1] - 1), ans);
            }
        }
        if (nums[n - 1] < upper && nums[n - 1] >= lower)
            add(nums[n - 1] + 1, upper, ans);
        return ans;
    }
}