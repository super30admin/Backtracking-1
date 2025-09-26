// Time Complexity : O(2 ^ (m+n)) where m is the candidates length and n is the target
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//Using for loop based recursion we apprach the problem
//At each loop we choose the element and update the target and backtrack the path
//once the target becomes zero we add the path to the res
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        helper(candidates, 0, path, target, res);
        return res;
        
    }

    private void helper(int[] candidates, int pivot, List<Integer> path, int target, List<List<Integer>> res) {
        //base
        if (target < 0) return;
        if (target == 0) {
            //found a path
            res.add(new ArrayList<>(path));
            return;
        }
        //logic
        for(int i = pivot; i < candidates.length; i++) {
            //action
            path.add(candidates[i]);
            //recurse
            helper(candidates, i, path, target-candidates[i], res);
            //backtrack
            path.remove(path.size() - 1);
        }
        
    }
}
