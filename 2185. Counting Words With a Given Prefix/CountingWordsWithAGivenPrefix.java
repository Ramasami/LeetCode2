public class CountingWordsWithAGivenPrefix {
    public int prefixCount(String[] words, String pref) {
        char[] s = pref.toCharArray();
        int n = s.length;
        int ans = 0;
        for (String w : words) {
            if (w.length() < n)
                continue;
            boolean flag = true;
            for (int i = 0; i < n; i++) {
                if (w.charAt(i) != s[i]) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                ans++;
        }
        return ans;
    }
}