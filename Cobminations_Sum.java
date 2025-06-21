/*
 * TC: O(2^(m+n)) m: lenght of candidates[], n: target.
 * SC: O(n) worst case the recursive stack has n function calls which is the target.
 */

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.result = new ArrayList<>();
        helper(candidates, 0, target, new ArrayList<>());
        return result;
    }

    private void helper(int[] candidates, int idx,int target, List<Integer> li){
        //base
        if(target == 0 ){
            result.add(new ArrayList<>(li));
            return;
        }
        if(idx == candidates.length || target < 0){
            return;
        }

        //not choose
        helper(candidates, idx + 1, target, li);

        //choose
        li.add(candidates[idx]);
        helper(candidates, idx, target - candidates[idx], li);

        //backtrack
        li.remove(li.size() - 1);
    }
}