import java.util.LinkedList;
import java.util.Iterator;

 public class colllinked {

		public static void main(String args[]){
			LinkedList<String> names = new LinkedList<String>();
			names.add("Neeraj");
			names.addFirst("Manivarnan");
			
			Iterator<String> itr = names.iterator();
			while(itr.hasNext()){
				System.out.println(itr.next());
			}

		}

}

