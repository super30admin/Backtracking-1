// https://leetcode.com/problems/expression-add-operators/
// Time Complexity : O(4^n) where n is the length of the input string num. 
//                  This is because for each digit, we have 4 choices: add an operator (+, -, *, or no operator).
// Space Complexity : O(n) where n is the length of the input string num.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        helper(num, 0, 0l, 0l, new StringBuilder(), target, result);
        return result;
    }

    private void helper(String num, int pivot, long calc, long tail, StringBuilder path, int target,
            List<String> result) {
        //base
        if (pivot == num.length()) {
            if (calc == target) {
                result.add(path.toString());
            }
            return;
        }
        //logic
        for (int i = pivot; i < num.length(); i++) {
            long curr = Long.parseLong(num.substring(pivot, i + 1));
            if (num.charAt(pivot) == '0' && pivot != i) {
                continue;
            }
            int le = path.length();
            if (pivot == 0) {
                //top level
                // 1 12 123
                // action
                path.append(curr);
                // recurse
                helper(num, i + 1, curr, curr, path, target, result);
                // backtrack
                path.setLength(le);
            } else {
                // +
                // action
                path.append("+");
                path.append(curr);
                // recurse
                helper(num, i + 1, calc + curr, curr, path, target, result);
                // backtrack
                path.setLength(le);

                // -
                // action
                path.append("-");
                path.append(curr);
                // recurse
                helper(num, i + 1, calc - curr, -curr, path, target, result);
                // backtrack
                path.setLength(le);

                // *
                // action
                path.append("*");
                path.append(curr);
                // recurse
                helper(num, i + 1, calc - tail + tail * curr, tail * curr, path, target, result);
                // backtrack
                path.setLength(le);
            }
        }
    }
}