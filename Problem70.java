// Time Complexity : O(2 ^ (m+n)) where m is the candidates length and n is the target
// Space Complexity : O(n) 

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        helper(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void helper(int[] candidates, int target, int pivot, List<Integer> path, List<List<Integer>> result) {
        //base
        if (target < 0 || candidates.length == pivot) {
            return;
        }

        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = pivot; i < candidates.length; i++) {
            //action
            path.add(candidates[i]);
            //recurse
            helper(candidates, target - candidates[i], i, path, result);
            //backtrack
            path.remove(path.size() - 1);
        }
    }
}