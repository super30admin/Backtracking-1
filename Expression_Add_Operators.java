/*

Approach: first of all we try to generate all the possible ways to
insert the operators in between the digits and evaluate the experssion as we go.

we use backtracking --> for loop based recursion

secondly we define recursive call track : 
   pivot --> current index in the string
   calc --> curret calculated value of expression
   tail --> last operand for handling precedence
   path --> current expression being build

base case is :
     --> if pivot == num.length():

     --> if calc == target → valid expression, add to result

     --> else discard

then we generate the current number

*/

/*
Time: O(4^n)

Space Complexity: O(n) auxiliary, O(4^n) including result
 */


class Solution {
    List<String> result;

    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();
        helper(num, target, 0, 0, 0, new StringBuilder());
        return result;
    }

    private void helper(String num, int target, int pivot, long calc, long tail, StringBuilder path) {
        if (pivot == num.length()) {
            if (calc == target) {
                result.add(path.toString());
            }
            return;
        }

        for (int i = pivot; i < num.length(); i++) {
            // Skip numbers with leading zero except the single digit zero itself
            if (i != pivot && num.charAt(pivot) == '0') break;

            long curr = Long.parseLong(num.substring(pivot, i + 1));

            int le = path.length();

            if (pivot == 0) {
                path.append(curr);
                // First number, pick it without any operator
                helper(num, target, i + 1, curr, curr, path);
                path.setLength(le);
            } else {
                path.append("+").append(curr);
                // Addition
                helper(num, target, i + 1, calc + curr, curr, path);
                path.setLength(le);
                // Subtraction
                path.append("-").append(curr);
                helper(num, target, i + 1, calc - curr, -curr, path);
                path.setLength(le);
                // Multiplication
                path.append("*").append(curr);
                helper(num, target, i + 1, calc - tail + tail * curr, tail * curr, path);
                path.setLength(le);
            }
        }
    }
}