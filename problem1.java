
/**
Time Complexity = Exponential, approximately O(2^N)
Explanation:
For each element, we either choose it or skip it.
This results in exploring all possible combinations recursively.

Space Complexity = O(Target)
Explanation:
The recursion stack and the current path list can grow up to
target / smallest candidate value.

Did this code successfully run on LeetCode : Yes

Any problem you faced while coding this :
Initially struggled to decide when to move the index forward and
when to stay on the same index to allow reuse of elements.
Fixed it by using:
- idx + 1 for "not choose"
- same idx for "choose"
*/

import java.util.*;

class Solution {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        helper(candidates, 0, target, new ArrayList<>(), result);
        return result;
    }

    private void helper(int[] candidates, int idx, int target, List<Integer> path, List<List<Integer>> result) {
        // Base cases
        if (idx == candidates.length || target < 0) {
            return;
        }
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        // Not choose current element
        helper(candidates, idx + 1, target, path, result);

        // Choose current element
        path.add(candidates[idx]);
        helper(candidates, idx, target - candidates[idx], path, result);
        // Backtrack
        path.remove(path.size() - 1);
    }
}
