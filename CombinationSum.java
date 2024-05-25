// Time Complexity : O(2^(m+n))
// Space Complexity : O(N) - auxilary stack space for recursive call
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class CombinationSum {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();

        helper(candidates, 0, target, new ArrayList<>());

        return result;
    }

    private void helper(int[] candidates, int pivot, int target, List<Integer> path) {

        //base case
        if(target ==0){
            result.add(new ArrayList<>(path));
            return;
        }
        //invalid path
        if(target < 0) {
            return;
        }

        //logic
        for(int i=pivot;i< candidates.length;i++){
            //action
            path.add(candidates[i]);
            //recursive call
            helper(candidates, i, target - candidates[i], path);
            //backtrack
            path.remove(path.size()-1);
        }
    }
}


class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.result = new ArrayList<>();
        helper(candidates, target,0, new ArrayList<>());
        return result;
    }

    private void helper(int[] candidates, int target, int pivot, List<Integer> path) {
        // base case
        if(target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        if(target < 0 || pivot == candidates.length) {
            return;
        }

        for(int i=pivot;i<candidates.length;i++) {
            path.add(candidates[i]);
            helper(candidates, target - candidates[i], i, path);
            path.remove(path.size()-1);
        }

    }
}