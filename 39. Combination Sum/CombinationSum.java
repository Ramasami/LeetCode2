import java.util.*;

class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        find(candidates.length - 1, 0, ans, candidates, target, new LinkedList<>());
        return ans;
    }

    private void find(int i, int sum, List<List<Integer>> ans, int[] candidate, int target, LinkedList<Integer> curr) {
        if (sum == target) {
            ans.add(new ArrayList<>(curr));
        }
        if (sum >= target || i == -1)
            return;
        find(i - 1, sum, ans, candidate, target, curr);
        int n = candidate[i];
        int j = 1;
        while (n + sum <= target) {
            sum += n;
            curr.add(n);
            find(i - 1, sum, ans, candidate, target, curr);
            j++;
        }
        while (j-- > 1) {
            curr.removeLast();
        }
    }
}