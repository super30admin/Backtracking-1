// Time Complexity : O(4^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None

class Solution {
    List<String> result;
    public List<String> addOperators(String num, int target) {
        this.result = new ArrayList<>();

        helper(num, target, 0, 0, 0, 0, new StringBuilder());

        return result;
    }

    private void helper(String num, int target, int i, long curr, long calc, long tail, StringBuilder path) {

        if(i == num.length()) {
            if(calc == target && curr == 0) {
                result.add(path.toString());
            }
            return;
        }

        curr = curr * 10 + num.charAt(i) - '0';

        if(curr > 0) {
            helper(num, target, i + 1, curr, calc, tail, path);
        }

        int le = path.length();

        if(path.length() == 0) {
            path.append(curr);
            helper(num, target, i + 1, 0, curr, curr, path);
            path.setLength(le);
        } else {
            path.append("+").append(curr);
            helper(num, target, i + 1, 0, calc + curr, curr, path);
            path.setLength(le);

            path.append("-").append(curr);
            helper(num, target, i + 1, 0, calc - curr, -curr, path);
            path.setLength(le);

            path.append("*").append(curr);
            helper(num, target, i + 1, 0, calc - tail + (tail * curr), tail * curr, path);
            path.setLength(le);
        }
    }
}
