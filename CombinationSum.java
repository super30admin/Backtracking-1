// Time complexity - O(2^n)
// Space Complexity - O(n)
// Solved on leetcode - yes
// did you face any issues - No
// The algorithm uses backtracking to explore all possible combinations of candidates that sum up to the target. At each step, it either chooses the current element (allowing repeated use by staying at the same index) or skips it (by moving to the next index). When the target becomes zero, the current path is added to the result list, and the function backtracks to explore other possibilities.
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.result = new ArrayList<>();
        helper(candidates, target,0, new ArrayList<>());
        return result;
    }

    public void helper(int[] candidates, int target, int index, List<Integer> path) {
        //base
    if(target<0 || index == candidates.length) return;
    if(target == 0) {
        result.add(new ArrayList<>(path));
        return;
    }
        //logic
        //not choose
        helper(candidates, target, index+1, path);
        // choose 
        path.add(candidates[index]);
        helper(candidates, target-candidates[index], index, path);
        path.remove(path.size()-1);
        
    }
}
