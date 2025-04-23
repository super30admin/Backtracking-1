import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    List<List<Integer>> res;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.res = new ArrayList<>();
        helper(candidates, target, 0, new ArrayList<>());
        return res;
    }

    private void helper(int[] candidates, int target, int i, List<Integer> path) {
        //base
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        if (target < 0 || i == candidates.length)
            return;

        //action
        path.add(candidates[i]);

        //choose
        helper(candidates, target - candidates[i], i, path);

        path.removeLast();

        //no choose
        helper(candidates, target, i + 1, path);
    }
}

//TC: O(2^(t+n)), SC: O(T) - max depth of recursion


//Approach - 2 : for loop based recursion
class Solution {
    List<List<Integer>> res;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.res = new ArrayList<>();
        helper(candidates, target, 0, new ArrayList<>());
        return res;
    }

    private void helper(int[] candidates, int target, int pivot, List<Integer> path) {
        //base
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        if (target < 0)
            return;

        for (int i = pivot; i < candidates.length; i++) {
            //action
            path.add(candidates[i]);

            //recurse
            helper(candidates, target - candidates[i], i, path);

            path.removeLast();
        }

    }
}

//TC: O(2^(t+n)), SC: O(T) - max depth of recursion