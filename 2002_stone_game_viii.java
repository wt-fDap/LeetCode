class Solution {
    public int stoneGameVIII(int[] stones) {
        int n = stones.length;
        int[] prefix = stones.clone();
        
        // Compute prefix sums
        for (int i = 1; i < n; i++) {
            prefix[i] += prefix[i - 1];
        }
        
        // Base case: when only 2 stones are left (starting at index n - 2), 
        // the current player must take all remaining stones.
        int res = prefix[n - 1];
        
        // Work backwards from n - 2 down to 1
        for (int i = n - 2; i >= 1; i--) {
            res = Math.max(res, prefix[i] - res);
        }
        
        return res;
    }
}