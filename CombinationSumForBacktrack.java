import java.util.*;

class Solution {

    List<List<Integer>> res;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        res = new ArrayList<>();

        helper(candidates, target, new ArrayList<>(), 0);

        return res;
    }

    private void helper(int[] candidates,
                        int target,
                        List<Integer> path,
                        int indx) {

        if (target < 0) {
            return;
        }

        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = indx; i < candidates.length; i++) {

            path.add(candidates[i]);

            helper(candidates,
                   target - candidates[i],
                   path,
                   i);

            // backtrack
            path.remove(path.size() - 1);
        }
    }
}