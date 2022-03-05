public class MaximumNumberOfCoinsYouCanGet {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int ans = 0;
        int n = piles.length;
        int mini = n / 3;
        for (int i = n - 2; i >= mini; i -= 2) {
            ans += piles[i];
        }
        return ans;
    }
}
