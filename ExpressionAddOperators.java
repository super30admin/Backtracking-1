// Time Complexity :  O(4 ^ n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/*
The idea is to have a helper method where we recursively check from pivot to string length using n-ary loop.
If at any point, we notice a number having '0' as pivot and i as others then we can ignore them.If pivot and i
are at '0' index, then we normally recurse with the formed substring of pivot and i.If not, we recurse for
additon, difference and product cases by appending the appropriate operator to the existing path and current
number and also updating the calculated, tail values.For product, we need to revert the any prior computations
made, so we use tail for that and first compute the product of tail with current and then original value gets
added.This is a way to follow BODMAS rule.At any time, if pivot reaches out of bounds and met target, we add to
the result.
 */
class Solution {
    List<String> result;
    public List<String> addOperators(String num, int target) {
        this.result = new ArrayList<>();
        helper(num, target, "", 0, 0, 0);
        return result;
    }

    private void helper(String num, int target, String path, int pivot, long calc, long tail) {
        if(pivot == num.length()) {
            if(calc == target)
                result.add(path);
        }

        for(int i = pivot ; i < num.length() ; i++) {
            if(num.charAt(pivot) == '0' && i != pivot)
                break;
            long curr = Long.parseLong(num.substring(pivot, i + 1));
            if(pivot == 0) {
                helper(num, target, path + curr, i + 1, curr, curr);
            }
            else {
                // +
                helper(num, target, path + '+' + curr, i + 1, calc + curr, curr);

                //-
                helper(num, target, path + '-' + curr, i + 1, calc - curr, -curr);

                //*
                helper(num, target, path + '*' + curr, i + 1, calc - tail + (tail * curr), tail * curr);
            }
        }
    }
}