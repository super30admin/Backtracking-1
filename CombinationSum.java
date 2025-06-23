import java.util.*;

// Time Complexity : O(2^(m+n)) where m is the target and n is the number of candidates
// Space Complexity : O(n) for the recursion stack and the result list
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// 0-1 Recursion
public class CombinationSum {
    List<List<Integer>> result;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.result = new ArrayList<>();
        helper(candidates, target, 0, new ArrayList<>());
        return result;
    }

    public void helper(int[] candidates, int target, int idx, List<Integer> path) {
        if (target == 0) {
            result.add(path);
            return;
        }

        if (target < 0 || idx == candidates.length)
            return;

        // not choose - w/ deep copy
        helper(candidates, target, idx + 1, new ArrayList<>(path));
        // choose
        List<Integer> temp = new ArrayList<>(path);
        // we need to deep copy the path to avoid modifying the original list
        temp.add(candidates[idx]);
        helper(candidates, target - candidates[idx], idx, temp);
    }
}

// 0-1 Recursion with backtracking
class Recursion01 {
    List<List<Integer>> result;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.result = new ArrayList<>();
        helper(candidates, target, 0, new ArrayList<>());
        return result;
    }

    public void helper(int[] candidates, int target, int idx, List<Integer> path) {
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        if (target < 0 || idx == candidates.length)
            return;

        // not choose - w/ deep copy
        helper(candidates, target, idx + 1, new ArrayList<>(path));
        // choose
        path.add(candidates[idx]);
        helper(candidates, target - candidates[idx], idx + 1, path);
        // backtrack
        path.remove(path.size() - 1);
    }
}

// For loop based recursion
class CombinationSum_ForLoop {
    List<List<Integer>> result;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        helper(candidates, new ArrayList<>(), 0, target);
        return result;
    }

    public void helper(int[] candidates, List<Integer> path, int pivot, int target) {
        // base
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        if (target < 0 || pivot == candidates.length)
            return;

        // logic
        for (int i = pivot; i < candidates.length; i++) {
            // action
            path.add(candidates[i]);

            // recurse
            helper(candidates, path, i, target - candidates[i]);

            // backtrack
            path.remove(path.size() - 1);

        }

    }
}
