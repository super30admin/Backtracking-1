import java.util.ArrayList;
import java.util.List;

// Time Complexity : O(2^(m+n)) , m=target, n=size of array
// Space Complexity : O(m+n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no
/*
 It uses a backtracking approach to explore all possible combinations.
 The helper function recursively tries to include or exclude each candidate number,
 adjusting the target accordingly. If the target reaches zero,
 it adds the current combination to the result.
 The function ensures no repeated combinations by only moving forward in the candidate list
 during recursion.
* */

public class CombinationSum {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result=new ArrayList<>();

        helper(candidates,0,target,new ArrayList<Integer>());

        return result;
    }

    private void helper(int[] candidates,int index,int target,List<Integer> path)
    {
        if(target<0 || index==candidates.length)
        {
            return;
        }
        if(target==0)
        {
            result.add(new ArrayList<>(path));
            return;
        }
        path.add(candidates[index]);
        helper(candidates,index,target - candidates[index],path);
        path.remove(path.size()-1);
        helper(candidates,index+1,target,path);
    }
}
