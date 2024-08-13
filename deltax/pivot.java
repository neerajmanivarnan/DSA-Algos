public class pivot{

	public static void main(String args[]){
		int[] arr = {1,7,3,6,5,6};

		int sum = 0;

		for(int num:arr){
			sum+=num;
		}

		int leftSum = 0;

		for(int i=0;i<arr.length;i++){
			if(leftSum == sum -leftSum - arr[i]){
				System.out.println(i);
			}
			leftSum+=arr[i];
		}


	}


}
