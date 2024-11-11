// constraints: limited number like 30/40 likely to be a extensive brute force solution
// less than 150 combinations
// combination is unique when at least one of the chosen number is different
// edge cases: will result always exist?

// question asks for combinations
// likely a tree problem that needs to form various combinations and backtrack our steps

/*
    -> iterate over each number and see if forms the combination?
    -> at every place we decide whether or not to choose the number 
    -> either maintain same list of create new list at every iteration
    -> this will involve recurssion based code

   1. simple recurssion
   2. for loop based recurssion -> from pivot onwards we will be doing for loop based recurssion

    tc: O(2^n) -> cause every number in iteration we are doing choose not choose
    sc: O(n) 
*/

class Solution {

  List<List<Integer>> result;

  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    this.result = new ArrayList<>();
    helper(candidates, target, 0, new ArrayList<>());
    return result;
  }

  private void helper(int[] cand, int target, int idx, List<Integer> path) {
    //base
    if (target < 0 || idx == cand.length) return;
    if (target == 0) {
      result.add(new ArrayList<>(path));
      return;
    }

    //not choose
    helper(cand, target, idx + 1, path);

    //choose
    //action
    path.add(cand[idx]);
    //recurse
    helper(cand, target - cand[idx], idx, path);
    // backtrack
    path.remove(path.size() - 1);
  }
}

// for loop based
class Solution {

  List<List<Integer>> result;

  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    this.result = new ArrayList<>();
    helper(candidates, target, 0, new ArrayList<>());
    return result;
  }

  private void helper(int[] cand, int target, int pivot, List<Integer> path) {
    //base
    if (target < 0) return;
    if (target == 0) {
      result.add(new ArrayList<>(path));
      return;
    }

    //logic
    for (int i = pivot; i < cand.length; i++) {
      path.add(cand[i]);
      //recurse
      helper(cand, target - cand[i], i, path);
      //backtrack
      path.remove(path.size() - 1);
    }
  }
}
