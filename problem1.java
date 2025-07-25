// Time Complexity : O(n^(target/min value))
// Space Complexity : O(target/min candidate) - we can have a max depth of target/min value 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach : I iterated over every element and tried adding it to the list. If the target becomes 0, I added the current list to the result.
// If the target becomes negative, I returned. I used a for loop to iterate over the candidates starting from the current index to avoid duplicates.
// I also used a backtracking approach to remove the last added element after the recursive call.

class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        helper(candidates, target, new ArrayList<>(), 0);
        return res;
    }

    public void helper(int[] arr, int target, List<Integer> list, int idx){
        if(target==0) res.add(new ArrayList<>(list));
        if(target<=0) return;
        for(int i = idx; i<arr.length;i++){
            list.add(arr[i]);
            helper(arr, target-arr[i], list, idx++);
            list.remove(list.size()-1);
        }
    }
}