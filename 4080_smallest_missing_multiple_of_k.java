import java.util.*;
class Solution {
    public int missingMultiple(int[] nums, int k) {
        Arrays.sort(nums);
        int len=nums.length;
        int max=nums[len-1];
        int [] count= new int[max+1];
        for(int num:nums){
            count[num]++;
        }
        for(int i=1; k*i<max; i++){
            if(count[k*i]==0 && k*i<=max)return i*k;
        }
        return ((max)/k+1)*k;
    }
}