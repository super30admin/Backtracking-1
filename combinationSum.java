// Time Complexity (TC): 
// O(2^n )

// Space Complexity (SC): 
// O(t)

class Solution {
    // Method to find all unique combinations in candidates that sum up to the target
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>(); // To store the final result
        helper(0, candidates, target, new ArrayList<>(), result); // Call the helper method to find combinations
        return result; // Return the final result
    }

    // Helper method to perform the combination sum using backtracking
    private void helper(int pivot, int[] candidates, int target, List<Integer> path, List<List<Integer>> result) {
        // Base case: if the target is zero, add the current path to the result
        if (target == 0) {
            result.add(new ArrayList<>(path)); // Add a copy of the current path
            return;
        }
        // Base case: if the target is negative, return as no valid combination is possible
        if (target < 0) return;

        // Iterate through the candidates starting from the pivot index
        for (int i = pivot; i < candidates.length; i++) {
            // Action: Add the current candidate to the path
            path.add(candidates[i]);
            // Recurse: Call the helper method with the updated target and path
            helper(i, candidates, target - candidates[i], path, result);
            // Backtrack: Remove the last added candidate from the path to try other combinations
            path.remove(path.size() - 1);
        }
    }
}
