class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates.length == 0) {
            return result;
        }
        List<Integer> list = new ArrayList<>();
        backtrack(candidates, target, 0, list);
        return result;
    }
    private void backtrack(int[] candidates, int target, int index, List<Integer> list) {
        if (target == 0) {
            result.add(new ArrayList<>(list));
            return;
        }
        if (target <0) {
            return;
        }
        for (int i=index;i<candidates.length;i++) {
            list.add(candidates[i]);
            backtrack(candidates, target-candidates[i], i, list);
            list.remove(list.size()-1);
        }
    }
}
