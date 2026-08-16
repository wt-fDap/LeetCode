#include <stdbool.h>
#include <stdlib.h>

bool stoneGameIX(int* stones, int stonesSize) {
    int count[3] = {0};
    
    // Count remainders modulo 3
    for (int i = 0; i < stonesSize; i++) {
        count[stones[i] % 3]++;
    }
    
    // If the number of type 0 stones is even
    if (count[0] % 2 == 0) {
        return count[1] > 0 && count[2] > 0;
    }
    
    // If the number of type 0 stones is odd
    return abs(count[1] - count[2]) > 2;
}