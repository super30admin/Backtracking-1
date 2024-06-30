import java.util.ArrayList;
import java.util.List;

//Approach : for loop based recursion
//time - exponential
//Space - O(n)
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();

        if(candidates == null || candidates.length == 0) {
            return result;
        }
        recurse(candidates, target, 0, new ArrayList<>());

        return result;
    }
    private void recurse(int[] candidates, int target, int index, List<Integer> path) {
        //base case
        if(target < 0) {
            return;
        }
        if(target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        //for loop based recursion
        for(int i=index; i<candidates.length; i++) {
            //action
            path.add(candidates[i]);
            //recurse
            recurse(candidates, target - candidates[i], i, path);
            //backtrack
            path.remove(path.size()-1);
        }
    }
}