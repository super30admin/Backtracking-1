/* Time Complexity : O(2^(m+n)) 
 *  m - length of the array 
 *  n - max length of the path */
/* Space Complexity : O(n) */
// Did this code successfully run on Leetcode : Yes 
// Any problem you faced while coding this :

//backtrack solution

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        helper(candidates, target, 0, new ArrayList<>());
        return result;
    }

    private void helper(int[] candidates, int target, int index, List<Integer> path){
        //base condition
        if(target < 0 || candidates.length == index) return;
        if(target == 0){
            result.add(new ArrayList<>(path));
            return;
        }
        
        //logic
        //no choose
        helper(candidates, target, index + 1, new ArrayList<>(path));

        //choose
        //action        
        path.add(candidates[index]);
        //recurse
        helper(candidates, target - candidates[index], index, new ArrayList<>(path));
        //backtrack
        path.remove(path.size() - 1);

        
    }
}

/*

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        helper(candidates, target, 0, new ArrayList<>());
        return result;
    }

    private void helper(int[] candidates, int target, int index, List<Integer> path){
        //base condition
        if(target < 0 || candidates.length == index) return;
        if(target == 0){
            result.add(new ArrayList<>(path));
            return;
        }
        
        //logic
        //choose
        //action
        List<Integer> pathCp = new ArrayList<>(path);
        pathCp.add(candidates[index]);
        //recurse
        helper(candidates, target - candidates[index], index, pathCp);

        //no choose
        helper(candidates, target, index + 1, new ArrayList<>(path));
        
    }
}

*/