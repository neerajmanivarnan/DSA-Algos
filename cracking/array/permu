public class permu{

	public static void main(String args[]){
		String a = "dog    ";
		String b = "god";
		System.out.println(isPermu(a,b));

	}

	public static boolean isPermu(String a,String b){
		if(a.length() != b.length()) return false;

		return sort(a).equals(sort(b));

	}

	public static String sort(String a){
		char[] arr = a.toCharArray();
		java.util.Arrays.sort(arr);
		return new String(arr);

	}


}
