 public class demo {

	 	int x;

		demo(int x){
			m1(x);
		}

		public void m1(int x){
			this.x = 3*x;
		}

		public static void main(String args[]){
			demo d = new demo(3);
			System.out.println(d.x);
		}

}

