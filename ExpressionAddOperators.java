import java.util.ArrayList;
import java.util.List;
/**
 * Time Complexity: O(4^n), for each step there are 3 choices and one no-op
 * Space Complexity: O(n)
 * Did this code successfully run on Leetcode: Yes
 * Any problem you faced while coding this: None

 * Approach:
 * 1. Recursively explore all possible ways to insert +, -, or * operators between numbers to evaluate expressions.
 * 2. If the current index reaches the end of the string and the computed value
 *  (calc) equals the target, add the expression to the result list.
 * 3. Since leading zeros like 005, 08 etc forms invalid number, need to skip such numbers
 * 4.
 *  + : Update calc by adding current value and update tail to track last added value.
 *  - : Subtract current value and update tail as negative.
 *  * : Revert the last operation (calc - tail) and multiply the last value (tail) with the current value.
 * 5. Use StringBuilder and revert path changes after each recursive call (path.setLength())
 */
 public class ExpressionAddOperators {
     List<String> result;
 
     public List<String> addOperators(String num, int target) {
         if (num == null || num.length() == 0) return new ArrayList<>();
         result = new ArrayList<>();
         recurse(num, target, 0, 0, 0, new StringBuilder());
         return result;
     }
 
     private void recurse(String num, int target, int index, long calc, long tail, StringBuilder path) {
         // Base Case
         if (index == num.length()) {
             if (calc == target) {
                 result.add(path.toString());
             }
             return;
         }
 
         // Logic
         for (int i = index; i < num.length(); i++) {
             // Skip leading zero numbers
             if (num.charAt(index) == '0' && index != i) break;
 
             // Parse the current number
             long curr = Long.parseLong(num.substring(index, i + 1));
             int pathLength = path.length();
 
             if (index == 0) { // First number, no operator needed
                 path.append(curr);
                 recurse(num, target, i + 1, curr, curr, path);
                 path.setLength(pathLength); // Backtrack
             } else {
                 // + operator
                 path.append("+").append(curr);
                 recurse(num, target, i + 1, calc + curr, curr, path);
                 path.setLength(pathLength);
 
                 // - operator
                 path.append("-").append(curr);
                 recurse(num, target, i + 1, calc - curr, -curr, path);
                 path.setLength(pathLength);
 
                 // * operator
                 path.append("*").append(curr);
                 recurse(num, target, i + 1, calc - tail + tail * curr, tail * curr, path);
                 path.setLength(pathLength);
             }
         }
     }
 
     public static void main(String[] args) {
         ExpressionAddOperators obj = new ExpressionAddOperators();
         List<String> result = obj.addOperators("1456", 4);
         System.out.println(result);
     }
 }
 