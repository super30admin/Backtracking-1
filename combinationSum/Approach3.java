package combinationSum;

import java.util.ArrayList;
import java.util.List;

// Time Complexity : O((m+n)2^m+n)
// Space Complexity : O((m+n)2^m+n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/*
For based loop
Time Complexity: O(2^T) (approximate), where T is the target value.
In the worst case, we explore all possible combinations summing up to target, leading to exponential growth.
Space Complexity: O(T), due to the recursion depth (worst case: target / min(candidates[i]) levels deep) and storage for intermediate paths.
The function recursively explores all possible combinations of candidates that sum to target,
ensuring that numbers can be reused but only in non-decreasing order. It uses backtracking by adding a number,
recursively reducing amount, and then removing the last added number before trying the next option.
The pivot index prevents duplicate sets, ensuring that each combination is unique.
 */

/**
 * for-loop based recursion -- pivot based
 */
class Approach3 {
    List<List<Integer>> result;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        this.result = new ArrayList();
        List<Integer> path = new ArrayList();

        helper(candidates, 0, path, target);

        return result;
    }

    private void helper(int[] candidates, int pivot, List<Integer> path, int target) {
        // Base case: If amount goes negative, terminate this path
        if (target < 0 || pivot == candidates.length) {
            return;
        }

        if (target == 0) {
            result.add(new ArrayList(path));
            return;
        }

        // Iterate through candidates starting from the current pivot index
        for (int i = pivot; i < candidates.length; i++) {

            // Choose the candidate
            // action -- at each and every node we are adding pivot index to the path
            path.add(candidates[i]);

            // Recur with the same candidate (since we can use the same number multiple times
            helper(candidates, i, path, target - candidates[i]);

// Backtrack: Remove the last added element to explore other possibilities
            path.remove(path.size() - 1);
        }
    }
}
