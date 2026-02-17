// Time Complexity : O(2^(N))
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
class Solution {
    List<List<Integer>> res;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.res = new ArrayList<>();
        // Arrays.sort(candidates);
        helper(candidates, target, 0, new ArrayList<>());
        return res;
    }

    private void helper(int[] candidates, int target, int pivot, List<Integer> path) {

        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = pivot; i < candidates.length; i++) {
            if (target - candidates[i] < 0) {
                continue;
            }
            path.add(candidates[i]);
            if (target - candidates[i] >= 0)
                helper(candidates, target - candidates[i], i, path);
            path.remove(path.size() - 1);
        }

    }
}