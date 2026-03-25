import java.util.*;

//O(2 ^ (m+n)) time where m is the candidates length and n is the target
// O(n) space
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(candidates, 0, target, ans, new ArrayList<>());
        return ans;
    }

    private void helper(int[] candidates, int i, int target, List<List<Integer>> ans, List<Integer> path) {
        if (i == candidates.length || target < 0) return;

        if (target == 0) {
            ans.add(new ArrayList<>(path));
            return;
        }

        //choose i
        path.add(candidates[i]);
        helper(candidates, i, target-candidates[i], ans, path);

        //backtrack
        path.remove(path.size()-1);

        //skip i
        helper(candidates, i+1, target, ans, path);
    }
}