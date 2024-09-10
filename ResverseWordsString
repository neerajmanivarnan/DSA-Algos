import java.util.StringTokenizer;
class Solution {
    public String reverseWords(String s) {
        StringTokenizer tokeniser = new StringTokenizer(s);
        String[] array = new String[tokeniser.countTokens()];
        int j=0;
        while(tokeniser.hasMoreTokens()){
            array[j] = tokeniser.nextToken();
            j+=1;
        }
        String output ="";

        int left,right;
        left = 0;
        right = array.length-1;
        while(left<right){
            output = array[left];
            array[left] = array[right];
            array[right] = output; 
            left = left+1;
            right = right-1;
            output="";
        }
        String result="";
        int i =0;
        for(String str:array){
            if(i == array.length-1){
                result +=str;
                break;
            }

            result +=str+" ";
            i+=1;
        }
        


        return result;
    }
}
