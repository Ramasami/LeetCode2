import java.util.*;

class XOfAKindInADeckOfCards {

    int gcd(int a, int b) {
        if (b == 0 || a == 0)
            return Math.max(a, b);
        if (a > b)
            return gcd(a - b, a);
        else
            return gcd(a, b - a);
    }

    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int card : deck) {
            count.compute(card, (k, value) -> {
                return value == null ? 1 : value + 1;
            });
        }
        Integer prevCount = null;
        for (Integer c : count.values()) {
            if (prevCount == null) {
                prevCount = c;
            }
            prevCount = gcd(c, prevCount);
            if (prevCount == 1)
                return false;
        }
        return true;
    }
}