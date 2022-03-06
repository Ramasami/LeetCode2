public class MaximumNumberOfWordsFoundInSentences {
    public int mostWordsFound(String[] sentences) {
        int ans = 0;
        for (int i = 0; i < sentences.length; i++) {
            int space = 1;
            for (int j = 0; j < sentences[i].length(); j++) {
                if (sentences[i].charAt(j) == ' ')
                    space++;
            }
            ans = Math.max(ans, space);
        }

        return ans;
    }
}