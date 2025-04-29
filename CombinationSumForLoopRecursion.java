// Time Complexity : O(2^(m+n))
// Space Complexity : O(m+n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

public class CombinationSumForLoopRecursion {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        helper(candidates, 0, path, target);
        return result;
    }

    private void helper(int[] candidates, int pivot, List<Integer> path, int target) {
        // base
        if (target < 0) return;
        if (target == 0) {
            result.add(new ArrayList<>(path));
        }

        // logic
        for (int i = pivot; i < candidates.length; i++) {
            path.add(candidates[i]);
            helper(candidates, i, path, target - candidates[i]);
            path.remove(path.size() - 1);
        }
    }
}
