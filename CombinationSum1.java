//The approach here is to use for-loop based recursion to find the elements that add to the given target.
//We traverse through every node and when we find the target, we add that corresponding path to the result list.
//We use backtracking to remove the element from the path if it doesn't add up to the target.
//Time Complexity: O(2^(m+n)), where m and n are the target and number of elements in the array respectively
//Space Complexity: O(m+n) for recursive stack space
import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        helper(candidates, 0, path, target);
        return result;
    }

    private void helper(int[] candidates, int pivot, List<Integer> path, int target){
        //base
        if(target<0) return;
        if(target==0){
            result.add(new ArrayList<>(path));
        }
        
        //logic
        for(int i = pivot; i<candidates.length; i++){
            //action
            path.add(candidates[i]);
            //recurse
            helper(candidates, i, path, target-candidates[i]);
            //backtrack
            path.remove(path.size()-1);
        }
    }
}