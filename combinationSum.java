//time
//space
//approach: Call recursively with CHOOSE and NOT CHOOSE scneraios and maintain a path variable which has the numbers which make the sum equals to target.

class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates.length == 0 || candidates == null) return result;
        helper(candidates, target, new ArrayList<>(), 0);
        return result;
    }
    private void helper(int[] candidates, int target, List<Integer> path, int idx) {
        //base
        if(target == 0) {
            result.add(new ArrayList<>(path));
            return;
        };
        if (target < 0 || idx == candidates.length) return;
        
        //logic
        //not choose
        helper(candidates, target, path, idx+1);
        
        //choose
        path.add(candidates[idx]);
        helper(candidates, target-candidates[idx], path, idx);
        path.remove(path.size() - 1);

    }
}
