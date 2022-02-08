public class AddDigits_O1 {
    public int addDigits(int num) {
        if (num == 0)
            return 0;
        return (num - 1) % 9 + 1;
    }
}