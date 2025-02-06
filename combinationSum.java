import java.util.ArrayList;
import java.util.List;

public class combinationSum {
}
//without using backtracking 0/1 recursion
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates == null || candidates.length == 0){
            return new ArrayList<>();
        }
        result = new ArrayList<> ();
        recurse(candidates,target,0,new ArrayList<>());
        return result;
    }
    private void recurse(int[] candidates, int target, int index, List<Integer> path){
        //base
        if(target<0 || index == candidates.length){
            return;
        }
        if(target == 0){
            result.add(path);
            return;
        }
        //logic
        //don't pick
        recurse(candidates,target,index+1,new ArrayList<>(path));
        //pick
        path.add(candidates[index]);
        recurse(candidates,target-candidates[index],index,new ArrayList<>(path));
    }
}

//Using recursion with backtracking
class recursionWithBackTracking {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates == null || candidates.length == 0){
            return new ArrayList<> ();
        }
        result = new ArrayList<> ();
        recurse(candidates,target,0,new ArrayList<>());
        return result;
    }
    private void recurse(int[] candidates, int target, int index, List<Integer> path){
        //base
        if(target<0 || index == candidates.length){
            return;
        }
        if(target == 0){
            result.add(new ArrayList<>(path));
            return;
        }
        //logic
        //don't pick
        recurse(candidates,target,index+1,path);
        //pick
        path.add(candidates[index]);
        recurse(candidates,target-candidates[index],index,path);
        path.remove(path.size()-1);
    }
}
//Iterative approach with backtracking
class iterativeWithBackTracking {
    List<List<Integer>> result;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return new ArrayList<>();
        }
        result = new ArrayList<>();
        recurse(candidates, target, 0, new ArrayList<>());
        return result;
    }

    private void recurse(int[] candidates, int target, int index, List<Integer> path) {
        // base
        if (target < 0) {
            return;
        }
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        // logic
        for (int i = index; i < candidates.length; i++) {
            path.add(candidates[i]);
            recurse(candidates, target - candidates[i], i, path);
            path.remove(path.size() - 1);
        }
    }
}