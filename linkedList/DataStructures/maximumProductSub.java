class Solution {
    public int maxProduct(int[] nums){
	
	int max_prod = nums[0];
	int min_prod = nums[0];
	int global = nums[0];

	int temp;

	for(int i=1;i<nums.length;i++){
		if(nums[i]<0){
			temp = max_prod;
			max_prod = min_prod;
			min_prod = temp;	
		}

		max_prod = Math.max(nums[i],max_prod*nums[i]);
		min_prod = Math.min(nums[i],min_prod*nums[i]);

		global = Math.max(global,max_prod);
		
	}    	

	return global;
    
    }
}
