public class CountAllValidPickupAndDeliveryOptions {
    public int countOrders(int n) {
        int mod = 1_000_000_007;
        long prev = 1;
        for (int i = 2; i <= n; i++) {
            prev = i * (2 * i - 1) * prev;
            prev %= mod;
        }
        return (int) prev;
    }
}