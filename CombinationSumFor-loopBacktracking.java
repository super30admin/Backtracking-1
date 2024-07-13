// Time Complexity : Exponential
// Space Complexity : O(n) due to recursive stack space where n is the length of candidates
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
Approach: Used for-loop based recursive backtracking approach by passing index & path to the recusrive function. In the base condition checked if target becomes negative we return and if 0 then add in the output. Start the for loop with index, the add path.add(candidates[i]) as action, recurse and as backtracking step undo the action.
 */
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        if(candidates == null || candidates.length == 0){
            return new ArrayList<>();
        }

        result = new ArrayList<>();

        backtrack(candidates, target, 0, new ArrayList<>());

        return result;

    }

    private void backtrack(int[] candidates, int target, int index, List<Integer> path){

        //base
        if(target < 0 || index == candidates.length){
            return;
        }

        if(target == 0){
            result.add(new ArrayList<>(path));
        }

        //logic

        for(int i = index; i < candidates.length; i ++){

            //action
            path.add(candidates[i]);

            //recurse
            backtrack(candidates, target - candidates[i], i, path);

            //backtrack
            path.remove(path.size() -1);
        }
    }
}