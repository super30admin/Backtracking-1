/*
    LC - 39. Combination Sum
    TC - O(N^T)
        At each level of recursion, we have N choices (where N is the number of candidates).
        This leads to a recursion tree with a branching factor of N and a maximum depth of T.
    SC - O(T) where T is the target.
        Recursion stack: The maximum depth of the recursion is O(T), where T is the target sum. This is because in the worst case, we might have a candidate with value 1, and we would need to make T recursive calls to reach the target.
        Path list: At any given time, the path list can contain at most T elements. This is because the sum of elements in the path cannot exceed the target T.
        Result list: The space used by the result list is not counted in auxiliary space complexity as it's part of the output.
    Approach -
        using for loop based backtrack approach
            this is also include pick no pick recursion. but different recursive tree.
            for loop handles no pick case. so we have to write only pick case inside the for loop.
*/

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates == null || candidates.length == 0) {
            return new ArrayList<>();
        }
        result = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>());
        return result;
    }
    public void backtrack(int[] candidates, int target, int index, List<Integer> path) {
        // base
        if(target < 0 || index == candidates.length) {
            return;
        }

        if(target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        // logic
        for(int i = index; i<candidates.length; i++) {
            path.add(candidates[i]);
            backtrack(candidates, target - candidates[i], i, path);
            path.remove(path.size() - 1);
        }
    }
}