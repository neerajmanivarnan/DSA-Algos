class CustomStack {
	int[] stack;
	int[] inc;
	int top;

	public CustomStack(int maxSize) {
		stack = new int[maxSize];
		inc = new int[maxSize];
		top = -1;
	}

	public void push(int x) {
		if (top + 1 < stack.length) {
			top++;
			stack[top] = x;
		}
	}

	public int pop() {
		if (top == -1) {
			return -1;
		}
		int result = stack[top] + inc[top];
		if (top > 0) {
			inc[top - 1] += inc[top];
		}
		inc[top] = 0;
		top--;
		return result;
	}

	public void increment(int k, int val) {
		int limit = Math.min(k - 1, top);
		if (limit >= 0) {
			inc[limit] += val;
		}
	}
}
