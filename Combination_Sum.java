/*
Approach : based on the pattern recognition from coin change problem
we can use choose case and no choose case scenario means 0-1
here we keep list of list of integer to hold the result and use an arraylist.

We use backtracking here

 */

// Time: O(2^m) in the worst case, where m = target and n = number of candidates.
// Space: O(m) auxiliary stack space, plus output space proportional to the number of valid combinations.


class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.result = new ArrayList<>();
        helper(candidates, target, 0, new ArrayList<>());
        return result;
    }

    private void helper(int[] candidates, int target, int i, List<Integer> path){

        // base case 
        if(target < 0 || i == candidates.length) return;

        if(target == 0){
            result.add(new ArrayList<>(path));
            return;
        }
        
        // no choose scenario
        helper(candidates, target, i+1, path);

        // choose case scenario

        path.add(candidates[i]); // action
        helper(candidates, target - candidates[i], i, path); // recursion
        path.remove(path.size()-1); // backtrack
    }
}