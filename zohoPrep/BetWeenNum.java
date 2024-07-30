public class BetWeenNum{

	public static void main(String args[]){
		int[] arr = {4,3,7,11,50,1};
		int x = 10;
		int y = 14;
		System.out.println(call(arr,x,y));
	}

	public static int call(int[] arr,int x,int y){
		if(!(x<y)){
			return 0;
		}

		for(int num:arr){
			if(num > x && num <y) return num;
		}

		return 0;
	}



}
