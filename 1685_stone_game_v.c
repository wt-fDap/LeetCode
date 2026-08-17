#include <string.h>
#include <stdlib.h>
#include <math.h>

int memo[505][505];
int prefixSum[505];

int getSum(int l, int r) {
    if (l == 0) return prefixSum[r];
    return prefixSum[r] - prefixSum[l - 1];
}

int solve(int l, int r) {
    if (l == r) return 0;
    if (memo[l][r] != -1) return memo[l][r];

    int maxScore = 0;
    
    // Try every possible split point i between l and r
    for (int i = l; i < r; ++i) {
        int leftSum = getSum(l, i);
        int rightSum = getSum(i + 1, r);

        if (leftSum < rightSum) {
            maxScore = fmax(maxScore, leftSum + solve(l, i));
        } else if (leftSum > rightSum) {
            maxScore = fmax(maxScore, rightSum + solve(i + 1, r));
        } else {
            int leftScore = leftSum + solve(l, i);
            int rightScore = rightSum + solve(i + 1, r);
            maxScore = fmax(maxScore, fmax(leftScore, rightScore));
        }
    }
    
    return memo[l][r] = maxScore;
}

int stoneGameV(int* stoneValue, int stoneValueSize) {
    if (stoneValueSize <= 1) return 0;
    
    memset(memo, -1, sizeof(memo));
    
    // Precompute prefix sums for O(1) subarray sum lookups
    prefixSum[0] = stoneValue[0];
    for (int i = 1; i < stoneValueSize; ++i) {
        prefixSum[i] = prefixSum[i - 1] + stoneValue[i];
    }

    return solve(0, stoneValueSize - 1);
}