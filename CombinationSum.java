class Solution {
  List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates == null || candidates.length == 0) {
            return new ArrayList<>();
        }

        result = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>());
        return result;
    }

    private void backtrack(int[] candidates, int target, int index, List<Integer> path) {
        if(target < 0) {
            return;
        }
        if(target == 0) {
            result.add(new ArrayList<>(path));
        }

        for(int i = 0; i < candidates.length; i++) {
            path.add(candidates[i]);

            backtrack(candidates, target - candidates[i], i, path);

            path.remove(path.size() - 1);
        }
    }
}
