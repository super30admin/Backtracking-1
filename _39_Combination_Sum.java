/**** Method 1 ****/
//Time Complexity: O(2^(m+n)) m is candidate's length and n is target
//Space Complexity: O(n)

//Successfully submitted in LeetCode

// Using recursion we traverse using loop and add the value at the index to list and subtract it from target, after coming back from the recursion we remove the last added value and continue with the loop, for base the condition we any moment the target becomes zero, then we found a answer we add it the ans list. To avoid duplicates we ignore if the value at index is equal to previous value.

/**** Method 2 ****/
//Time Complexity: O(2^(m+n)) m is candidate's length and n is target
//Space Complexity: O(n)

//Successfully submitted in LeetCode

// Same as above but we use pick and no pick method instead of the loop.

import java.util.ArrayList;
import java.util.List;

public class _39_Combination_Sum {

  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    combinationSum1(candidates, 0, target, list, ans);
    return ans;
  }

  public void combinationSum(
    int candidates[],
    int i,
    int target,
    List<Integer> list,
    List<List<Integer>> ans
  ) {
    if (target == 0) {
      ans.add(new ArrayList<>(list));
      return;
    }
    for (int idx = i; idx < candidates.length; idx++) {
      if (idx < i && candidates[i - 1] == candidates[i]) continue; // to remove duplicates
      if (candidates[idx] > target) continue;
      list.add(candidates[idx]);
      combinationSum(candidates, idx, target - candidates[idx], list, ans);
      list.remove(list.size() - 1);
    }
  }

  public void combinationSum1(
    int candidates[],
    int i,
    int target,
    List<Integer> list,
    List<List<Integer>> ans
  ) {
    if (i == candidates.length && target == 0) {
      ans.add(new ArrayList<>(list));
      return;
    }

    if (i == candidates.length || target < 0) {
      return;
    }

    list.add(candidates[i]);
    combinationSum1(candidates, i, target - candidates[i], list, ans);
    list.remove(list.size() - 1);
    int j = i;
    while (j < candidates.length && candidates[j] == candidates[i]) {
      j++;
    }
    combinationSum1(candidates, j, target, list, ans);
  }
}
