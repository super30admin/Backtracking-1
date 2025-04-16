// Time complexity:- O(4^n), where n is the length of the input string.
// Space complexity:- O(n), due to recursion stack and StringBuilder used in backtracking.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach 
/**
 * This problem is about inserting '+', '-', and '*' operators between the digits of a numeric string
 * to form valid mathematical expressions that evaluate to a given target value.
 * I used backtracking to explore all possible combinations by maintaining the current calculated value,
 * the last operand (to handle multiplication precedence), and the expression built so far.
 * To avoid invalid numbers with leading zeros, I added a condition to break when a number starts with '0' and is more than one digit. 
 */
class Solution {
    List<String> result;
    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();

        helper(num, target, new StringBuilder(), 0, 0, 0);

        return result;
    }
 private void helper(String num, int target, StringBuilder sb, long calc, long tail, int index){

        // Base case: if we have reached the end of the string
        if(index == num.length()){
            // If the expression evaluates to the target, add to result
            if(calc == target){

                result.add(sb.toString());

                return;

            }
        }
        // Logic: Explore all possible splits of the remaining string
       for(int i = index; i < num.length(); i++){
           // Skip numbers with leading zeros (e.g., "05")
           if(index != i && num.charAt(index) == '0') break;
            // Extract the current number from substring
           long curr = Long.parseLong(num.substring(index, i + 1));
           // Save current expression length for backtracking
           int len = sb.toString().length();

           // First number (no operator needed)
           if(index == 0){
               sb.append(curr); //action
               helper(num, target, sb ,curr, curr, i + 1); 
               sb.setLength(len); // backtrack
           } else {
               // Addition
               sb.append("+");//action

               sb.append(curr);//action

               helper(num, target, sb, calc + curr, curr, i + 1); // recurse

               sb.setLength(len);// backtrack

               // Subtraction
               sb.append("-");//action

               sb.append(curr);//action

               helper(num, target, sb, calc - curr, -curr, i + 1); // // recurse

               sb.setLength(len);// backtrack

               // Multiplication
               sb.append("*");

               sb.append(curr);

               helper(num, target, sb, calc - tail + tail*curr, tail*curr, i + 1); // recurse

               sb.setLength(len);// backtrack

           }

       }

    }

}
