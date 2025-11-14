/*
* Approach1: The problem is similar to coin change. So go exhaustive and explore all options
- The idea is to do a 0/1 recursion -> choose/not choose
- TC: O(2^m+n) -> two input variables, candidates of length n and target
- SC: O(n) -> path array
 */
class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        helper(candidates, 0, path, target);
        return res;
    }

    private void helper(int[] candidates, int idx, List<Integer> path, int target){
        //base
        // if we have selected more candidates then required or idx goes out of bound
        if(target < 0 || idx >= candidates.length)
            return;
        
        //once we have a combination that is equal to the target, add that to the result
        if(target == 0){
            //create a deep copy of the path before adding it to the result as we are using the same reference of the path
            res.add(new ArrayList<>(path));
            return;
        }
            
        //logic

        //0-> not choose
        helper(candidates, idx + 1, path, target);
        //1-> choose

        //add element in the path

        //action
        path.add(candidates[idx]);
        //recurse
        helper(candidates, idx, path, target - candidates[idx]);
        //backtrack
        path.remove(path.size() - 1);
    }
}