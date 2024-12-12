// Time Complexity :O(2 pow t)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : nothing

import java.util.ArrayList;
import java.util.List;

public class Problem1 {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        helper(candidates, target, 0,new ArrayList<>());
        return res;
    }

    private void helper(int[] candidates,int target, int i, List<Integer> path){
        if(target==0){
            res.add(new ArrayList<>(path));
            return;
        }
        if(i==candidates.length || target<0){
            return;
        }

        path.add(candidates[i]);
        helper(candidates,target-candidates[i],i,path);
        path.remove(path.size()-1);
        helper(candidates,target,i+1,path);
    }

}
