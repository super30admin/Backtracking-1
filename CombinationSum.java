// Time Complexity : O((m+n)*2^(m+n)) where m+n is height of recursive tree and so there are 2^(m+n) nodes in the tree
// Space Complexity : O((m+n)*2^(m+n))
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach

public class CombinationSum {
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
            result.add(path);
            return;
        }

        // logic
        // 0 case
        helper(candidates, idx + 1, path, target);

        // 1 case
        List<Integer> li = new ArrayList<>(path);
        li.add(candidates[idx]);
        helper(candidates, idx, li, target - candidates[idx]);
    }
}
