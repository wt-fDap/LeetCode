int largestInteger(int* nums, int numsSize, int k) {
    // Frequency array since elements are constrained between 0 and 50
    int count[51] = {0};
    for (int i = 0; i < numsSize; i++) {
        count[nums[i]]++;
    }

    // Case 1: k equals array size
    if (k == numsSize) {
        int max_val = nums[0];
        for (int i = 1; i < numsSize; i++) {
            if (nums[i] > max_val) max_val = nums[i];
        }
        return max_val;
    }

    // Case 2: k = 1
    if (k == 1) {
        int max_unique = -1;
        for (int i = 0; i < numsSize; i++) {
            if (count[nums[i]] == 1) {
                if (nums[i] > max_unique) {
                    max_unique = nums[i];
                }
            }
        }
        return max_unique;
    }

    // Case 3: 1 < k < numsSize
    int ans = -1;
    
    // Check first element
    int first_elem = nums[0];
    int first_freq = 0;
    for (int i = 0; i < numsSize; i++) {
        if (nums[i] == first_elem) first_freq++;
    }
    if (first_freq == 1) {
        ans = first_elem;
    }

    // Check last element
    int last_elem = nums[numsSize - 1];
    int last_freq = 0;
    for (int i = 0; i < numsSize; i++) {
        if (nums[i] == last_elem) last_freq++;
    }
    if (last_freq == 1) {
        if (last_elem > ans) {
            ans = last_elem;
        }
    }

    return ans;
}