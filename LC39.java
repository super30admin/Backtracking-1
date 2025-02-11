// TC: O(2^target) as we are picking same element multiple times until we reach the target.
// SC: O(n)
// where n is the number of elements in the candidates array

import java.util.*;

public class LC39 {
    List<List<Integer>> res = new ArrayList<>();
    private void recurse(int i, int tar, int candidates[], List<Integer> list){
        // Base Case
        if(i<0) return;
        if(tar==0){
            res.add(new ArrayList<>(list));
            return;
        }
        //Logic
        recurse(i-1, tar, candidates, list);
        if(tar>=candidates[i]) {
            list.add(candidates[i]);
            recurse(i, tar-candidates[i], candidates, list);
            list.remove(list.size()-1); 
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates==null || candidates.length==0){
            return res;
        }
        int n = candidates.length;
        recurse(n-1, target, candidates, new ArrayList<>());
        return res;
    }
}
