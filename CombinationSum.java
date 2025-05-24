// Time Complexity : O(2^t), t = target value
// Space Complexity : O(k), depth of recursion stack
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Approach -
//   - Use backtracking with a `pivot` to explore combinations starting from the current index.
//   - At each step, either include the current candidate or skip it (handled by loop).
//   - When the target becomes 0, add the current combination path to the result.
//   - Use backtracking by removing the last added element after the recursive call.

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.result = new ArrayList<>();
        helper(candidates, target, 0, new ArrayList<>());
        return result;
    }

    // void helper(int[] candidates, int target, int i, List<Integer>path) {
    //     //base case
    //     if(target < 0 || i == candidates.length) {
    //         return;
    //     }

    //     if(target == 0) {
    //         result.add(new ArrayList<>(path));  //create deep cpy and add to result
    //         return;
    //     }

    //     //nochoose
    //     helper(candidates, target, i + 1, path);   //send deepcopy of path

    //     //choose
    //     path.add(candidates[i]);
    //     helper(candidates, target - candidates[i], i, path);

    //     //backtracking
    //     path.remove(path.size() - 1);
    // }

    void helper(int[] candidates, int target, int pivot, List<Integer> path) {
        if(target < 0) {
            return;
        }

        if(target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        //for loop handle no choose case and inner resucurssion handles choose case
        for(int i = pivot; i < candidates.length; i++) {
            //action
            path.add(candidates[i]); //we add no at ith index not at pivot
            //recurse
            helper(candidates, target - candidates[i], i, path);
            //backtrack
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        CombinationSum cs = new CombinationSum();

        int[] candidates1 = {2, 3, 6, 7};
        int target1 = 7;

        int[] candidates2 = {2, 3, 5};
        int target2 = 8;

        System.out.println("Combinations for target 7: " + cs.combinationSum(candidates1, target1));
        System.out.println("Combinations for target 8: " + cs.combinationSum(candidates2, target2));
    }
}
