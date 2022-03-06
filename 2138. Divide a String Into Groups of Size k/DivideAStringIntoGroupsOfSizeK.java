public class DivideAStringIntoGroupsOfSizeK {
    public String[] divideString(String s, int k, char fill) {
        int n = s.length();
        int m = (n + k - 1) / k;
        String[] ans = new String[m];
        for (int i = 0, j = 0; i < n; i += k, j++) {
            ans[j] = s.substring(i, Math.min(i + k, n));
        }
        if (ans[m - 1].length() < k) {
            StringBuilder sb = new StringBuilder(ans[m - 1]);
            for (int i = sb.length(); i < k; i++) {
                sb.append(fill);
            }
            ans[m - 1] = sb.toString();
        }
        return ans;
    }
}