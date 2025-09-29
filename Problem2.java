// Time Complexity : 4 ^ n where n is the length of nums string
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

/**
 * We create possible strings with pivot based recursion. At each level, we apply the operators and generate the current number which will be used by next level.
 * When we reach the end of the num string, we check if the target value matches the current value and add it to the result.
 */
class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        helper(num, target, 0, 0l, 0l, new StringBuilder(), result);
        return result;
    }

    private void helper(String num, int target, int pivot, long calc, long tail, StringBuilder path, List<String> result) {
        //if all numbers are taken into consideration
        if (pivot == num.length()) {
            if (calc == target) {
                result.add(path.toString());
            }
            return;
        }

        for (int i = pivot; i < num.length(); i++) {
            // leading 0 needs to be ignored
            if (num.charAt(pivot) == '0' && i != pivot)
                return;
            long curr = Long.parseLong(num.substring(pivot, i + 1));
            int le = path.length();
            // first level so the current and tail are the number itself
            if (pivot == 0) {
                path.append(curr);
                helper(num, target, i + 1, curr, curr, path, result);
                path.setLength(le);
            } else {

                // Adding to path, recurse and backtrack for all 3 actions
                // +
                path.append("+");
                path.append(curr);
                helper(num, target, i + 1, calc + curr, curr, path, result);
                path.setLength(le);

                // -
                path.append("-");
                path.append(curr);
                helper(num, target, i + 1, calc - curr, -curr, path, result);
                path.setLength(le);

                // *
                path.append("*");
                path.append(curr);
                helper(num, target, i + 1, calc - tail + tail * curr, tail * curr, path, result);
                path.setLength(le);
            }

        }
    }
}