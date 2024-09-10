public class floor{

	public static void main(String args[]){
		int arr[] = {13,15,17,19,20,21};
		System.out.println(floor(arr,18));
	}

	public static int floor(int[] arr,int target){
		
		int start = 0;
		int end = arr.length-1;
		int mid;

		while(start<=end){
			mid = (start+end)/2;
			if(arr[mid] == target){
				return arr[mid];
			}else if(arr[mid] < target){
				start = mid +1;
			}else if(arr[mid] > target){
				end = mid-1;
			}

		}

		return arr[end];

	}



}
