class Solution {
    public int rob(int[] nums) {

        if(nums.length == 1){
            return nums[0];
        }

        if(nums.length == 0 || nums == null){
            return 0;
        }


        int[] firstArray = new int[nums.length-1];
        int[] lastArray = new int[nums.length-1];

        for(int i=1,j = 0;i<nums.length;i++,j++){
            firstArray[j] = nums[i];
        }

         for(int i=0,j=0;i<nums.length-1;i++,j++){
            lastArray[j] = nums[i];
        }

        int first = helper(firstArray);
	int last = helper(lastArray);

        return Math.max(first,last);


    }

    public int helper(int[] nums){
	if(nums.length == 0 || nums == null){
		return 0;
	}

	if(nums.length == 1){
		return nums[0];
	}
	

	int[] dp = new int[nums.length];

	dp[0] = nums[0];
	dp[1] = Math.max(nums[0],nums[1]);

	for(int i = 2;i<nums.length;i++){
		dp[i] = Math.max(dp[i-1],nums[i] + dp[i-2]);
	}

	return dp[nums.length-1];



    } 
}

