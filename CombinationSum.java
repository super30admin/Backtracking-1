// Time Complexity : O(2^(m+n)) where m is the length of candidates ad n is the target value.
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Approach : I followed 0/1 recursion with backtracking and while the base condition is met, before storing the result we store a deep
// copy of it so that the rest of recursion happens without any issues. In no choose condition, index needs to be increased while in
// choose condition we dont have to increase index as it can have duplicates as well to reach the target sum. Once we find the result or we
// reach the end of the recursive function, we remove the last element in the path so that it can continue recursion.


class Solution {
    List<List<Integer>> result;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.result = new ArrayList<>();
        helper(candidates, target, 0, new ArrayList<>());
        return result;
    }

    private void helper(int[] candidates, int target, int index, List<Integer> path) {

        if (target == 0) {
            result.add(new ArrayList<>(path)); //copy of path
            return;
        }
        if (target < 0 || index == candidates.length) {
            return;
        }
        //no choose
        helper(candidates, target, index + 1, path);

        //choose
        path.add(candidates[index]); //add to path first
        helper(candidates, target - candidates[index], index, path);

        //backtracking
        path.remove(path.size() - 1);
    }
}



//for loop based recursion

class Solution {
    List<List<Integer>> result;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.result = new ArrayList<>();
        helper(candidates, target, 0, new ArrayList<>());
        return result;
    }

    private void helper(int[] candidates, int target, int index, List<Integer> path) {

        if (target == 0) {
            result.add(new ArrayList<>(path)); //copy of path
            return;
        }
        if (target < 0 || index == candidates.length) {
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            path.add(candidates[i]);
            helper(candidates, target - candidates[i], i, path);
            //backtracking
            path.remove(path.size() - 1);
        }

    }
}