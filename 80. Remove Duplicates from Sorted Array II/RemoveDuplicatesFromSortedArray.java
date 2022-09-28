public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int l = 0, r = 0;
        int n = nums.length;
        while (r < n) {
            if (r < n - 2 && nums[r] == nums[r + 1] && nums[r + 2] == nums[r + 1]) {
                r++;
                continue;
            }
            nums[l++] = nums[r++];
        }
        return l;
    }
}