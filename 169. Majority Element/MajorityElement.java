public class MajorityElement {
    public int majorityElement(int[] nums) {
        int a = 0, b = 0, c1 = -1, c2 = -1;
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if (c1 != -1 && a == n)
                c1++;
            else if (c2 != -1 && b == n)
                c2++;
            else if (c1 < 1) {
                c1 = 1;
                a = n;
            } else if (c2 < 1) {
                c2 = 1;
                b = n;
            } else {
                c1--;
                c2--;
            }
        }
        c1 = 0;
        c2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == a)
                c1++;
            else if (nums[i] == b)
                c2++;
        }
        return c1 > c2 ? a : b;
    }
}