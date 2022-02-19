import java.util.*;

public class MinimizeDeviationInArray {
    public int minimumDeviation(int[] nums) {
        for (int i = 0; i < nums.length; i++)
            if (nums[i] % 2 == 1)
                nums[i] *= 2;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Comparator.reverseOrder());
        int min = Integer.MAX_VALUE;
        for (int x : nums) {
            maxHeap.add(x);
            min = Math.min(x, min);
        }
        int ans = Integer.MAX_VALUE;
        while (true) {
            int max = maxHeap.poll();
            ans = Math.min(ans, max - min);
            if (max % 2 == 0) {
                if (max / 2 < min)
                    min = max / 2;
                else
                    ans = Math.min(ans, max - min);
                max /= 2;
                maxHeap.add(max);
            } else {
                break;
            }
        }
        return ans;
    }
}