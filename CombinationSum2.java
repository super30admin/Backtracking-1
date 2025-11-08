import java.util.ArrayList;
import java.util.List;

/*
 * Combination Sum (Variation) - LeetCode 39
 * Approach: Backtracking. Try all combinations recursively, allowing repeated use of elements.
 * Time Complexity: O(2^n * k), where n is the number of candidates and k is the average length of a combination.
 * Space Complexity: O(k * x), where x is the number of valid combinations.
 * LeetCode Link: https://leetcode.com/problems/combination-sum/
 */

public class CombinationSum2 {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        helper(candidates, 0, target, new ArrayList<Integer>(), result);
        return result;
    }

    private void helper(int[] candidates, int pivot, int target, List<Integer> path, List<List<Integer>> result) {
        if (target < 0) return;

        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        //base
        for (int i = pivot; i < candidates.length; i++) {
            //action
            path.add(candidates[i]);
            //recurse
            helper(candidates, i, target - candidates[i], path, result);
            //backtrack
            path.remove(path.size() - 1);
        }
    }
}
