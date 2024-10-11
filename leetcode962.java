public class leetcode962 {
    public int maxWidthRamp(int[] A) {
        Stack<Integer> stack = new Stack<>();

        
        for (int i = 0; i < A.length; i++) {
            if (stack.isEmpty() || A[stack.peek()] > A[i]) {
                stack.push(i);
            }
        }

        int maxWidth = 0;

        
        for (int j = A.length - 1; j >= 0; j--) {
            while (!stack.isEmpty() && A[j] >= A[stack.peek()]) {
                int i = stack.pop();
                maxWidth = Math.max(maxWidth, j - i);
            }
        }

        return maxWidth;
    }

}
