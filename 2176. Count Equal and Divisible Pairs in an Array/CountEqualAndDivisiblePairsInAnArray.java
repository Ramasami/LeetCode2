public class CountEqualAndDivisiblePairsInAnArray {

    int gcd(int a, int b) {
        if (a == 0 || b == 0)
            return Math.max(a, b);
        if (a > b)
            return gcd(a - b, b);
        else
            return gcd(a, b - a);
    }

    int lcm(int a, int b) {
        if (a == 0 || b == 0)
            return 1;
        return b / gcd(a, b);
    }

    public int countPairs(int[] nums, int k) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n - 1; i++) {
            int m = lcm(i, k);
            for (int j = 0; j < n; j += m) {
                if (j <= i)
                    continue;
                if (nums[j] == nums[i]) {
                    ans++;
                }
            }
        }
        return ans;
    }
}