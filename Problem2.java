//Time = O(4^N)
//Space = O(N)

class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        backtrack(res, num, target, "", 0, 0, 0); // call the helper function with initial values
        return res;
    }
    
    private void backtrack(List<String> res, String num, int target, String expr, int start, long eval, long prev) {
        // base case: if we have reached the end of the string
        if (start == num.length()) {
            // if the current expression evaluates to the target value, add it to the result list
            if (eval == target) {
                res.add(expr);
            }
            return; // exit the function
        }
        // generate all possible operands from the current index onwards
        for (int i = start; i < num.length(); i++) {
            // avoid leading zeros
            if (i > start && num.charAt(start) == '0') {
                break;
            }
            // parse the current operand as a long integer
            long curr = Long.parseLong(num.substring(start, i + 1));
            // handle the case of the first number being a single-digit operand without a preceding operator
            if (start == 0) {
                backtrack(res, num, target, expr + curr, i + 1, curr, curr); // no operator before the first operand
            } else {
                // try adding the current operand with a plus sign
                backtrack(res, num, target, expr + "+" + curr, i + 1, eval + curr, curr);
                // try subtracting the current operand with a minus sign
                backtrack(res, num, target, expr + "-" + curr, i + 1, eval - curr, -curr);
                // try multiplying the current operand with the previous operand using a star sign
                backtrack(res, num, target, expr + "*" + curr, i + 1, eval - prev + prev * curr, prev * curr);
            }
        }
    }
}
