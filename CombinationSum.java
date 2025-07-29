// Time Complexity : O(2^(m+n)) where m = target
// Space Complexity : O(m+n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
// Approach : for each element in array we have choice- either take it or not. If we choose to take it, reduce target by num,
/// else go to next number. Repeat while backtracking target and we go back from recursive call. If target becomes zero
/// add to result

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Set<List<Integer>> res = new HashSet<>();
        ArrayList<Integer> path = new ArrayList<>();
        helper(candidates, target, 0, res, path);
        return new ArrayList<>(res);
    }
    public void helper(int[] candidates, int target, int i, Set<List<Integer>> res, ArrayList<Integer> path){
        if(target == 0){
            res.add(new ArrayList<>(path));
            return;
        }
        if(i>=candidates.length || target<0){
            return;
        }
        helper(candidates, target, i+1, res, path);
        path.add(candidates[i]);
        helper(candidates, target-candidates[i], i, res, path);
        path.remove(path.size()-1);
    }
}