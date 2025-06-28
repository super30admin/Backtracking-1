import java.util.*;
public class CombinationSum {
    static List<List<Integer>> sol = new ArrayList<>();
    static List<List<Integer>> combinationSum(int[] candidates, int target) {
        countPairs(candidates, target, 0, new ArrayList<Integer>());
        return sol;
    }
    static void countPairs(int[] candidates, int target, int ind , List<Integer> path) {
        if(target == 0) {
            sol.add(new ArrayList<>(path));
            return;
        }
        if(target < 0 || ind == candidates.length) return;

        path.add(candidates[ind]);
        countPairs(candidates, target - candidates[ind], ind, path);
        path.remove(path.size() - 1);
        countPairs(candidates, target, ind+1, path);

    }
    public static void main(String[] args) {
        int[] nums = {2,3,6,7};
        System.out.println(combinationSum(nums, 7));
    }

}
