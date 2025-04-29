// Time Complexity : O(2^(m+n))
// Space Complexity : O(m+n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

public class CombinationSumBackTracking {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        helper(candidates, 0, path, target);
        return result;
    }

    private void helper(int[] candidates, int idx, List<Integer> path, int target) {
        // base
        if (target < 0 || idx == candidates.length) return;
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        // logic
        // 0 case
        helper(candidates, idx + 1, path, target);

        // 1 case
        path.add(candidates[idx]);
        helper(candidates, idx, path, target - candidates[idx]);

        path.remove(path.size() - 1);
    }
}
