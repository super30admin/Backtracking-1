// Time Complexity : O((m+n)2^(m+n)) where m is the no of elements in the array and n is the target
// Space Complexity : O(2^(m+n)) recursive stack space.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
import java.util.*;
class Solution {
    private void dfs(int[] candidates, int index, int target, List<Integer> path, List<List<Integer>> result)
    {
        if(target == 0)
        {
            result.add(new ArrayList<>(path));
            return;
        }

        for(int i=index; i<candidates.length && target>=candidates[i]; i++)
        {
            path.add(candidates[i]);
            dfs(candidates, i, target-candidates[i], path, result);
            path.remove(path.size()-1);
        }
        return;
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, 0, target, new ArrayList<>(), result);
        return result;
    }
}