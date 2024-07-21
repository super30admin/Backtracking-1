import java.util.*;

class Solution {
    // Tc: O(n^target/min(candidates)) Sc: O(target/min(candidates))
    List<List<Integer>> res;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        res = new ArrayList<>();
        helper(candidates, target, 0, new ArrayList<>());
        return res;
    }

    private void helper(int[] candidates, int target, int index, List<Integer> path) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;

        }

        if (target < 0)
            return;

        for (int i = index; i < candidates.length; i++) {
            path.add(candidates[i]);
            helper(candidates, target - candidates[i], i, path);
            path.remove(path.size() - 1);
        }
    }
}

/*
 * 
 * class Solution {
 * List<List<Integer>> ans = new ArrayList<>();
 * 
 * public List<List<Integer>> combinationSum(int[] candidates, int target) {
 * helper(candidates, target, 0, new ArrayList<>());
 * return ans;
 * }
 * 
 * private void helper(int[] candidates, int target, int index, List<Integer>
 * path) {
 * 
 * if (target < 0 || index >= candidates.length)
 * return;
 * 
 * if (target == 0) {
 * ans.add(new ArrayList<>(path));
 * return;
 * }
 * 
 * path.add(candidates[index]);
 * helper(candidates, target - candidates[index], index, path);
 * path.remove(path.size() - 1);
 * helper(candidates, target, index + 1, path);
 * }
 * 
 * }
 * 
 * class Solution {
 * List<List<Integer>> ans = new ArrayList<>();
 * 
 * public List<List<Integer>> combinationSum(int[] candidates, int target) {
 * helper(candidates, target, 0, new ArrayList<>());
 * return ans;
 * }
 * 
 * private void helper(int[] candidates, int target, int index, List<Integer>
 * path) {
 * if (target < 0)
 * return;
 * if (index == candidates.length) {
 * if (target == 0) {
 * ans.add(new ArrayList<>(path));
 * }
 * return;
 * }
 * 
 * List<Integer> newPath = new ArrayList<>(path);
 * newPath.add(candidates[index]);
 * helper(candidates, target - candidates[index], index, newPath);
 * 
 * helper(candidates, target, index + 1, path);
 * }
 * }
 * 
 */