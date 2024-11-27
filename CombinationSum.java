// Time Complexity : O(n. 2^ m + n) where m+n is the height of the tree.m is levels, n is number of elements
// Space Complexity :O(n. 2 ^ m + n ) Recursive stack space is depth of tree 
import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target){
        this.result = new ArrayList<>();
        helper(candidates, target, 0, new ArrayList<>());
        return result;

    }

    private void helper(int[] candidates, int target, int i, List<Integer> path){
        // Base Case: if target is zero, combination sum is acheived
        if(target == 0) {
            result.add(new ArrayList<>(path)); // Add a copy of path to the result
        }

        // base case: if target is out of bounds
        if(target < 0 || i == candidates.length){
            return;
        }

        // Logic
        // No choose
        helper(candidates, target, i + 1, path); // In case of no choose, skip to the next candidate

        // Choose scenario
        path.add(candidates[i]); // Add the current candidate to the path
        helper(candidates, target - candidates[i], i, path); // Call recursively with the same candidate
        path.remove(path.size() - 1); // backtrack : remove the last added element
    }

    public static void main(String [] args){
        CombinationSum solution = new CombinationSum();
        int[] candidates = {2, 3, 6, 7};
        int target = 7;

        // Find all combinations
        List<List<Integer>> result = solution.combinationSum(candidates, target);

        // Print the result
        System.out.println("Combinations that sum to target:");
        for (List<Integer> combination : result) {
            System.out.println(combination);
        }

    }
}
