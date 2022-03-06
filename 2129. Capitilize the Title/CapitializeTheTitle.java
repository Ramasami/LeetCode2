public class CapitializeTheTitle {
    public String capitalizeTitle(String title) {
        int l = 0, r = 0;
        int n = title.length();
        StringBuilder s = new StringBuilder();
        while (r < n) {
            if (title.charAt(r) == ' ' || r == n - 1) {
                if (r == n - 1)
                    r++;
                int length = r - l;
                if (length == 0) {
                    l = r + 1;
                    r++;
                    continue;
                }
                if (length < 3)
                    s.append(Character.toLowerCase(title.charAt(l)));
                else
                    s.append(Character.toUpperCase(title.charAt(l)));
                l++;
                r++;
                while (l < r && l < n) {
                    s.append(Character.toLowerCase(title.charAt(l)));
                    l++;
                }
                continue;
            }
            r++;
        }
        return s.toString();
    }
}