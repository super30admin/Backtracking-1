class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) return new ArrayList<>();

        result = new ArrayList<>();

        backtrack(candidates, target, 0, 0, new ArrayList<>());

        return result;
    }

    public void backtrack(int[] candidates, int target, int index, int currSum, List<Integer> combination) {
        if (currSum == target) {
            result.add(new ArrayList<>(combination));
            return;
        }
        if (currSum > target || index == candidates.length) return;

        combination.add(candidates[index]);
        backtrack(candidates, target, index, currSum + candidates[index], combination);
        combination.removeLast();
        backtrack(candidates, target, index + 1, currSum, combination);
    }
}
