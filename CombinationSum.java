
class Solution {
    //Time complexity:O(2^n)
    //Space complexity:O(n)
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList <> ();
        List<Integer> subset  = new ArrayList<>();
        dfs (nums, target, ans, subset,0);
        return ans;
    }

    public void dfs (int[] nums, int target, List<List<Integer>> ans, List<Integer> subset, int i){
        if (target == 0){
        ans.add (new ArrayList<Integer>(subset));
        return;
        }

        if (target < 0 || i >= nums.length)
        return;

            subset.add(nums[i]);
            dfs (nums, target - nums[i], ans, subset, i);
            subset.remove(subset.size()-1);
            dfs (nums, target, ans, subset, i+1);

    }
}
