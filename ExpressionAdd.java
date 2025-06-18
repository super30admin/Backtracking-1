 // Time complexity - O(n)
 // Space complexity - O(n)
 // DID you solve on leetcode - yes
 // Did you face any issues - no
 // The algorithm uses depth-first search (DFS) with backtracking to explore all ways of inserting +, -, and * operators between digits of the string to form valid arithmetic expressions. At each recursive step, it builds a substring, converts it to a number, and appends it to the current expression along with an operator while maintaining the running total and last operand (to handle multiplication precedence). It adds the expression to the result list only if the entire string is consumed and the evaluated value matches the target.
class Solution {
    List<String> result = new ArrayList<>();

    public List<String> addOperators(String num, int target) {
        helper(num, target, 0, 0, 0, "");
        return result;
    }

    private void helper(String num, int target, int index, long currentValue, long lastOperand, String expression) {
        if (index == num.length()) {
            if (currentValue == target) {
                result.add(expression);
            }
            return;
        }

        for (int i = index; i < num.length(); i++) {
            // Skip numbers with leading zero
           if (i != index && num.charAt(index) == '0') break;

            String currentStr = num.substring(index, i + 1);
            System.out.println(currentStr);
            long currentNum = Long.parseLong(currentStr);

            if (index == 0) {
                // First number, no operator before it
                helper(num, target, i + 1, currentNum, currentNum, currentStr);
            } else {
                helper(num, target, i + 1, currentValue + currentNum, currentNum, expression + "+" + currentStr);
                helper(num, target, i + 1, currentValue - currentNum, -currentNum, expression + "-" + currentStr);
                helper(num, target, i + 1, 
                       currentValue - lastOperand + lastOperand * currentNum, 
                       lastOperand * currentNum, 
                       expression + "*" + currentStr);
            }
        }
    }
}
