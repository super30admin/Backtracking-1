import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> set = new ArrayList<>();
        helper(candidates, target, 0, result, set);
        return result;
    }

    private void helper(int[] candidates, int target, int idx, List<List<Integer>> result,  List<Integer> set){
        //base
        if(idx==candidates.length || target < 0) return;
        if(target==0){
            result.add( new ArrayList<>(set));
            return;
        }
        //logic
        //choose
        set.add(candidates[idx]);
        helper(candidates, target-candidates[idx], idx, result, set);
        //backtracking
        set.remove(set.size()-1);
        //no choose
        helper(candidates, target, idx+1, result, set);
    }
}
