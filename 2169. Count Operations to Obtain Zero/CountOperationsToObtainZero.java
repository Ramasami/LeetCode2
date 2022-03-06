public class CountOperationsToObtainZero {
    public int countOperations(int a, int b) {
        int ans = 0;
        while (a > 0 && b > 0) {
            if (a > b)
                a -= b;
            else
                b -= a;
            ans++;
        }
        return ans;
    }
}