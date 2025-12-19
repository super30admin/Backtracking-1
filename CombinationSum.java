import java.util.ArrayList;
import java.util.List;
class CombinationSum {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // recursion - with backtracking
        result = new ArrayList<>();
        combineSumHelper(candidates, target, 0, new ArrayList<>());
        return result;
    }

    // private void combineSumHelper(int[] candidates, int target, int idx, List<Integer> path)
    private void combineSumHelper(int[] candidates, int target, int pivot, List<Integer> path)
    {
        // // a. recurse + backtrack
        // // base
        // if(target == 0)
        // {
        //     result.add(new ArrayList<>(path));
        //     return;
        // }

        // if(target < 0 || idx == candidates.length)
        // {
        //     return;
        // }

        // // logic
        // // not choose
        // // no action here for not choose
        // //recurse
        // combineSumHelper(candidates, target, idx+1, path);

        // // choose
        // // action
        // path.add(candidates[idx]);
        // // recurse
        // combineSumHelper(candidates, target - candidates[idx], idx, path);

        // //backtrack
        // path.remove(path.size() - 1);

        // b. for loop + recurse + backtrack
        // base case
        if(target == 0)
        {
            result.add(new ArrayList<>(path));
            return;
        }
        if(target < 0 || pivot == candidates.length)
        {
            return;
        }

        // logic
        // action
        for(int i = pivot; i < candidates.length; i++)
        {
        // recurse
            path.add(candidates[i]);
            combineSumHelper(candidates, target - candidates[i], i, path);
        // backtrack
            path.remove(path.size() - 1);
        }
    }
}