// Both backtracking methods - TC : O(2^n) SC O(n)
class Solution {

    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        if (candidates == null || candidates.length == 0) {
            return new ArrayList<>();
        }

        result = new ArrayList<>();
        recurse(candidates, 0, target, new ArrayList<>());
        return result;
    }

    // Preferred way
    // For loop based recursion
    private void recurse(int[] candidates, int index, int target, List<Integer> path) {

        if (target < 0) {
            return;
        }

        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        for(int i = index; i < candidates.length; ++i) {
            path.add(candidates[i]);
            recurse(candidates, i, target - candidates[i], path);
            path.remove(path.size() -1);
        }
    }

    // 0/1 or choose/ not choose based recursion
    private void recurse01(int[] candidates, int index, int target, List<Integer> path) {

        if (index == candidates.length || target < 0) {
            return;
        }

        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        
        // 0 or do not pick
        recurse01(candidates, index + 1, target, path);

        path.add(candidates[index]);
        // 1 case or pick case
        recurse01(candidates, index, target - candidates[index], path);

        path.remove(path.size() -1);
    }
}