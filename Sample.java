// Time Complexity : O(2^t), where t is the target
//   - In the worst case, every element could be picked multiple times leading to exponential combinations
// Space Complexity : O(t) recursion depth in the worst case, and O(k) for each combination stored in result

// This solution uses backtracking to explore all combinations that sum to the target.
// At each step, we try including the current number (repeating allowed), and recurse with reduced target.
// We backtrack by removing the last added element to explore other branches.

class Solution {
    List<List<Integer>> result;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.result = new ArrayList<>();
        helper(candidates, target, 0, new ArrayList<>());
        return result;
    }

    private void helper(int[] candidates, int target, int pivot, List<Integer> path) {
        if (target < 0) return;

        if (target == 0) {
            result.add(new ArrayList<>(path)); // Make a copy before storing
            return;
        }

        for (int i = pivot; i < candidates.length; i++) {
            path.add(candidates[i]); // Choose
            helper(candidates, target - candidates[i], i, path); // Recurse with same 'i' (reuse allowed)
            path.remove(path.size() - 1); // Backtrack
        }
    }
}
