// Time Complexity : exponential
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    List<List<Integer>> result;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return new ArrayList<>();
        }
        result = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>());
        return result;
    }

    private void backtrack(int[] candidates, int target, int index, List<Integer> path) {
        // base case
        if (target < 0 ) {
            return;
        }
        if (target == 0) {
            result.add(new ArrayList<>(path));
        }
        for (int i = index; i < candidates.length; i++) {
            // action
            path.add(candidates[i]);
            // recursion
            backtrack(candidates, target - candidates[i], i, path);
            // backtrack
            path.remove(path.size()-1);
        }
    }

}