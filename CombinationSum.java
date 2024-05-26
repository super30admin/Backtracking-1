import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> result;
   public List<List<Integer>> combinationSum(int[] candidates, int target) {
       result = new ArrayList<>();
       if(candidates == null || candidates.length ==0)
       {
           return result;
       }
       helper(candidates, target, 0, new ArrayList<>());
       return result;
   }

   private void helper(int[] candidates, int target, int pivot, List<Integer> path)
   {
       //base
       if( target == 0)
       {
           result.add(new ArrayList<>(path));
           return;
       }

       if(target < 0) return;

       //logic
       for(int i = pivot; i< candidates.length; i++)
       {
           //List<Integer> li = new ArrayList<>(path);
           path.add(candidates[i]);
           helper(candidates, target - candidates[i], i, path);

           //backtrack
           path.remove(path.size()-1);
       }
   }
}