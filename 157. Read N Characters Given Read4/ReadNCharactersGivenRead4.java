public class ReadNCharactersGivenRead4 {

    public int read(char[] buf, int n) {
        for (int i = 0; i * 4 < n; i++) {
            char[] buf4 = new char[4];
            int charRead = read4(buf4);
            for (int j = i * 4, k = 0; k < charRead && i * 4 + k < n; j++, k++) {
                buf[j] = buf4[k];
            }
            if (charRead < 4) {
                return Math.min(i * 4 + charRead, n);
            }
        }
        return n;
    }
}