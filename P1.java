/*
For based loop

Time Complexity: O(2^T) (approximate), where T is the target value. 
In the worst case, we explore all possible combinations summing up to target, leading to exponential growth.

Space Complexity: O(T), due to the recursion depth (worst case: target / min(candidates[i]) levels deep) and storage for intermediate paths.

The function recursively explores all possible combinations of candidates that sum to target, 
ensuring that numbers can be reused but only in non-decreasing order. It uses backtracking by adding a number, 
recursively reducing amount, and then removing the last added number before trying the next option. 
The pivot index prevents duplicate sets, ensuring that each combination is unique. 
 */





class Solution {
    List<List<Integer>> res; // Global list to store the result combinations

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>(); // Initialize the result list

        // Edge case: If candidates array is null, return an empty list
        if (candidates == null) return res;

        // Start the recursive helper function with an empty path
        helper(candidates, 0, target, new ArrayList<>());

        return res; // Return the final list of valid combinations
    }

    private void helper(int[] candidates, int pivot, int amount, List<Integer> path) {
        // Base case: If the remaining amount becomes zero, add the current combination to the result
        if (amount == 0) {
            res.add(new ArrayList<>(path)); // Make a copy of the path before adding
            return;
        }

        // Base case: If amount goes negative, terminate this path
        if (amount < 0) return;

        // Iterate through candidates starting from the current pivot index
        for (int i = pivot; i < candidates.length; i++) {
            // Choose the candidate
            path.add(candidates[i]);

            // Recur with the same candidate (since we can use the same number multiple times)
            helper(candidates, i, amount - candidates[i], path);

            // Backtrack: Remove the last added element to explore other possibilities
            path.remove(path.size() - 1);
        }
    }
}