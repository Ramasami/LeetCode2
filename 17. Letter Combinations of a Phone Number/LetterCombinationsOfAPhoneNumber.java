import jav.util.*;

class LetterCombinationsOfAPhoneNumber {

    Map<Character, List<String>> map = Map.of('2', Arrays.asList("a", "b", "c"),
            '3', Arrays.asList("d", "e", "f"),
            '4', Arrays.asList("g", "h", "i"),
            '5', Arrays.asList("j", "k", "l"),
            '6', Arrays.asList("m", "n", "o"),
            '7', Arrays.asList("p", "q", "r", "s"),
            '8', Arrays.asList("t", "u", "v"),
            '9', Arrays.asList("w", "x", "y", "z"));

    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        find(0, digits.length(), digits, ans, "");
        return ans;
    }

    private void find(int i, int n, String digits, List<String> ans, String s) {
        if (i == n) {
            if (n != 0)
                ans.add(s);
            return;
        }
        for (String c : map.get(digits.charAt(i)))
            find(i + 1, n, digits, ans, s + c);
    }
}