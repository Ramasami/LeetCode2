public class Combinations {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<>();
        permute(list, new LinkedList<>(), 0, 0, n, k);
        return list;
    }

    private void permute(List<List<Integer>> list, LinkedList<Integer> curr, int i, int len, int n, int k) {
        if (len + n - i < k)
            return;
        if (len == k) {
            list.add(new ArrayList<>(curr));
            return;
        }
        permute(list, curr, i + 1, len, n, k);
        curr.addLast(i + 1);
        permute(list, curr, i + 1, len + 1, n, k);
        curr.removeLast();
    }
}