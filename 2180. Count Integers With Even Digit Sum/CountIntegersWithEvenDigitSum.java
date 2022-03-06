public class CountIntegersWithEvenDigitSum {
    public int countEven(int num) {
        int x = 0;
        int y = num;
        while (y > 0) {
            x += y % 10;
            y /= 10;
        }
        if (x % 2 == 1)
            return (num - 1) / 2;
        return num / 2;
    }
}