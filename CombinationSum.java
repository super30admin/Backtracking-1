/*
Time Complexity : O(2^T), T is target value
Space Complexity : O(T)
Did this code successfully run on Leetcode : yes
Any problem you faced while coding this : no
Approach :
We need to use recursion with backtracking to find all possible combinations that sums to target. In 0/1 recursion,
we add a number to the path and reduce the target, if the target become equal to 0, it is valid combination and is added to result.
If not, remove the number from the path after recursion is done and recurse without choose this number.
*/
import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        combinationRecursion(candidates, target, 0, new ArrayList<>(), result);
      //  combination01Recursion(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    private void combination01Recursion(int[] candidates, int target,int index, ArrayList<Integer> path, List<List<Integer>> result) {
        if(index == candidates.length) return;
        if(target < 0) return;
        if(target == 0){
            result.add(new ArrayList<>(path));
            return;
        }
        // not choose
        combination01Recursion(candidates, target, index+1, path, result);

        // choose
        path.add(candidates[index]);
        combination01Recursion(candidates, target-candidates[index], index, path, result);
        path.remove(path.size()-1);
    }

    // Time Complexity : O(N^D), where N is size of candidates array and D is depth of tree, could be T in worst case O(N^T)
    // Space Complexity : O(T),
    private void combinationRecursion(int[] candidates, int target, int pivot, ArrayList<Integer> path, List<List<Integer>> result) {
        if(pivot == candidates.length) return;
        if(target < 0) return;
        if(target == 0){
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = pivot; i < candidates.length; i++){
            combinationRecursion(candidates, target, i+1, path, result);

            path.add(candidates[i]);
            combinationRecursion(candidates, target-candidates[i], i, path, result);
            path.remove(path.size()-1);
        }
    }
}
