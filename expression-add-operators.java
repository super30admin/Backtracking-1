// Time Complexity : O(L * 4 ^ L)
// Space Complexity : O(L)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    // TC = O(L * 4 ^ L); L = length of string num
    // SC = O(L) 
    List<String> result;
    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();
        helper(num, 0, 0, 0, new StringBuilder(), target);
        return result;
    }
    public void helper(String num, int index, long calc, long tail, StringBuilder path, int target) {
        //                           current calc val, prev calc val
        // base
        if(index == num.length()) {
            if(calc == target) result.add(path.toString());
            return;
        }
        // logic
        for(int i = index; i < num.length(); i++) {
            // preceeding zero
            if(i != index && num.charAt(index) == '0') continue; // as 0 is ok but 05 is not
            long curr = Long.parseLong(num.substring(index, i + 1)); //substring() takes 1 extra index
            // this is the case when we add no operator, ie the 1st case no operator
            int le = path.length(); // storing original length for bactracking
            if(index == 0) {
                path.append(curr); // action
                helper(num, i + 1, curr, curr, path, target); // recurse
                path.setLength(le); // // backtrack
            }
            else {
                // +
                path.append('+').append(curr); // action
                helper(num, i + 1, calc + curr, curr, path, target); // recurse
                path.setLength(le); // backtrack
                // -
                path.append('-').append(curr); // action
                helper(num, i + 1, calc - curr, -curr, path, target); // recurse
                path.setLength(le); // backtrack
                // *
                path.append('*').append(curr); // action
                helper(num, i + 1, calc - tail + tail * curr, tail * curr, path, target); // recurse
                path.setLength(le); // backtrack
            }
        }
    }
}