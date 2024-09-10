public class bsearch{

	public static void main(String args[]){
		int[] arr = {1,2,3,4,5,6,7,8,9,10};

		System.out.println(search(arr,3));
	}


	public static int search(int[] arr,int target){
		int start = 0;
		int last = arr.length-1;
		int mid; 

		while(start < last){
			mid = (start+last)/2;
			if(arr[mid] == target){
				return mid;	
			}else{
				if(target > mid ){
					start = mid+1;
				}else{
					last = mid - 1;
				}

			}

		}

		return -1;
	}



}
