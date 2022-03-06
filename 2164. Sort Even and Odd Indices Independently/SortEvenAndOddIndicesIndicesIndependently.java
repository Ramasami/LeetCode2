public class SortEvenAndOddIndicesIndicesIndependently {
    public int[] sortEvenOdd(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i += 2) {
            for (int j = 0; j < n - 2; j += 2) {
                if (nums[j] > nums[j + 2]) {
                    int t = nums[j];
                    nums[j] = nums[j + 2];
                    nums[j + 2] = t;
                }
                if (j + 3 < n && nums[j + 1] < nums[j + 3]) {
                    int t = nums[j + 1];
                    nums[j + 1] = nums[j + 3];
                    nums[j + 3] = t;
                }
            }
        }
        return nums;
    }
}