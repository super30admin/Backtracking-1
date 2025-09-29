// Time Complexity : O(m^2 * n^2) where m is the number of elements in candidates and n is the target
// Space Complexity : O(h) where h is the height of the tree
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

/**
 * Using iterative approach where we select a pivot and start the index from the pivot to get the combinations of all numbers.
 * We are starting the iteration from the pivot because the number can be re-used again.
 * <p>
 * Base case 1 is when target becomes less than 0. The target number cannot be achieved using the current path so we return.
 * Base case 2 is when target becomes 0. The target number is achieved so we add the current path to the result.
 */
class IterativeSolution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        helper(candidates, 0, target, new ArrayList<>(), result);
        return result;
    }

    private void helper(int[] candidates, int pivot, int target, List<Integer> path, List<List<Integer>> result) {
        //base
        if (target < 0)
            return;
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = pivot; i < candidates.length; i++) {
            path.add(candidates[i]);
            helper(candidates, i, target - candidates[i], path, result);
            // backtracking
            path.remove(path.size() - 1);
        }

    }
}

// Time Complexity : O(m^2 * n^2) where m is the number of elements in candidates and n is the target
// Space Complexity : O(h) where h is the height of the tree
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

/**
 * Using recursive approach where we do the 0 and 1 case where we do not choose or choose the current element.
 * When we select the element, we recursively try to find the target sum. Once that recursion is complete, we backtrack the current element from the recursion.
 * <p>
 * Base case 1 is when the target becomes negative or we reach the end of all elements in the array. We return since target was not found
 * Base case 2 is when the target becomes 0. We add the current path to the result.
 */
class RecursiveSolution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        helper(candidates, 0, target, new ArrayList<>(), result);
        return result;
    }

    private void helper(int[] candidates, int idx, int target, List<Integer> path, List<List<Integer>> result) {
        //base
        if (target < 0 || idx == candidates.length)
            return;
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        // 0
        helper(candidates, idx + 1, target, path, result);

        // 1
        path.add(candidates[idx]);
        helper(candidates, idx, target - candidates[idx], path, result);

        path.remove(path.size() - 1);

    }
}