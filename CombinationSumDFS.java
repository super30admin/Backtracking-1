// This is DFS + backtracking
// Space complexity = O(m+n), 
// Time complexity = O(2^(m+n))
// DFS
// Iteration
// Go down, down , down and then backtrack and then take the nex index as pivot.
class Solution {
    List<List<Integer>> res;
    List<Integer> path;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.res = new ArrayList<>();
        this.path = new ArrayList<>();
        // 0 is the pivot
        dfs(candidates, target, 0);
        return res;        
    }
    
    private void dfs(int[] candidates, int target, int pivot) {
        if(target ==0) {
            res.add(new ArrayList<>(path));
            return;
        }
        if(target<0) {
            return;            
        }
        for(int i=pivot;i< candidates.length;i++) {
            // action
            // add in the path.
            path.add(candidates[i]);
            // recurse
            dfs(candidates, target-candidates[i],i);
            // stack.pop()
            // backtrack
            // remove from the path
            path.remove(path.size()-1);
        }
    }
}