import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DifferentWaysToAddParentheses {

    private Map<String, List<Integer>> memo = new HashMap<>();

    public List<Integer> diffWaysToCompute(String expression) {
        if (memo.containsKey(expression)) {
            return memo.get(expression);
        }

        List<Integer> results = new ArrayList<>();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                String left = expression.substring(0, i);
                String right = expression.substring(i + 1);

                List<Integer> leftResults = diffWaysToCompute(left);
                List<Integer> rightResults = diffWaysToCompute(right);

                for (int leftResult : leftResults) {
                    for (int rightResult : rightResults) {
                        int result = 0;
                        switch (c) {
                            case '+':
                                result = leftResult + rightResult;
                                break;
                            case '-':
                                result = leftResult - rightResult;
                                break;
                            case '*':
                                result = leftResult * rightResult;
                                break;
                        }
                        results.add(result);
                    }
                }
            }
        }

        if (results.isEmpty()) {
            results.add(Integer.parseInt(expression));
        }

        memo.put(expression, results);
        return results;
    }

}

