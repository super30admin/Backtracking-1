
// Time Complexity : O(2^n+m)
// Space Complexity : Recursion stack space
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :no


// Your code here along with comments explaining your approach
// this is similar to the coin change problem
// we need to find the combinations of the numbers which adds up to the target 
// no need of permutations, only the combinations and add to the res and return it
// we can do normal deep copy, for loop, backtrack anything.
import java.util.*;

class Solution {

    List<List<Integer>> res;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        res = new ArrayList<>();

        helper(candidates, target, new ArrayList<>(), 0);

        return res;
    }

    private void helper(int[] candidates,
                        int target,
                        List<Integer> path,
                        int indx) {

        if (target < 0 || indx == candidates.length) {
            return;
        }

        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        // Skip current number
        helper(candidates, target, path, indx + 1);

        // Take current number
        path.add(candidates[indx]);

        helper(candidates,
               target - candidates[indx],
               path,
               indx);

        // Backtrack
        path.remove(path.size() - 1);
    }
}