public class FindKClosestElements {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        int position = binarySearch(arr, x, 0, n - 1);
        int l = position;
        int r = position;
        for (int i = 1; i < k; i++) {
            if (l == 0) {
                r++;
            } else if (r == n - 1) {
                l--;
            } else if (Math.abs(arr[l - 1] - x) <= Math.abs(arr[r + 1] - x)) {
                l--;
            } else {
                r++;
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = l; i <= r; i++) {
            ans.add(arr[i]);
        }
        return ans;
    }

    int binarySearch(int[] arr, int x, int l, int r) {
        if (l > r) {
            if (r == -1)
                return l;
            else if (l == arr.length)
                return r;
            else if (Math.abs(arr[l] - x) < Math.abs(arr[r] - x))
                return l;
            else
                return r;
        }
        int m = l + (r - l) / 2;
        if (arr[m] == x)
            return m;
        else if (arr[m] > x)
            return binarySearch(arr, x, l, m - 1);
        else
            return binarySearch(arr, x, m + 1, r);
    }
}