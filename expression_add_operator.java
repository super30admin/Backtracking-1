// Time Complexity : O(4^n) cos 4 operations - noop, +, -, *
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
// We use backtracking to try every possible number split and insert '+', '-', or '*' between numbers.
// The tail variable stores the previous operand so multiplication precedence can be handled by removing tail and adding tail * curr.
// We skip numbers with leading zeros and backtrack the StringBuilder after each recursive call to explore other expressions.

class Solution {
    List<String> result;
    public List<String> addOperators(String num, int target) {
        this.result = new ArrayList<>();
        helper(num, target, 0, 0l, 0l, new StringBuilder());
        return result;
        
    }

    private void helper(String num, int target, int pivot, long calculated_value, long tail, StringBuilder path) {
        // Base case
        if (pivot == num.length()) {
            if (calculated_value == target) {
                result.add(path.toString());
            }
            return;
        }

        // Logic
        for (int i = pivot; i < num.length(); i++) {
            Long curr = Long.parseLong(num.substring(pivot, i+1));

            // Preceding zero
            if(num.charAt(pivot) == '0' && pivot!=i) {
                continue;
            }

            int le = path.length();
            // Top level
            if (pivot == 0) {
                // action
                path.append(curr);
                // recurse
                helper(num, target, i+1, curr, curr, path);
                //backtrack
                path.setLength(le);
            } else {
                // +
                // action
                path.append("+");
                path.append(curr);
                // recurse
                helper(num, target, i+1, calculated_value+curr, curr, path);
                //backtrack
                path.setLength(le);

                // -
                // action
                path.append("-");
                path.append(curr);
                // recurse
                helper(num, target, i+1, calculated_value-curr, -curr, path);
                //backtrack
                path.setLength(le);

                // *
                // action
                path.append("*");
                path.append(curr);
                // recurse
                helper(num, target, i+1, calculated_value-tail + curr*tail, curr*tail, path);
                //backtrack
                path.setLength(le);
            }
        }
        

    }
}