// Time complexity O(2^T) T= target
// Space complexity O(N x T)
// Runs on LeetCode YES
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<List<Integer>>();
        helper(candidates, target, 0, new ArrayList<>());
        return result;
    }

    private void helper(int[] candidates, int target, int idx, ArrayList<Integer> path){
        // base
        if(idx == candidates.length || target < 0) {
            return;
        }

        if(target == 0){
            result.add(new ArrayList(path));
            return;
        }

        // Choose
        path.add(candidates[idx]);
        helper(candidates, target - candidates[idx], idx, path);

        // Not Choose
        path.remove(path.size() -1);
        helper(candidates, target, idx +1, path);
    }
}