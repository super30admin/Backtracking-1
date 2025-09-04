import java.util.ArrayList;
import java.util.List;


// Idea is to use an exhaustive approach to generate all possible combinations by using choose&no-choose recursion
// To optimize on space we backtrack the path formed 

//Time Complexity: O(2^(m+n)); m => candidates length, n => target
//Space Complexity: O(n)
class CombinationSum{
       List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        helper(candidates,0,target, new ArrayList<>());
        return result;
    }

    public void helper(int[] candidates, int index, int target, List<Integer> path)
    {
        if(target==0)
        {
            result.add(new ArrayList<>(path));
            return;
        }
        if(target<0 || index==candidates.length) return;
        //No Choose
        helper(candidates,index+1,target,path);

        path.add(candidates[index]);

        helper(candidates,index,target-candidates[index],path);

        path.remove(path.size()-1);

    }
}