// Combination Sum (https://leetcode.com/problems/combination-sum/)

// Time Complexity : O(2^(m+n))
// Space Complexity : O(m + n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach in three sentences only
/*
 * Here, there are 2 cases choosing and not choosing. In not choosing case, just move to the next number. In choosing case, be
 * with same number and pass the target-number as target number. When the target is 0 add that path to the result. Finally
 * return result.
 */

/* 0-1 backtracking */
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        helper(candidates, 0, path, target);
        return result;
    }
    private void helper(int[] candidates, int idx, List<Integer> path, int target){
        //base
        if(target == 0){
            result.add(new ArrayList<>(path));
            return;
        }
        if(target<0 || idx == candidates.length){
            return;
        }
        //logic
        //0
        helper(candidates, idx+1, path, target);
        //1
        path.add(candidates[idx]);
        helper(candidates, idx, path, target-candidates[idx]);
        path.remove(path.size()-1);

    }
}

/* For loop based recursion */
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        helper(candidates, 0, path, target);
        return result;
    }
    private void helper(int[] candidates, int pivot, List<Integer> path, int target){
        //base
        if(target == 0){
            result.add(new ArrayList<>(path));
            return;
        }
        if(target<0) return;
        //logic
        for(int i = pivot; i< candidates.length;i++){
            path.add(candidates[i]);
            helper(candidates, i, path, target-candidates[i]);
            path.remove(path.size()-1);
        }

    }
}