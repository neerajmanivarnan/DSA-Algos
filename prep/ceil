public class ceil{

	public static void main(String args[]){
		int arr[] = {12,13,14,16,17,19};
		System.out.println(cl(arr,15));

	}
	
	public static int cl(int[] arr,int target){
		int start = 0;
		int end = arr.length-1;
		int mid=-1;
		int largest;

		while(start<=end){
			mid  = (start+end)/2;
			largest = arr[mid];
			if(target > arr[mid]){
				start = mid+1;
			}else if(arr[mid] >= target ){
				end = mid-1;
			}
		}

		return arr[start];
	}


}
