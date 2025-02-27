package combinationSum;

import java.util.ArrayList;
import java.util.List;

/**
 * 01 recursion
 * (m + n) * 2^(m+n)
 */

class Approach1 {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        this.result = new ArrayList<>();
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
            result.add(path);
            return;
        }

        // 0 ccase
        helper(candidates, idx + 1, path, target);

        List<Integer> li = new ArrayList(path);
        li.add(candidates[idx]);
        helper(candidates, idx, li, target - candidates[idx]);
    }
}