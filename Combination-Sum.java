// Time Complexity :  O(2 ^(m + n)) where m is candidates length and n is target
// Space Complexity : O(m + n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/*
We see multiple combinations of identifying target, so we need to solve using exhaustive/recursive approach.
However, to optimize, we can include backtracking. We use a for loop based recursive approach to handle choose
and no choose cases for each candidate and keep on adding the candidates to th path intially and then recurse
further for that candidate until if the target is not 0 or becomes negative. If so, we can backtrack to find
other combinations in a similar way. Whenever target becomes 0, we need to append the path to our result.
 */
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.result = new ArrayList<>();
        helper(candidates, target, 0, new ArrayList<>());
        return result;
    }

    private void helper(int[] candidates, int target, int pivot, List<Integer> path) {
        if(target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        if(target < 0)
            return;

        for(int i = pivot ; i < candidates.length ; i++) {
            //action
            path.add(candidates[i]);
            //recurse
            helper(candidates, target - candidates[i], i, path);
            //backtrack
            path.remove(path.size() - 1);
        }

    }
}