import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum{
    List<List<Integer>> results = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> combinations = new LinkedList<>();  
        // helper(candidates, target, 0, combinations);  
        // backtrack(combinations, candidates, target, 0);
        forBacktrack(combinations, candidates, 0, target);
        return results;
    }

    //for based backtracking 
    public void forBacktrack(List<Integer> path, int[] candidates, int i, int target){
        if(target == 0){
            results.add(new ArrayList<>(path));
            return;
        }else if(i == candidates.length || target < 0){
            return;
        }

        for(int k = i; k < candidates.length; k++){
            path.add(candidates[k]);
            forBacktrack(path, candidates, k, target-candidates[k]);
            path.removeLast();
        }
    }

    //recursive solution 
    public void helper(int candidates[], int target, int i, List<Integer> path){
        //base 
        if(target == 0){
            results.add(new ArrayList<>(path));
            return;
        }else if(i == candidates.length || target < 0){
            return;
        }
        
        //logic 
        //dont choose 
        helper(candidates, target, i+1, new ArrayList<>(path));

        //choose
        path.add(candidates[i]);
        helper(candidates, target-candidates[i], i , new ArrayList<>(path));
    }

    public void backtrack(List<Integer> combinations, int[] candidates, int remain, int i){

        if(remain == 0){
            results.add(new ArrayList<Integer>(combinations));
            return;
        }else if(i == candidates.length || remain < 0){
            return;
        }

        //dont choose 
        backtrack(combinations, candidates, remain, i+1);

        //choose 
        combinations.add(candidates[i]);
        backtrack(combinations, candidates, remain-candidates[i], i);
        combinations.removeLast();
        
    }
}