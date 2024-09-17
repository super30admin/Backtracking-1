// Time Complexity : O(2^n); Exponential
// Space Complexity : O(m+n); m=total number of elements in candidates, n=amount
// Did this code successfully run on Leetcode : Yes

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<List<Integer>>();
        if(candidates == null || candidates.length == 0)
            return result;
        helper(candidates, target, 0, new ArrayList<Integer>());
        return result;
    }
    private void helper(int[] candidates, int target, int index, List<Integer> path) {
        //base case
        if(target == 0) {
            result.add(path);
            return;
        }
        //edge condition
        if(target<0 || index == candidates.length)
            return;
        //don't choose
        helper(candidates, target, index+1, new ArrayList<>(path));
        //choose
        path.add(candidates[index]);
        helper(candidates, target - candidates[index], index, new ArrayList<>(path));
    }
}