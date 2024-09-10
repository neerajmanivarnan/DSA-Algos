import java.util.*;


public class lis {
				
		public static void main(String args[]){
			int num = 1;

			ArrayList<Integer> lis = new ArrayList<>();
			lis.add(2);
			lis.add(3);

			int pos = Collections.binarySearch(lis,num);

			System.out.println(pos);
		}

		


}
