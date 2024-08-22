import java.util.HashMap;


 public class gridtraveller {

		public static void main(String args[]){
			
			HashMap<String,Intger> newMap = new HashMap<>();

			newMap.put(""+1+1+"",1);

			System.out.println(twogrid(4,4,newMap));	
		}

		public static int twogrid(int m,int n,HashMap<String,Integer> newMap){
			if(n == 0 || m == 0) return 0;

			if(n == 1 && m == 1 ) return 1;

			return twogrid(m-1,n) + twogrid(m,n-1);
		}

}

