 // Time Complexity : O(2^n)
// Space Complexity : 1 - O(n^2), 2, 3 - O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

// Recursion
/*class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates == null || candidates.length == 0) return new ArrayList<>();
        result = new ArrayList<>();
        helper(candidates, target, 0, new ArrayList<>());
        return result;
    }

    void helper(int[] candidates, int target, int index, List<Integer> path) {
        // Base
        if(target<0 || index == candidates.length) return;
        if(target == 0) {
            result.add(path);
            return;
        }
        // Logic
        // 0 or do not choose
        helper(candidates, target, index+1, new ArrayList<>(path));
        // 1 or choose
        path.add(candidates[index]);
        helper(candidates, target-candidates[index], index, new ArrayList<>(path));
        // Create a seperate arrayList at every recursive call.
    }
}*/

// Backtracking 0-1
/*class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates == null || candidates.length == 0) return new ArrayList<>();
        result = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>());
        return result;
    }

    void backtrack(int[] candidates, int target, int index, List<Integer> path) {
        // Base
        if(target<0 || index == candidates.length) return;
        if(target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        // Logic
        // 0 or do not choose
        backtrack(candidates, target, index+1, path);
        // 1 or choose
        // Action
        path.add(candidates[index]);
        // Recurse
        backtrack(candidates, target-candidates[index], index, path);
        // Backtrack
        path.remove(path.size()-1);

    }
}*/

// Backtracking based - for loop recursion
class Solution {
  List<List<Integer>> result;
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    if(candidates == null || candidates.length == 0) return new ArrayList<>();
    result = new ArrayList<>();
    backtrack(candidates, target, 0, new ArrayList<>());
    return result;
  }

  void backtrack(int[] candidates, int target, int index, List<Integer> path) {
    // Base
    if(target<0) return;
    if(target == 0) {
      result.add(new ArrayList<>(path));
    }
    // Logic
    for(int i = index; i<candidates.length; i++) {
      // Action
      path.add(candidates[i]);
      // Recurse
      backtrack(candidates, target-candidates[i], i, path);
      // Backtrack
      path.remove(path.size()-1);
    }
  }
}