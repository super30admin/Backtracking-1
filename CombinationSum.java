import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    //for loop based recursion
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates==null || candidates.length==0) {
            return new ArrayList<>();
        }
        result= new ArrayList<>();
        recurse(candidates, target, 0,new ArrayList<>());
        return result;
    }
    private void recurse(int[] candidates, int target, int index, List<Integer>path){
        //base
        if(target <0){
            return ;
        }
        if(target == 0){
            result.add(path);
        }

        //logic
        for(int i=index; i< candidates.length;i++){
            List<Integer> newList = new ArrayList<>(path);
            newList.add(candidates[i]);
            recurse(candidates, target-candidates[i],i, newList);
        }
    }
}
