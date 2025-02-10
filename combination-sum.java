// Time Complexity : O(2^(T/min(candidates)) * n)
// Space Complexity : O(2^(T/min(candidates)) * n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // Backtrack
        // TC = O(2^(T/min(candidates)) * n)
        // The actual number of calls is less than O(2ⁿ) because we eliminate paths where the sum exceeds target.min = min of candidates, n = length of candidates, branching
        // SC = O((2^(T/min(candidates)) * n); min = min of candidates, n = length of candidates
        // null
        if(candidates == null || candidates.length == 0) return result;
        helper(candidates, target, 0, new ArrayList<>());
        return result;
    }
    // for loop based
    // public void helper(int[] candidates, int target, int index, List<Integer> path) {
    //     // base
    //     if(target == 0) {
    //         result.add(new ArrayList<>(path));
    //         return;
    //     }
    //     if(target < 0) return; //no need to check bounds, as for loop is taking care of it
    //     // logic
    //     for(int i = index; i < candidates.length; i++) {
    //         // action
    //         path.add(candidates[i]);
    //         // recurse
    //         helper(candidates, target - candidates[i], i, path);
    //         // backtrack
    //         path.remove(path.size() - 1);
    //     }
    // }
    public void helper(int[] candidates, int target, int index, List<Integer> path) {
        // base
        if(target == 0) {
            // result.add(path); //it wont work as we've to pass by reference or it'll return empty list
            result.add(new ArrayList<>(path));
            return;
        }
        if(index == candidates.length || target < 0) return;
        // logic
        // no choose
        helper(candidates, target, index + 1, path);
        // choose
        // action
        path.add(candidates[index]);
        // recurse
        helper(candidates, target - candidates[index], index, path);
        // backtrack
        path.remove(path.size() - 1);
    }
}