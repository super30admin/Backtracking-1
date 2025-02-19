// Time Complexity : O (2^n)
// Space Complexity : O (n)
// Did this code successfully run on Leetcode : Yes

// Your code here along with comments explaining your approach
import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    List<List<Integer>> result = new ArrayList<>();
    public void backtrack(int[] candidates, int target, int index, List<Integer> currList) {
        if(target < 0) return;
        if(target == 0) {
            // when target = 0, a sum has been found, record it
            result.add(new ArrayList<>(currList));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            // add current candidate to result
            currList.add(candidates[i]);
            // call the function with target - candidates[i], and index = i since reuse is permitted
            backtrack(candidates, target - candidates[i], i, currList);
            // remove the last added candidate
            currList.removeLast();
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // call recursive function with initial target and index 0
        backtrack(candidates, target, 0, new ArrayList<>());
        return result;
    }
}
