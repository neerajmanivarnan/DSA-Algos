public class isUnique{

	public static void main(String args[]){
		String newchar = "Neraj";
		System.out.println(check(newchar));

	}

	public static boolean check(String word){
		if(word.length() > 128 ) return false;

		boolean[] char_set = new boolean[128];

		for(int i=0;i<word.length();i++){
			int val = word.charAt(i);
			if(char_set[val]) return false;
			char_set[val] = true;
		}

		return true;
	}




}
