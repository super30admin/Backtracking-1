// In this problem, we using backtracking, we are carrying a data structure with us i.e list, adding the candidates to the list, and 
// checking if the sum is target, if it is, adding that combination to the outer result list, if not, we are removing the candidate and
// moving to check the next combination. 

// Time Complexity :Exponential
// Space Complexity : 0(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// 0-1 recursion solution - Extra time and space due to new arraylist and
// copying elements everytime to it
class Solution {
    List<List<Integer>> result;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // Base case
        if (candidates == null || candidates.length == 0) {
            return new ArrayList<>();
        }
        // Declare result list
        result = new ArrayList<>();
        // Recursive call
        recurse(candidates, 0, target, new ArrayList<>());
        return result;
    }

    private void recurse(int[] candidates, int index, int target, List<Integer> res) {
        // If we are out of candidates or when the target becomes negative, return
        if (candidates.length == index || target < 0) {
            return;
        }
        // If target is 0, that means we found one of the combination
        if (target == 0) {
            // Add that combination/path to the result
            result.add(res);
            return;
        }
        // 0 case or do not pick case - index moves to next candidate, rest all same
        // Note we are creating new list in every call because, list is passed by
        // reference in java
        recurse(candidates, index + 1, target, new ArrayList<>(res));
        // Then add the candidate to the res/path for 1/pick the candidate case
        res.add(candidates[index]);
        // Pick the candidate or 1 case
        // Note: index remains same, bcoz we can pick the candidate again even after
        // picking once
        recurse(candidates, index, target - candidates[index], new ArrayList<>(res));
    }
}

// Backtracking solution:
class Solution {
    List<List<Integer>> result;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return new ArrayList<>();
        }
        result = new ArrayList<>();
        recurse(candidates, 0, target, new ArrayList<>());
        return result;
    }

    private void recurse(int[] candidates, int index, int target, List<Integer> res) {
        if (candidates.length == index || target < 0) {
            return;
        }
        if (target == 0) {
            result.add(new ArrayList<>(res));
            return;
        }
        // Note in backtracking solution, no need to create new list everytime, since we
        // are removing the candidates after the recursive call is completed
        recurse(candidates, index + 1, target, res);
        // Backtracking template:
        // Action
        res.add(candidates[index]);
        // Recurse
        recurse(candidates, index, target - candidates[index], res);
        // Backtrack
        res.remove(res.size() - 1);
    }
}

// for loop based recursion:
class Solution {
    List<List<Integer>> result;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return new ArrayList<>();
        }
        result = new ArrayList<>();
        recurse(candidates, 0, target, new ArrayList<>());
        return result;
    }

    private void recurse(int[] candidates, int index, int target, List<Integer> res) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            result.add(res);
            return;
        }
        // For loop based recursion
        for (int i = index; i < candidates.length; i++) {
            // Keep on picking the candidate until hit the base case, post that for loop
            // will move on to next index/candidate
            List<Integer> newList = new ArrayList<>(res);
            newList.add(candidates[i]);
            recurse(candidates, i, target - candidates[i], newList);
        }

    }
}

// Backtracking using for loop based recursion
class Solution {
    List<List<Integer>> result;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return new ArrayList<>();
        }
        result = new ArrayList<>();
        recurse(candidates, 0, target, new ArrayList<>());
        return result;
    }

    private void recurse(int[] candidates, int index, int target, List<Integer> res) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            result.add(new ArrayList<>(res));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            res.add(candidates[i]);
            recurse(candidates, i, target - candidates[i], res);
            res.remove(res.size() - 1);
        }

    }
}