// Time complexity:- O(2^T) Where T is the target value.
// Space complexity:- O(T) for the recursion stack and path.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach 
/**
 * Approach:
 * This problem is about finding all unique combinations of numbers that sum up to a given target, 
 * where each number in the array can be used unlimited times. 
 * I used backtracking with recursion to explore all possible combinations and added a path to the result list when the sum matched the target. 
 * At each step, I chose to either include the current number (to reuse it) or skip to the next number.
 */
class Solution {

    List<List<Integer>> result;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        result = new ArrayList<>();
         
        // Temporary list to store current combination path
        List<Integer> path = new ArrayList<>();
        // Start recursive backtracking from index 0
        helper(candidates, 0, path, 0, target);

        return result;


    }
    private void helper(int[] candidates, int idx, List<Integer> path, int sum, int target) {

        //base case: if sum exceeds target or index is out of bounds
        if(idx == candidates.length || sum > target) {
            return;
        }
        
        // action: If a valid combination is found
        if(sum == target) {
            result.add(new ArrayList<>(path));
            return;
        }
        // Include the current candidate 
        path.add(candidates[idx]);
        

        //recurse 1(choose) Recurse with same index (because the number can be reused)
        helper(candidates, idx, path, sum + candidates[idx], target);

        //Backtrack: remove the last added number
        path.remove(path.size()-1);
        
        //recurse 0(not choose) Recurse without including the current number (move to next index)
        helper(candidates, idx + 1, path, sum, target);

    }
}
