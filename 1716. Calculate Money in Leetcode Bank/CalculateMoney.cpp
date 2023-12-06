class Solution {
public:
    int totalMoney(int n) {
        int w = n/7;
        int d = n%7;
        int ans = ((49 + 7 * w) * w + d * (2 * w + d + 1)) / 2;
        return ans;
    }
};