 public class bit {

		public static void main(String args[]){
			System.out.println(getBit(5,3));	
		}

		static boolean getBit(int num,int i){
			return ((num & (1 << i)) != 0) ;
		}
}

