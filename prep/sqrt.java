public class sqrt{


	public static void main(String args[]){
		int num = Integer.parseInt(args[0]);
		System.out.println(sqrt(num));
	}	


	public static int sqrt(int num){
		int start =0;
		int end = num;
		int mid;

		while(start<end){
			mid = (start+end)/2;
			System.out.println(mid);
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
