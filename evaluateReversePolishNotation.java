import java.util.stack;

class Solution {
    public int evalRPN(String[] tokens) {
        stack<Integer> stack = new stack<>();
        
        for (String token : tokens) {
            
            if (token.equals("+")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a + b);
            } else if (token.equals("-")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a - b);
            } else if (token.equals("*")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a * b);
            } else if (token.equals("/")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a / b);  
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        
        
        return stack.pop();
    }
}

