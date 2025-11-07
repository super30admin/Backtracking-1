// Time Complexity : O(2^mn)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :yes

/*
 * Approach
 * here are we using recursion to solve the problem,
 * basically at each step we have to choose between pick or not pick a number
 * for this we are using recurion
 * 
 * we are going to use the for loop based recursion and we are using backtrack clean up path
 * and we will make a deepcopy of the path when pointer it to the result
 * so that we avoid return null result. 
 */

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        helper(candidates, 0, target, new ArrayList<>(), result);
        return result;
    }

    private void helper(int[] candidates, int pivot, int target, List<Integer> path, List<List<Integer>> result) {

        if (target == 0) {
            result.add(new ArrayList<>(path));
        }
        if (target < 0 || pivot == candidates.length) {

            return;
        }

        for (int i = pivot; i < candidates.length; i++) {
            path.add(candidates[i]);
            helper(candidates, i, target - candidates[i], path, result);

            path.remove(path.size() - 1);
        }
    }
}