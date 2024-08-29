// Problem 39. Combination Sum
// Time Complexity : O(2^N) , n = number of candidates
// Space Complexity : O(2^N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
class CombinationSum {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        helper(candidates, 0, target, new ArrayList<>());
        return result;
    }
    private void helper(int[] candidates, int pivot,int target, List<Integer> path){
        // base case
        if(target == 0){
            result.add(new ArrayList<>(path));
            return;
        }
        if(target < 0){
            return;
        }
        //logic
        for(int i = pivot; i < candidates.length; i++){
            //choose
            path.add(candidates[i]); // add current
            helper(candidates, i, target - candidates[i], path); // recursion
            path.remove(path.size() - 1); //backtrack
        }
    }
}
