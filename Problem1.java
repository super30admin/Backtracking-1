class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // Create a list to store all unique combinations of candidates
        List<List<Integer>> result = new ArrayList<>();
        // Call the backtrack function to generate all combinations recursively
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        // Return the result list
        return result;
    }
    
    // Backtrack function to generate all combinations recursively
    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] candidates, int remain, int start) {
        // If the remaining target is negative, this combination cannot be valid, so return
        if (remain < 0) return;
        // If the remaining target is 0, it means that the current combination is valid, so add it to the result list and return
        if (remain == 0) {
            result.add(new ArrayList<>(tempList));
            return;
        }
        // Loop through the candidates array, starting at the given index
        for (int i = start; i < candidates.length; i++) {
            // Add the current candidate to the temporary list
            tempList.add(candidates[i]);
            // Recursively call the backtrack function with the updated values
            // The starting index remains the same, as the same candidate can be chosen again
            backtrack(result, tempList, candidates, remain - candidates[i], i);
            // Remove the last candidate from the temporary list to backtrack and try the next candidate
            tempList.remove(tempList.size() - 1);
        }
    }
}
