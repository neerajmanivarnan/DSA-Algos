class Solution {
    public int longestSubarray(int[] nums) {
        int maxVal = nums[0];
        for(int num:nums){
            if(num>maxVal){
                maxVal = num;
            }
        }

        int currentLength = 0;
        int maxLength = 0;
        
        for(int num:nums){
            if(num == maxVal){
                currentLength++;
                maxLength = (currentLength>maxLength)?currentLength:maxLength;
            }else{
                currentLength = 0;
            }
        }

        return maxLength;

    }
}
