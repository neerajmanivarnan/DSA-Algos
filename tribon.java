 public class tribon {

		public static void main(String args[]){

		}


		public int trib(int n){
			if(n == 1 || n == 0 ){
				return n; 
			}else{
				return trib(n-1) + trib(n-2) + trib(n-3);
			}

		}

}

