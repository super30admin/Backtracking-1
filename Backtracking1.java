// Problem 1: https://leetcode.com/problems/combination-sum/
// Time Complexity : O(2^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach: I have used backtracking to solve this problem. I have used a helper function which takes in the candidates array, pivot, and target. I have used a base case where if the target is 0, I add the path to the result. If the target is less than 0, I return. I iterate over the candidates array and add the element to the path and call the helper function recursively with the same pivot and target - candidates[i]. I remove the last element from the path after the recursive call. This way I explore all the possibilities and get the desired result.
class Solution {
    List<List<Integer>> result;
    List<Integer> path;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.result = new ArrayList<>();
        this.path = new ArrayList<>();
        helper(candidates, 0, target);
        return result;
    }

    private void helper(int[] candidates, int pivot, int target) {
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }
        if (target < 0) {
            return;
        }
        for (int i = pivot; i < candidates.length; i++) {
            path.add(candidates[i]);
            helper(candidates, i, target - candidates[i]);
            path.remove(path.size() - 1);
        }
    }
}

// Problem 2:
// https://leetcode.com/problems/expression-add-operators/description/
// Time Complexity : O(4^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach: I have used backtracking to solve this problem. I have used a
// helper function which takes in the result, path, num, target, pos, eval, and
// multed. I have used a base case where if the pos is equal to the length of
// the num, I check if the eval is equal to the target. If it is, I add the path
// to the result. I iterate over the num string and check if the number has a
// leading zero. I convert the string to a long and check if it is the first
// number in the expression. If it is, I call the helper function recursively
// with the updated path, pos, and eval. If it is not the first number, I add
// the number to the path and call the helper function recursively with the
// updated path, pos, and eval. I remove the last element from the path after
// the recursive call. This way I explore all the possibilities and get the
// desired result.
class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        if (num == null || num.length() == 0) {
            return result;
        }
        backtrack(result, new StringBuilder(), num, target, 0, 0, 0);
        return result;
    }

    private void backtrack(List<String> result, StringBuilder path, String num, int target, int pos, long eval,
            long multed) {
        if (pos == num.length()) {
            if (eval == target) {
                result.add(path.toString());
            }
            return;
        }

        for (int i = pos; i < num.length(); i++) {
            // Avoid numbers with leading zero
            if (i != pos && num.charAt(pos) == '0') {
                break;
            }

            long cur = Long.parseLong(num.substring(pos, i + 1));
            int len = path.length();

            if (pos == 0) {
                // First number in the expression
                path.append(cur);
                backtrack(result, path, num, target, i + 1, cur, cur);
                path.setLength(len);
            } else {
                // Addition
                path.append("+").append(cur);
                backtrack(result, path, num, target, i + 1, eval + cur, cur);
                path.setLength(len);

                // Subtraction
                path.append("-").append(cur);
                backtrack(result, path, num, target, i + 1, eval - cur, -cur);
                path.setLength(len);

                // Multiplication
                path.append("*").append(cur);
                backtrack(result, path, num, target, i + 1, eval - multed + multed * cur, multed * cur);
                path.setLength(len);
            }
        }
    }
}