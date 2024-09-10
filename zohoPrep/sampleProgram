public class sampleProgram{

	public static void main(String args[]){
		String newString = "geeksforgeeks";
		callFunction(newString);
	}

	public static void callFunction(String str){
		char[][] matrix = new char[str.length()][str.length()];
		
		

		for(int i=0;i<str.length();i++){
			for(int j =0;j<str.length();j++){
				matrix[i][j] = ' ';
			}
		}



		for(int i=0;i<str.length();i++){
			matrix[i][i] = str.charAt(i);
			matrix[str.length()-1-i][i] = str.charAt(i);
		}

	
		for(int i=0;i<str.length();i++){
			for(int j =0;j<str.length();j++){
					System.out.print(matrix[i][j]);
			}

			System.out.println();
		}
		

		System.out.println();
	}



}
