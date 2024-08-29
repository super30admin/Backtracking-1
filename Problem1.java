
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);  // Sort the candidates array
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] candidates, int remain, int start) {
        if (remain < 0) {
            return;  // If the remaining target is negative, stop the search
        } else if (remain == 0) {
            result.add(new ArrayList<>(tempList));  // If the remaining target is 0, add the current combination to the result
        } else {
            for (int i = start; i < candidates.length; i++) {
                tempList.add(candidates[i]);  // Choose the current candidate
                backtrack(result, tempList, candidates, remain - candidates[i], i);  // Recurse with the updated target
                tempList.remove(tempList.size() - 1);  // Backtrack and remove the last added candidate
            }
        }
    }
}
