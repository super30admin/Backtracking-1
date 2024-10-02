// This is DFS without backtracking
// so create a new list.
// Space complexity = O(m+n), 
// Time complexity = O(2^(m+n))
// DFS
// Iteration
// Go down, down , down and then backtrack and then take the nex index as pivot.
class Solution {
    List<List<Integer>> res;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        // 0 is the pivot
        dfs(candidates, target, 0, path);
        return res;        
    }
    
    private void dfs(int[] candidates, int target, int pivot, List<Integer> path) {
        if(target ==0) {
            res.add(path);
            return;
        }
        if(target<0) {
            return;            
        }
        for(int i=pivot;i< candidates.length;i++) {
            // action
            // add in the path.
            // create a deep copy of the papa and iterate on the child list.
            List<Integer> lst = new ArrayList<>(path);
            lst.add(candidates[i]);
            // recurse
            dfs(candidates, target-candidates[i],i, lst);
            // stack.pop()
        }
    }
}