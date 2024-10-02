// Space complexity = O(m+n), 
// Time complexity = O(2^(m+n))
class Solution {
    List<List<Integer>> res= new ArrayList<>();
    List<Integer> path = new ArrayList<Integer>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        helper(candidates,0, 0, target );
        return res;        
    }
    
    private void helper(int[] candidates, int index, int sum,  int target ) {
        // base cases.
        if(index>= candidates.length || sum>target) {
            return;
        }
        if(sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }
        //  logic
        // case 1
        // take the same index and add the number to the resultSum.
        path.add(candidates[index]);
        helper(candidates, index, sum+candidates[index], target);
        // case2 
        // take the next index 
        path.remove(path.size()-1);
        helper(candidates, index+1, sum, target);
        return;
    }
}