//Time Complexity: O(2^m+n)
//Space Complexity: O(n)
public class CombinationSum {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.result = new ArrayList<>();
        helper(0, candidates, target, 0, new ArrayList<>());
        return result;
    }

    private void helper(int index, int[] candidates, int target, int sum, List<Integer> path) {
        if(sum > target || index == candidates.length) return;

        if(sum == target) {
            result.add(new ArrayList<>(path));
            return;
        }

        for(int i = index; i < candidates.length; i++) {
            path.add(candidates[i]);
            helper(i, candidates, target, sum + candidates[i],path);
            path.remove(path.size() - 1);
        }
    }
}
