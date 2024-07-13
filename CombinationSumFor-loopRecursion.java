// Time Complexity : Exponential
// Space Complexity : O(n) due to recursive stack space where n is the length of candidates
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
Approach: Used for-loop based recursive approach by passing index & path to the recusrive function. In the base condition checked if target becomes negative we return and if 0 then add in the output. Start the for loop with index, then create a new list copy the existing path and add candidates[i], then in call recurse and pass index as i +1, target as target - candidates[i]
 */
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        if(candidates == null || candidates.length == 0){
            return new ArrayList<>();
        }

        result = new ArrayList<>();

        recurse(candidates, target, 0, new ArrayList<>());

        return result;

    }

    private void recurse(int[] candidates, int target, int index, List<Integer> path){

        //base
        if(target < 0 || index == candidates.length){
            return;
        }

        if(target == 0){
            result.add(path);
        }

        //logic

        for(int i = index; i < candidates.length; i ++){
            List<Integer> newList = new ArrayList<>(path);
            newList.add(candidates[i]);
            recurse(candidates, target - candidates[i], i, newList);
        }
    }
}