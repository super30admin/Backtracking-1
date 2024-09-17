// Time Complexity : Exponential
// Space Complexity : O(m+n); m=total number of elements in candidates, n=amount
// Did this code successfully run on Leetcode : Yes

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<List<Integer>>();
        if(candidates == null || candidates.length == 0)
            return new ArrayList<List<Integer>>();
        helper(candidates, target, 0, new ArrayList<Integer>());
        return result;
    }
    private void helper(int[] candidates, int target, int index, List<Integer> path) {
        //base case
        if(target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        if(target < 0)
            return;
        for(int i=index; i<candidates.length; i++) {
            path.add(candidates[i]);
            helper(candidates, target-candidates[i], i, path);
            path.remove(path.size()-1);
        }
    }
}