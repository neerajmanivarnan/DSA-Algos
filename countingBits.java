class countingBits {

	public static void main(String args[]){
		System.out.println("break main");
		int[] result = countBits(5);
		for(int i=0;i<result.length;i++){
			System.out.println(result[i]);
		}
	}

    public static int[] countBits(int n) {
        System.out.println("break count bits");
	int[] ans = new int[n+1];

        for(int i=0;i<n;i++){
            ans[i] = count(i);
        }

        return ans;

    }

    static int count(int num){
	System.out.println("break count");
        int realCount=0;
        int org = num;
        String result = "";
        int newNum;

        while(org>0){
            newNum = org%2;
            result = result+newNum+"";
            org = org/2;
        }
	
	System.out.println("break count while");
	
        for(int i=0;i<result.length();i++){
            if(result.charAt(i) == '1'){
                realCount +=1;
            }
        }

        return realCount;
    }
}
