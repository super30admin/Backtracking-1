import java.util.*;

class Problem1 {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        recurHelper(candidates, target,0,new ArrayList<>());
        return result;
    }

    //TC:2^(n+m)
    //SC:2^(n+m)
    public void recurHelper(int[] candidates, int target,int i,List<Integer> path) {
        //base case
        if(target == 0){
            this.result.add(new ArrayList<>(path));
        }

        if(i==candidates.length || target <0){
            return;
        }
        int pivot = i;
        for(int j = pivot;j<candidates.length;j++){
            path.add(candidates[j]);
            recurHelper(candidates, target - candidates[j],j,path);
            path.remove(path.size()-1);

        }
    }
}