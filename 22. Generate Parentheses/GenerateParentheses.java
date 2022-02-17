import java.util.*;

public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        find(n, 0, 0, ans, sb);
        return ans;
    }

    void find(int n, int o, int c, List<String> ans, StringBuilder sb) {
        if (o == n && c == n) {
            ans.add(sb.toString());
            return;
        }
        if (o == n) {
            for (int i = c; i < n; i++)
                sb.append(")");
            ans.add(sb.toString());
            sb.delete(o + c, 2 * n);
            return;
        }
        find(n, o + 1, c, ans, sb.append("("));
        sb.deleteCharAt(o + c);
        if (o != c) {
            find(n, o, c + 1, ans, sb.append(")"));
            sb.deleteCharAt(o + c);
        }

    }
}