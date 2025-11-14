/*
* Approach: 
 - The idea is to use 0/1 recursion to explore all subsets of the array
 - Once we have reached the end, add it to the result
 -TC: O(2^n * n)-> n for copying the path to the resultant array * choose/not choose for n elements so 2^n
 - SC: O(n) -> recursion stack space
 */
class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> subsets(int[] nums) {
        this.res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        helper(nums, path, 0);
        return res;
    }

    private void helper(int[] nums, List<Integer> path, int idx){
        //base
        if(idx == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        //logic

        //not choose
        helper(nums, path, idx + 1);
         //choose 
         //action
         path.add(nums[idx]);

         //recurse
         helper(nums, path, idx + 1);
         //backtrack
         path.remove(path.size() - 1);
    }
}