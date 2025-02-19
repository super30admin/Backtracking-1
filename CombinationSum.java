//TC: O(2^target)
//SC: O(target)
//approach: backtracking

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    List<List<Integer>> result;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        if (candidates == null) return result;
        helper(candidates, 0, target, new ArrayList<>());
        return result;
    }

    private void helper(int[] candidates, int index, int amount, List<Integer> path) {
        if (amount == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        if (amount < 0) return;

        for (int i = index; i < candidates.length; i++) {
            path.add(candidates[i]);
            helper(candidates, i, amount - candidates[i], path);
            path.remove(path.size() - 1);
        }
    }
}
