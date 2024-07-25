// Time Complexity : O(2^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :
class CombinationSum {
    // using 0/1 recursion with backtracking
    List<List<Integer>> res;
    List<Integer> path;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.res = new ArrayList<>();
        this.path = new ArrayList<>();
        helper(candidates, 0, target);
        return res;
    }

    private void helper(int[] candidates, int index, int target) {
        // base
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        if (target < 0 || index == candidates.length) {
            return;
        }
        // logic

        // choose scenario

        // Action
        path.add(candidates[index]);
        // recurse
        helper(candidates, index, target - candidates[index]);
        // backtrack
        path.remove(path.size() - 1);
        // not choose scenario
        helper(candidates, index + 1, target);
    }
}
