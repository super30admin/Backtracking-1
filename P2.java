/*
Time Complexity - O(4ⁿ) (Since each digit allows up to 3 operations (+, -, *), leading to an exponential growth)
Space Complexity - O(N) (Recursion depth in worst case)

This solution recursively generates all possible expressions by inserting +, -, and * between digits while maintaining correct evaluation.
It avoids leading zeros and ensures multiplication follows the correct precedence by adjusting the eval value accordingly.
The final result contains all valid expressions that evaluate to the target value.
 */

 public class P2 {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        
        // If input number is empty, return an empty list
        if (num == null || num.length() == 0) return result;
        
        // Start recursive backtracking function
        helper(result, "", num, target, 0, 0, 0);
        
        return result;
    }

    public void helper(List<String> result, String path, String num, int target, int pos, long eval, long multed) {
        
        // Base case: If we have processed the entire number
        if (pos == num.length()) {
            // If the current evaluated expression equals the target, add to result
            if (eval == target) {
                result.add(path);
            }
            return;
        }

        // Loop to extract different segments of the number
        for (int i = pos; i < num.length(); i++) {
            
            // Prevent numbers with leading zero (e.g., "05" is invalid, but "0" alone is fine)
            if (i != pos && num.charAt(pos) == '0') break;
            
            // Convert the current substring to a number
            long cur = Long.parseLong(num.substring(pos, i + 1));

            // If at the first number, we don't need an operator before it
            if (pos == 0) {
                helper(result, path + cur, num, target, i + 1, cur, cur);
            } else {
                // Try adding "+"
                helper(result, path + "+" + cur, num, target, i + 1, eval + cur, cur);
                
                // Try adding "-"
                helper(result, path + "-" + cur, num, target, i + 1, eval - cur, -cur);
                
                // Try adding "*"
                // Corrects multiplication precedence by modifying eval
                helper(result, path + "*" + cur, num, target, i + 1, eval - multed + multed * cur, multed * cur);
            }
        }
    }
}