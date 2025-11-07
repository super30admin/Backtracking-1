// Time Complexity :O(2^(m+n))
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        helper(candidates, target, 0,path,answer);
        return answer;
    }
    private void helper(int[] candidates, int target, int i,List<Integer> path,List<List<Integer>> answer  ){
        if(target < 0 || i == candidates.length) return;
        if(target == 0){
            answer.add(new ArrayList<>(path)); 
            return;
        }
        //nochoose
        helper(candidates, target, i+1, path, answer);
        //choose
        //action
        path.add(candidates[i]);
        //recurse
        helper(candidates, target - candidates[i], i, path, answer);
        //backtrack
        path.remove(path.size()-1); 
    }
}




// Time Complexity :O(2^(m+n))
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        helper(candidates, target, 0, path, answer);
        return answer;
    }

    private void helper(int[] candidates, int target, int pivot, List<Integer> path, List<List<Integer>> answer) {
        if (target < 0 || pivot == candidates.length)
            return;
        if (target == 0) {
            answer.add(new ArrayList<>(path));
            return;
        }
        for (int i = pivot; i < candidates.length; i++) {
            //action
            path.add(candidates[i]);
            //recurse
            helper(candidates, target - candidates[i], i, path, answer);
            //backtrack
            path.remove(path.size() - 1);
        }
    }
}