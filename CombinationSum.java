// 0-1 recursion or choose/notChoose recursion
class Solution {

    List<List<Integer>> result;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.result = new ArrayList<>();
        helper(candidates, target, new ArrayList<>(), 0);
        return result;
    }

    private void helper (int[] candidates, int target, List<Integer> path, int index) {

        // base
        if (target == 0) {
            result.add(new ArrayList<>(path)); // copy
            return;
        }

        if (target < 0 || candidates.length == index) {
            return;
        }

        // logic

        // not choose
        helper(candidates, target, path, index + 1);

        // choose
        path.add(candidates[index]);
        helper(candidates, target - candidates[index], path, index);
        path.remove(path.size() - 1);
    }
}

// for loop based recursion
class Solution {

    List<List<Integer>> result;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.result = new ArrayList<>();
        helper(candidates, target, new ArrayList<>(), 0);
        return result;
    }

    private void helper (int[] candidates, int target, List<Integer> path, int pivot) {

        // base
        if (target == 0) {
            result.add(new ArrayList<>(path)); // copy
            return;
        }

        if (target < 0) {
            return;
        }

        // logic
        for (int i = pivot; i < candidates.length; i++) {

            //action
            path.add(candidates[i]);

            //recurse
            helper(candidates, target - candidates[i], path, i);

            //backtrack
            path.remove(path.size() - 1);
        }
        
    }
}

// Time = O(2^(M+N))
// Space = O(N)