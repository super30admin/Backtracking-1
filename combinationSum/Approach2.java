package combinationSum;

import java.util.ArrayList;
import java.util.List;

/**
 * backtracking
 * this avoids deep copy
 */

class Approach2 {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        this.result = new ArrayList();
        List<Integer> path = new ArrayList();

        helper(candidates, 0, path, target);

        return result;
    }

    private void helper(int[] candidates, int idx, List<Integer> path, int target)
    {
        if(target < 0 || idx == candidates.length) {
            return;
        }

        if(target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        // 0 ccase
        helper(candidates, idx + 1, path, target);

        path.add(candidates[idx]);
        helper(candidates, idx, path, target - candidates[idx]);

        path.remove(path.size() - 1);
    }
}
