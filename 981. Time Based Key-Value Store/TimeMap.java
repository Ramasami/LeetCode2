import java.util.*;

public class TimeMap {
    Map<String, List<Pair<Integer, String>>> map;

    public TimeMap() {
        map = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        map.compute(key, (k, v) -> {
            if (v == null)
                v = new ArrayList<>();
            v.add(new Pair<>(timestamp, value));
            return v;
        });
    }

    public String get(String key, int timestamp) {
        if (map.containsKey(key)) {
            List<Pair<Integer, String>> list = map.get(key);
            if (list == null)
                return "";
            else
                return binarySearch(list, timestamp, 0, list.size() - 1);
        } else {
            return "";
        }
    }

    private String binarySearch(List<Pair<Integer, String>> list, Integer ts, int l, int r) {
        if (l > r) {
            if (r == -1)
                return "";
            return list.get(r).getValue();
        }
        int m = l + (r - l) / 2;
        if (list.get(m).getKey() > ts) {
            return binarySearch(list, ts, l, m - 1);
        } else {

            return binarySearch(list, ts, m + 1, r);
        }
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */