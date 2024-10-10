// Time Complexity : O(2^m+n)
// Space Complexity : O(2^m+n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : used the same logic Jaspinder explained in the class.

class Solution {
    List<List<Integer>> res;
    List<Integer> path;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.res = new ArrayList<>();
        this.path = new ArrayList<>();
        forloophelper(candidates, 0, target);
        return res;
    }

    private void forloophelper(int[] candidates, int pivot, int target){
        //base
        if(target == 0){
            res.add(new ArrayList<>(path));
            return;
        }
        if(target < 0 || pivot == candidates.length) return;

        //logic
        for(int i = pivot; i < candidates.length; i ++){
            //action
            path.add(candidates[i]);
            //recurse
            forloophelper(candidates, i, target - candidates[i]);
            //backtrack
            path.remove(path.size() - 1);
        }
    }
}