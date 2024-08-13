public class sqrt{


	public static void main(String args[]){
		System.out.println(sqrt(100));
	}	


	public static int sqrt(int num){
		int start =0;
		int end = num;
		int mid;

		while(start<end){
			mid = (start+end)/2;

			if(mid*mid == num){
				return mid;
			}else if(mid*mid >num){
				end = mid;
			}else{
				start = mid;
			}
		}

		return 0;
	}



}
