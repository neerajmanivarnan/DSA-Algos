import java.util.Stack;
import java.util.HashMap;

class Solution {
    public boolean isValid(String s) {
        HashMap<Character,Character> newMap = new HashMap<>();
        Stack<Character> newStack = new Stack<>();

    
        newMap.put(')','(');
        newMap.put('}','{');
        newMap.put(']','[');

        for(char c : s.toCharArray()){ 
            if(newMap.containsKey(c)){ 
                if( newStack.isEmpty() || newStack.peek() != newMap.get(c)){
                    return false;
                }else{
                    newStack.pop(); 
                }
            }else{ 
                newStack.push(c);
            }
        }
        return newStack.size() == 0;
    }
}
