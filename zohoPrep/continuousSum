public class continuousSum{

	public static void main(String args[]){
		int[] arr = {0,5,6,0,9,0,1,4};
		System.out.println(findSum(arr));
	}


	static int findSum(int[] arr){
		int currentSum;
		int LargestSum = 0;
		for(int i=0;i<arr.length-1;i++){
			currentSum = arr[i] + arr[i+1];
			if(currentSum > LargestSum){
				LargestSum = currentSum;
			}
		}

		return LargestSum;
	}



}
