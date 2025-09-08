// Time Complexity : O(2^(m+n)) where m is the target and n is the number of candidates
// Space Complexity : O(m+n) for the recursion stack (choosing 1 for m(target) times and not choosing n times)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Using 01 recursion, we choose or dont choose an index i with the base case of runnning out of the array or reaching negative target.
// In for loop based recursion we keep choosing the index starting from pivot till the negative target and switch to the next index in the iteration.
// Both results in same time and space complexity. 01 is higher in depth whereas for loop is higher in breadth.

class Solution {

    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList();
        helper(candidates, 0, target, new ArrayList());
        return result;
    }

    private void helper(int[] candidates, int i, int target, List<Integer> path){
        if(i == candidates.length || target<0) return;
        if(target == 0){
            result.add(new ArrayList(path));
            return;
        }

        helper(candidates, i+1, target, path);
        path.add(candidates[i]);
        helper(candidates, i, target-candidates[i], path);
        path.remove(path.size()-1);
    }

    private void helperForLoopBased(int[] candidates, int pivot, int target, List<Integer> path){
        if(target<0) return;
        if(target == 0){
            result.add(new ArrayList(path));
            return;
        }

        for(int i=pivot;i<candidates.length;i++){
            path.add(candidates[i]);
            helper(candidates,i,target-candidates[i],path);
            path.remove(path.size()-1);
        }
    }
}