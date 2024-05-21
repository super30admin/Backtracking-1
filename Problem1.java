import java.util.*;

// Time Complexity : O(2^(m+n))
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


/**
 * We can solve this problem with choose and don't choose approach.
 * Since we want to add all possible paths to the result we need take care of references.
 * Hence, we need to create a new ArrayList for each recursive call. Else, at the end
 * the result will have empty lists. If we do choose first, we need to backtrack it.
 * If don't choose is done first, we don't need to backtrack.
 * <p>
 * For-loop-based recursion:-
 * We take a pivot starting from 0th index and call the function recursively inside the loop.
 * Seeing the code it looks like we are only doing the choose part.
 * But the pivot is doing the don't choose part.
 * Also, since we are not creating a deep copy of path everytime, we do need to backtrack.
 * Personal Note: Checkout leetcode 39. Combination Sum for more details on backtracking.
 */

public class Problem1 {
    private List<List<Integer>> res;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.res = new ArrayList<>();
        helper(candidates, 0, new ArrayList<>(), target);
        return res;
    }

    /**
     * 0 1 based recursion. (Choose and don't choose)
     */
    private void helper01(int[] candidates, int idx, List<Integer> path, int target) {
        //base
        if (idx == candidates.length || target < 0) return;

        if (target == 0) {
            res.add(path);
            return;
        }


        ///logic


        //choose
        path.add(candidates[idx]);
        helper01(candidates, idx, new ArrayList<>(path), target - candidates[idx]);
        path.removeLast();

        //don't choose
        helper01(candidates, idx + 1, new ArrayList<>(path), target);
    }

    /**
     * for-loop-based recursion
     */
    private void helper(int[] candidates, int pivot, List<Integer> path, int target) {
        //base
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        if (target < 0) return; //IMP condition. Otherwise, StackOverflow

        //for-loop-based recursion
        for (int i = pivot; i < candidates.length; i++) {

            //action
            path.add(candidates[i]);

            //recurse
            helper(candidates, i, path, target - candidates[i]);

            //backtrack
            path.removeLast();
        }
    }
}

