import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    List<List<Integer>> result= new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates.length==1 && candidates[0]!= target) return result;
        if(candidates==null) return result;
        List<Integer> combinationLst=new ArrayList<>();
        int idx=0;
        helper(candidates,idx, target,combinationLst);
        return result;
    }
    private void helper(int[] candidates,int idx, int target,List<Integer> combinationLst ){
        //base
        if(target==0 ){
            result.add(new ArrayList<>(combinationLst)); return;
        }
        if(target<0 || idx == candidates.length) return;
        combinationLst.add(candidates[idx]);
        //choose
        helper(candidates,idx,target-candidates[idx],combinationLst);
        combinationLst.remove(combinationLst.size()-1);
        //not choose
        helper(candidates,idx+1,target,combinationLst);

    }
}
