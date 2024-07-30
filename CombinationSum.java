// Time Complexity: O(2^t), t: target value
// Space Complexity: O(t), t: depth of the recursion tree

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int index = 0;
        findCombinations(candidates, index, target, result, new ArrayList<>());
        return result;
    }

    private void findCombinations(int[] candidates, int start, int target, List<List<Integer>> result, List<Integer> combination) {
        if (target == 0) {
            result.add(new ArrayList<>(combination));
            return;
        }

        if (target < 0)
            return;

        for (int i = start; i < candidates.length; i++) {
            combination.add(candidates[i]);
            findCombinations(candidates, i, target - candidates[i], result, combination);
            combination.remove(combination.size() - 1);
        }
    }
}
