// Time Complexity : O(n * 2^(m+n)
// Space Complexity : O(n * h) -> O(n^2)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.result = new ArrayList<>();
        helper(candidates, target, 0, new ArrayList<>());
        return result;
    }

    private void helper(int[] candidates, int target, int pivot, List<Integer> path) {

        //base case
        if (target < 0) return;

        if (target == 0) {
            result.add(path);
            return;
        }

        for (int i = pivot; i < candidates.length; i++) {
            //action
            List<Integer> list = new ArrayList<>(path);
            list.add(candidates[i]);

            //recurse
            helper(candidates, target - candidates[i], i, list);
        }
    }
}
