import java.util.ArrayList;
import java.util.List;

/**
 * Time Complexity: O(2^target) - exponential
 * Space Complexity: O(target)
 * Did this code successfully run on Leetcode: Yes
 * Any problem you faced while coding this: None

 * Approach:
 * Since we need to find all possible combinations, the idea is to go exhaustive and look for each possible combination recursively
 * Making it more efficient using backtracking. 
 * Action: Add to path
 * Recurse: Recursively find target path
 * Backtrack: Remove the last added item from path
 */

public class CombinationSum {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return new ArrayList<>();
        }

        result = new ArrayList<>();
        recurse(candidates, target, 0, new ArrayList<>());
        return result;
    }

    private void recurse(int[] candidates, int target, int index, List<Integer> path) {
        // base
        if (target < 0)
            return;
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        
        // logic
        for(int i = index; i < candidates.length; i++) {
            path.add(candidates[i]);
            recurse(candidates, target - candidates[i], i, path);
            path.remove(path.size() - 1);
        }
    }

    public static void main(String[] args) {
        // Your code here
        CombinationSum obj = new CombinationSum();
        int[] candidates = {2,3,6,7};
        int target = 6;
        List<List<Integer>> answer = obj.combinationSum(candidates, target);
        System.out.println(answer);
    }
}