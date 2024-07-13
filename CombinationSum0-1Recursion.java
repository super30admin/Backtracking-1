// Time Complexity : Exponential
// Space Complexity : O(n) due to recursive stack space where n is the length of candidates
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
Approach: Used 0-1 recursive approach by passing index & path to the recusrive function. In the base condition checked if target becomes negative we return and if 0 then add in the output. Start with the case 0 (don't choose) and pass index +1, target remains the same whereas for case 1 (choose) pass index as index (as we can have same numbers repeated) and target as target - candidates[index]. In this method we are copying over the elements in path for every recursive call
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
            return;
        }

        //logic

        //0 or not choose case
        recurse(candidates, target, index+1, new ArrayList<>(path));
        path.add(candidates[index]);

        //1 or choose case
        recurse(candidates, target - candidates[index], index, new ArrayList<>(path));
    }
}