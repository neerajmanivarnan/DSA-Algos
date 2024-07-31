public class isSub{

	public static void main(String args[]){
		String s = "GeeksForGeeks";
		String t = "For";
		System.out.println(call(s,t));
	}

	public static int  call(String s,String t){
		int flag = 0;	
		int index = -1;
		for(int i=0;i<s.length();i++){
			int l = i;
			if(s.charAt(i) == t.charAt(0)){
				int j =0;
				while(j<t.length() && l<s.length()){
			
					if(t.charAt(j) == s.charAt(l)){

						j+=1;
						l+=1;
						flag = 1;

					}else{
						 flag = 0;
						 break;
					}
				}

				if(flag == 1){
					index = i;
					return index;
				}

			}
		}

		return index;

	}



}
