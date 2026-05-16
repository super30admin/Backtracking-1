// https://leetcode.com/problems/combination-sum/
// Time Complexity : O(2^(m+n)) where m is the number of candidates and n is the target value.
// Space Complexity : O(n) where n is the maximum depth of the recursion tree.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        helper(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }
    private void helper(int[] candidates, int target, int idx, List<Integer> path, List<List<Integer>> result){
        //base case
        if(idx == candidates.length || target < 0) return;
        if(target == 0){
            result.add(new ArrayList(path));
            return;
        }
        // logic
        // no choose
        helper(candidates, target, idx+1, path, result);
        //choose
        // action
        path.add(candidates[idx]);
        // recurse
        helper(candidates, target-candidates[idx], idx, path, result);
        // backtrack
        path.remove(path.size()-1);
    }
}