import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
 * TIME COMPLEXITY (both approaches):
 * Exponential in the worst case (number of combinations grows quickly).
 * Rough intuition: explore many branches until target is reduced to 0.
 *
 * SPACE COMPLEXITY:
 * - Recursion depth: O(target / minCandidate)
 * - Path size: O(target / minCandidate)
 * - Output storage: can be large depending on number of valid combinations.
 */
public class CombinationSum {

    // Stores all valid combinations
    private List<List<Integer>> result;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.result = new ArrayList<>();
        // Pick ONE approach
        forwardTrackingHelper(candidates, target, 0, new ArrayList<>()); // for-loop based
        //recursionChooseSkipHelper(candidates, target, 0, new ArrayList<>()); // recursion choose/skip based

        return result;
    }
    //1) FOR-LOOP BACKTRACKING

    private void forwardTrackingHelper(int[] candidates, int target, int start, List<Integer> path) {
        // Found exact target
        if (target < 0 || start == candidates.length) return;
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            int val = candidates[i];
            // Choose
            List<Integer> newPath = new ArrayList<>(path);
            newPath.add(val);
            // Reuse allowed => pass i (not i+1)
            forwardTrackingHelper(candidates, target - val, i, newPath);

        }
    }
    // 2) RECURSION (CHOOSE / SKIP)
    private void recursionChooseSkipHelper(int[] candidates, int target, int start, List<Integer> path) {
        // Success
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        // Fail / stop
        if (target < 0 || start == candidates.length) {
            return;
        }

        // SKIP current candidate => move to next index
        recursionChooseSkipHelper(candidates, target, start + 1, path);

        // CHOOSE current candidate => stay on same index (reuse allowed)
        path.add(candidates[start]);
        recursionChooseSkipHelper(candidates, target - candidates[start], start, path);
        path.remove(path.size() - 1); // backtrack
    }
    // TESTS
    public static void main(String[] args) {
        CombinationSum sol = new CombinationSum();

        int[] candidates1 = {2, 3, 6, 7};
        int target1 = 7;
        System.out.println("Input: " + Arrays.toString(candidates1) + ", target=" + target1);
        System.out.println("Output: " + sol.combinationSum(candidates1, target1));

        int[] candidates2 = {2, 3, 5};
        int target2 = 8;
        System.out.println("\nInput: " + Arrays.toString(candidates2) + ", target=" + target2);
        System.out.println("Output: " + sol.combinationSum(candidates2, target2));

        int[] candidates3 = {4, 5};
        int target3 = 3;
        System.out.println("\nInput: " + Arrays.toString(candidates3) + ", target=" + target3);
        System.out.println("Output: " + sol.combinationSum(candidates3, target3));
    }

}
