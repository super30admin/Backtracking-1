import java.util.*;

// Iterative recursion O(4^n) time, O(n) space
class Solution {
    List<String> ans;
    public List<String> addOperators(String num, int target) {
        //      calc                                tail
        // +    calc + curr                         + curr
        // -    calc - curr                         - curr
        // *    (calc - tail) + (tail * curr)       tail * curr

        ans = new ArrayList<>();
        helper(num, target, 0, new StringBuilder(), 0, 0);
        return ans;
    }

    private void helper(String num, int target, int pivot, StringBuilder path, long calc, long tail) {

        if (pivot == num.length()) {
            if (calc == target) {
                ans.add(path.toString());
            }
            return;
        }

        for (int i = pivot; i < num.length(); i++) {

            if (num.charAt(pivot) == '0' && i != pivot) { // dont continue from here since leading zeros
                break;
            }

            long curr = Long.parseLong(num.substring(pivot, i+1)); // generate each string and convert to long

            int len = path.length();

            if (pivot == 0) { // first level, no operators
                
                path.append(curr);
                helper(num, target, i+1, path, curr, curr); // path+curr converts num to string path
                path.setLength(len);
            }
            else {
                // +
                path.append("+").append(curr);
                helper(num, target, i+1, path, calc + curr, curr);
                path.setLength(len);

                // -
                path.append("-").append(curr);
                helper(num, target, i+1, path, calc - curr, -curr);
                path.setLength(len);

                // *
                path.append("*").append(curr);
                helper(num, target, i+1, path, calc - tail + (tail * curr), tail * curr);
                path.setLength(len);
            }
        }
    }
}