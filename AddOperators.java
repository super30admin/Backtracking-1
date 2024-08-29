// Problem 282. Expression Add Operators
// Time Complexity : O(3^n)
// Space Complexity : O(3^n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
class AddOperators {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        if (num == null || num.length() == 0){
            return res;
        }
        backtrack(res, num, target, 0, 0, 0, "");
        return res;
    }

    private void backtrack(List<String> res, String num, int tgt, int idx, long curVal, long lastVal, String expr) {
        if (idx == num.length()) {
            if (curVal == tgt){
                res.add(expr);
            }
            return;
        }
        for (int i = idx; i < num.length(); i++) {
            // Skip leading zeros
            if (i != idx && num.charAt(idx) == '0'){
                break;
            }
            String curStr = num.substring(idx, i + 1);
            long curNum = Long.parseLong(curStr);

            if (idx == 0) {
                backtrack(res, num, tgt, i + 1, curNum, curNum, curStr);
            } else {
                backtrack(res, num, tgt, i + 1, curVal + curNum, curNum, expr + "+" + curStr);
                backtrack(res, num, tgt, i + 1, curVal - curNum, -curNum, expr + "-" + curStr);
                backtrack(res, num, tgt, i + 1, curVal - lastVal + lastVal * curNum, lastVal * curNum, expr + "*" + curStr);
            }
        }
    }
}
