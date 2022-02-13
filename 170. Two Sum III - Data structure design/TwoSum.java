import java.util.*;

public class TwoSum {

    private Map<Integer, Integer> nums;

    public TwoSum() {
        nums = new HashMap<>();
    }

    public void add(int number) {
        nums.compute(number, (k, v) -> {
            if (v == null)
                v = 0;
            return v + 1;
        });
    }

    public boolean find(int value) {
        for (Integer num : nums.keySet()) {
            if (nums.containsKey(value - num)) {
                if (value - num == num)
                    return nums.get(value - num) > 1;
                return true;
            }
        }
        return false;
    }
}