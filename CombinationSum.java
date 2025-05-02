
import java.util.*;
// Time Complexity: O(2^n) in the worst case, where n is the number of candidates.
// Space Complexity: O(n) for the recursion stack and the result list, where n is the number of candidates.
// LeetCode: https://leetcode.com/problems/combination-sum/

/**
 * Finds all unique combinations of candidates where the chosen numbers sum to the target.
 * Uses backtracking with pruning to explore valid paths, allowing repeated use of the same number.
 * Returns a list of all such combinations without duplicates in terms of set composition.
 */

public class CombinationSum {
        List<List<Integer>> result;
    
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            this.result = new ArrayList<List<Integer>>();
            helper(candidates, target, 0, new ArrayList<Integer>());
            return result;
        }
    
        public void helper(int[] candidates, int amountRemaining, int pivot, List<Integer> currentPath) {
            if (amountRemaining == 0) {
                result.add(new ArrayList<>(currentPath));
                return;
            }
    
            if (amountRemaining < 0) {
                return;
            }
    
            for (int i = pivot; i < candidates.length; i++) {
                //action
                currentPath.add(candidates[i]);
                //recurse
                helper(candidates, amountRemaining - candidates[i], i, currentPath);
                //backtrack
                currentPath.remove(currentPath.size() - 1);
            }
        }
}
