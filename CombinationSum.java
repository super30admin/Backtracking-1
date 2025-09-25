//Time Complexity: O(2^(m+n))
//Space Complexity: O(h)
import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        final List<List<Integer>> output = new ArrayList<>();
        helper(candidates, target, 0, new ArrayList<>(), output);

        return output;
    }

    private void helper(int[] candidates, int target, int index, List<Integer> combination, List<List<Integer>> output) {
        //base
        if (target < 0 || index == candidates.length) return;
        if (target == 0) {
            output.add(new ArrayList<>(combination));
            return;
        }

        //logic
        helper(candidates, target, index + 1, combination, output);
        combination.add(candidates[index]);

        helper(candidates, target - candidates[index], index, combination, output);
        combination.removeLast();
    }

    public static void main(String[] args) {
        final CombinationSum combinationSum = new CombinationSum();
        System.out.println(combinationSum.combinationSum(new int[] {2, 3, 6, 7}, 7)); //[2, 2, 3], [7]
        System.out.println(combinationSum.combinationSum(new int[] {2, 3, 5}, 8)); //[3, 5], [2, 2, 2, 2], [2, 3, 3]
    }
}
