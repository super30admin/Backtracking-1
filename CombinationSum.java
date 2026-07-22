class Solution {
    /*
        TC = O(N^M), where M is the target/smallest number and N is the total numbers 
        SC - O(M) - recursive stack, where M is the target/smallest number
        Maintain a path representing the current combination.
        If target == 0, add the current path to the result.
        If target < 0, stop exploring that branch.
        Iterate from the current pivot index to avoid duplicate combinations.
        Recursively call with the same index (i) so the current number can be reused unlimited times.
        After recursion, remove the last element (backtrack) and try the next candidate.
    */
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.result = new ArrayList<>();
        helper(candidates, target, new ArrayList<>(), 0);
        return result;
    }

    private void helper(int[] candidates, int target, List<Integer> path, int pivot) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = pivot; i < candidates.length; i++) {
            path.add(candidates[i]);
            helper(candidates, target - candidates[i], path, i);
            path.remove(path.size() - 1);
        }
    }
}