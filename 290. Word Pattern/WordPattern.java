import java.util.*;

public class WordPattern {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> charMap = new HashMap<>();
        Map<String, Character> wordMap = new HashMap<>();
        String[] words = s.split(" ");

        if (words.length != pattern.length())
            return false;

        for (int i = 0; i < words.length; i++) {
            char c = pattern.charAt(i);
            String w = words[i];
            if (!charMap.containsKey(c)) {
                if (wordMap.containsKey(w)) {
                    return false;
                } else {
                    charMap.put(c, w);
                    wordMap.put(w, c);
                }

            } else {
                String word = charMap.get(c);
                if (!word.equals(w))
                    return false;
            }
        }

        return true;
    }
}