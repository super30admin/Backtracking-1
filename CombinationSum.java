import java.util.ArrayList;
import java.util.List;

class CombinationSum {
    // 0-1 recursion
    public List<List<Integer>> recursionCombinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();

        if(candidates == null || candidates.length == 0){
            return result;
        }

        List<Integer> path = new ArrayList<>();

        helper(candidates, path, target, 0, result);
        return result;
    }

    private void helper(int[] candidates, List<Integer> path, int target, int idx, List<List<Integer>> list){
        // base
        if(target < 0 || idx == candidates.length){
            return;
        }

        if(target == 0){
            list.add(new ArrayList<>(path));
            return;
        }

        // logic
        // 0 case
        helper(candidates, path, target, idx+1, list);

        // 1 case
        path.add(candidates[idx]);
        helper(candidates, path, target-candidates[idx], idx, list);
        path.remove(path.size()-1);

    }

    public List<List<Integer>> forLoopCombinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();

        if(candidates == null || candidates.length == 0){
            return result;
        }

        List<Integer> path = new ArrayList<>();

        helper1(candidates, path, target, 0, result);
        return result;
    }

    private void helper1(int[] candidates, List<Integer> path, int target, int pivot, List<List<Integer>> list){
        // base
        if(target < 0){
            return;
        }

        if(target == 0){
            list.add(new ArrayList<>(path));
            return;
        }

        // logic
        for(int i = pivot; i < candidates.length; i++){
            path.add(candidates[i]);
            helper1(candidates, path, target-candidates[i], i, list);
            path.remove(path.size()-1);
        }
    }
}
