class Solution {
    public int hammingWeight(int n) {
        return count(n);
    }

    

    static int count(int num){
	
        int realCount=0;
        int org = num;
        String result = "";
        int newNum;

        while(org>0){
            newNum = org%2;
            result = result+newNum+"";
            org = org/2;
        }
	
	
	
        for(int i=0;i<result.length();i++){
            if(result.charAt(i) == '1'){
                realCount +=1;
            }
        }

        return realCount;
    }

}
