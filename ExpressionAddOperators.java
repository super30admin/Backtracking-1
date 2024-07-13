// Time Complexity : Exponential
// Space Complexity : O(n) where n is the length of num string
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Yes. Forgot to handle Note that operands in the returned expressions should not contain leading zeros.

/*
Approach: Used recursive approach by passing tail, calc, index & path to the recusrive function. Started iterating the for loop over index. Calculated curr value by using substring(index, i+1). Then ran recurse loop for +, -, * operators
 */
class Solution {
    List<String> result;

    public List<String> addOperators(String num, int target) {

        if (num == null || num.length() == 0) {
            return new ArrayList<>();
        }

        result = new ArrayList<>();

        recurse(num, target, 0, 0, 0, "");

        return result;
    }

    private void recurse(String num, int target, int index, long calc, long tail, String path) {

        // base
        if (index == num.length()) {
            if (calc == target) {
                result.add(path);
            }
        }

        // logic
        for (int i = index; i < num.length(); i++) {

            //To handle leading zeros
            if(num.charAt(index) == '0' && index != i){
                continue;
            }
            long curr = Long.parseLong(num.substring(index, i + 1));
            if (index == 0) {
                recurse(num, target, i + 1, curr, curr, path + curr);
            } else {

                //+ operator
                recurse(num, target, i + 1, calc + curr, +curr, path + "+" + curr);

                //- operator
                recurse(num, target, i + 1, calc - curr, -curr, path + "-" + curr);

                //* operator
                recurse(num, target, i + 1, calc - tail + tail * curr, tail * curr, path + "*" + curr);
            }
        }
    }
}