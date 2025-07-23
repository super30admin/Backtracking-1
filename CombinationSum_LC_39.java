import java.util.ArrayList;
import java.util.List;

/*
DFS + Backtracking
Time Complexity - O(2 ^ target * N) -> It’s because for subsets (like subset sum problems), where each element can either be included or not, you get 2 ^ N here we go till we find target
Space Complexity - O(target)+O(outputsize)
Did this code successfully run on Leetcode :  Yes
Any problem you faced while coding this :  No
*/
public class CombinationSum_LC_39 {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.result = new ArrayList<>();
        dfs(candidates, target,0,new ArrayList<>());
        return result;
    }
    private void dfs(int[] candidates, int target,int idx, List<Integer> output) {
        //base
        if(target < 0) return;
        if(target == 0){
            result.add(new ArrayList<>(output));
            return;
        }
        //logic
        for(int i = idx; i < candidates.length; i++) {
            output.add(candidates[i]);
            //Explore
            dfs(candidates, target-candidates[i], i, output );
            //unchoose
            output.remove(output.size() -1);
        }
    }
}

/* Brute force
DFS with only recusion (no Backtracking)
Time Complexity - O(2 ^ target * N)
Space Complexity - O(target)+O(output size) + At each level, you create a new copy of output (list = new ArrayList<>(output)), which costs O(d) where d is the current depth but since those lists are garbage-collected once recursion returns, this does not grow asymptotically beyond the stack and output.
*/
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.result = new ArrayList<>();
        dfs(candidates, target,0,new ArrayList<>());
        return result;
    }
    private void dfs(int[] candidates, int target,int idx, List<Integer> output) {
        //base
        if(target < 0) return;
        if(target == 0){
            result.add(new ArrayList<>(output));
            return;
        }
        //logic
        for(int i = idx; i < candidates.length; i++) {
            List<Integer> list = new ArrayList<>(output);
            list.add(candidates[i]);
            //Explore
            dfs(candidates, target-candidates[i], i, list );
            //unchoose no needed as we are creating new list all the time

        }
    }
}
