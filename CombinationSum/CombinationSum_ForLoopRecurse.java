/* Time Complexity : O(2^(m+n)) 
 *  m - length of the array 
 *  n - max length of the path */
/* Space Complexity : O(n) */
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this :

//For loop recurse solution

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        helper(candidates, target, 0, new ArrayList<>());
        return result;
    }

    private void helper(int[] candidates, int target, int pivot, List<Integer> path){
        //base condition
        if(target < 0 ) return;
        if(target == 0){
            result.add(new ArrayList<>(path));
            return;
        }
        
        for(int i = pivot; i < candidates.length; i++){
            //action
            List<Integer> temp = new ArrayList<>(path);
            temp.add(candidates[i]);
            //recurse
            helper(candidates, target - candidates[i], i, temp);
        }        
    }
}