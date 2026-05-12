// Time Complexity : O(2^(m + n)) where m is candidates length and n is target
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach in three sentences only
// We use backtracking to explore two choices at every step: either include the current candidate or skip it and move to the next one.
// If the target becomes 0, we add a deep copy of the current path to the result since it forms a valid combination.
// Backtracking removes the last chosen element after recursion so other possible combinations can be explored correctly.

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.result = new ArrayList<>();
        helper(candidates, target, 0, new ArrayList<>());
        return result;    
    }

    private void helper(int[] candidates, int target, int index, List<Integer> path){
        // Base case
        if (target < 0 || index == candidates.length) return;

        // Always return a deep copy
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        // don't choose
        helper(candidates, target, index+1, path);

        // choose
        path.add(candidates[index]);
        helper(candidates, target-candidates[index], index, path);

        //backtrack
        path.remove(path.size()-1);
            
    }
}