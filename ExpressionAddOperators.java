import java.util.*;

// Time Complexity : O(3^n) where n is the length of the input string
// Space Complexity :O(n) for the recursion stack and the result list
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

public class ExpressionAddOperators {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        if (num == null || num.length() == 0)
            return result;

        dfs(num, target, 0, 0, 0, "", result);
        return result;
    }

    private void dfs(String num, int target, int index, long currentValue, long previousValue, String expression,
            List<String> result) {
        // when we reach the end of the string
        if (index == num.length()) {
            if (currentValue == target) {
                result.add(expression);
            }
            return;
        }

        for (int i = index; i < num.length(); i++) {
            // Skip numbers with leading zeros
            if (i > index && num.charAt(index) == '0')
                break;

            // Extract the current number segment
            String currentSegment = num.substring(index, i + 1);
            long currentNumber = Long.parseLong(currentSegment);

            if (index == 0) {
                // First number in the expression (no operator needed)
                dfs(num, target, i + 1, currentNumber, currentNumber, currentSegment, result);
            } else {
                // Add '+'
                dfs(num, target, i + 1, currentValue + currentNumber, currentNumber, expression + "+" + currentSegment,
                        result);

                // Add '-'
                dfs(num, target, i + 1, currentValue - currentNumber, -currentNumber, expression + "-" + currentSegment,
                        result);

                // Add '*'
                dfs(num, target, i + 1, currentValue - previousValue + previousValue * currentNumber,
                        previousValue * currentNumber, expression + "*" + currentSegment, result);
            }
        }
    }
}
