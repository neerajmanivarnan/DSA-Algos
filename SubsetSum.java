class SubsetSum {

  public static void main(String args[]){
   int[] arr = {3,34,4,12,5,2}; 
    System.out.println(findtrue(arr,9,0));
  }

  public static  boolean findtrue(int[] nums,int target,int index){

    if(target == 0) return true;  

    if(index >= nums.length   || target < 0 ) {
          return false;
    
    }

     return findtrue(nums,target-nums[index],index + 1) || findtrue(nums,target,index + 1);
    



  }


}
