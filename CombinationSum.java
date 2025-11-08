import java.util.ArrayList;
import java.util.List;

/*
 * Combination Sum - LeetCode 39
 * Approach: Backtracking. Try all combinations recursively by including or excluding each candidate.
 * Time Complexity: O(2^n * k), where n is the number of candidates and k is the average length of a combination.
 * Space Complexity: O(k * x), where x is the number of valid combinations.
 * LeetCode Link: https://leetcode.com/problems/combination-sum/
 */

public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        helper(candidates, target, 0 , new ArrayList<Integer>(), result);
        return result;
    }

    private void helper(int[] candidates, int target, int idx, List<Integer> path, List<List<Integer>> result) {

        if (idx == candidates.length || target < 0) return;
        //logic
        if( target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        helper(candidates, target, idx+1,  path, result);

        //action
        path.add(candidates[idx]);
        //recurse
        helper(candidates, target-candidates[idx], idx, path, result);
        //backtrack
        path.removeLast();

    }
}
