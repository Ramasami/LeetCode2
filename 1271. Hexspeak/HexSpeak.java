public class HexSpeak {
    public String toHexspeak(String num) {
        long n = Long.parseLong(num);
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            long t = n % 16;
            n /= 16;
            if (t > 1 && t < 10) {
                return "ERROR";
            } else if (t == 0) {
                sb.insert(0, "O");
            } else if (t == 1) {
                sb.insert(0, "I");
            } else {
                sb.insert(0, (char) ('A' + (t - 10)));
            }
        }
        return sb.toString();
    }

}