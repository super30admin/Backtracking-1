# Bactracking-1


## Problem1 
Combination Sum (https://leetcode.com/problems/combination-sum/)

Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

The same repeated number may be chosen from candidates unlimited number of times.

Note:

All numbers (including target) will be positive integers.
The solution set must not contain duplicate combinations.
Example 1:

Input: candidates = [2,3,6,7], target = 7,
A solution set is:
[
  [7],
  [2,2,3]
]
Example 2:

Input: candidates = [2,3,5], target = 8,
A solution set is:
[
  [2,2,2,2],
  [2,3,3],
  [3,5]
]



Explain the approach in 3 lines: In this solution we are using backtracking approach to find all unique combinations of numbers in the candidates array that sum up to the given target. The helper function will recursively explore two options at each index either adding the current candidates to the path by choosing it or skipping the current candidate by not choosing it. If the target becomes zero we will add current path to the result. If target becomes negative or the end of the array is reached we will stop the recursion.

Time Complexity: O(2^n) where n is the number of candidates as we are exploring all possible combinations of the candidates

Space Complexity: O(t) where t is the target as it will come from depth of the recursion stack and storing the path for valid combinations

Approached Code:

class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();

        if(candidates == null) {
            return result;
        }

        helper(candidates, target, 0, new ArrayList<>());

        return result;
    }

    private void helper(int[] candidates, int target, int idx, List<Integer> path) {
        //base 
        if(target == 0) {
            // result.add(path);
            result.add(new ArrayList<>(path));
            return;
        }

        if(target < 0 || idx == candidates.length) {
            return;
        }

        //logic
        // // don't choose 
        // helper(candidates, target, idx+1, new ArrayList<>(path), result);
        // // choose
        // path.add(candidates[idx]);
        // helper(candidates, target - candidates[idx], idx, 
        // new ArrayList<>(path), result);

        // Backtracking logic
        // don't choose
        // helper(candidates, target, idx+1, path);

        // choose
        // action
        // path.add(candidates[idx]);
        //recurse
        // helper(candidates, target - candidates[idx], idx, path);
        //backtrack
        // path.remove(path.size() - 1);

        for(int i = idx; i < candidates.length; i++) {
            path.add(candidates[i]);
            helper(candidates, target - candidates[i], i, path);
            path.remove(path.size() - 1);
        }
    }
}





## Problem2
Expression Add Operators( )

Given a string that contains only digits 0-9 and a target value, return all possibilities to add binary operators (not unary) +, -, or * between the digits so they evaluate to the target value.

Example 1:

Input: num = "123", target = 6
Output: ["1+2+3", "1*2*3"] 
Example 2:

Input: num = "232", target = 8
Output: ["2*3+2", "2+3*2"]
Example 3:

Input: num = "105", target = 5
Output: ["1*0+5","10-5"]
Example 4:

Input: num = "00", target = 0
Output: ["0+0", "0-0", "0*0"]
Example 5:

Input: num = "3456237490", target = 9191
Output: []



Explain the approach in 3 lines: We are using backtraking to solve this problem. We will explore every possible way to insert +, -, *  between the digits of the string num to match the target value. Starting from the first digit in this algorithm we will build potential expressions by recursively adding an operator followed by the next substring of digits. For each combination we will calculate the current value calc and we will use the tail to handle multiplication properly. Using backtracking we will ensure that the solution reverts the string builder to its previous state after exploring each path.

Time Complexity: O(4^n) where n is length of input string num as at each step we wither choose no operator or one of the three operators giving us 4 choices at ecah digit

Space Complexity: O(n) where n is length of num as this space will be used by recursion stack and the string builder that stores the current expression path

Approached Code:

class Solution {
    List<String> result;
    public List<String> addOperators(String num, int target) {
        this.result = new ArrayList<>();
        // helper(num, 0, "", 0, 0, target);
        helper(num, target, new StringBuilder(), 0, 0, 0);
        return result;
    }

    // private void helper(String num, int pivot, String path, long calc, long tail, int target) {
    private void helper(String num, int target, StringBuilder sb, long calc, long tail, int pivot){
        // base
        if(pivot == num.length()) {
            if(calc == target) {
                // result.add(path);
                result.add(sb.toString());
            }
            return;
        }

        // logic
        for(int i = pivot; i < num.length(); i++) {
            //preceding zero
            if(num.charAt(pivot) == '0' && i != pivot) {
                continue;
            }

            long curr = Long.parseLong(num.substring(pivot, i+1));
            int len = sb.toString().length();

            // top level
            if(pivot == 0) {
                // action
                sb.append(curr);

                // helper(num, i+1, path + curr, curr, curr, target);

                // recurse
                helper(num, target, sb, curr, curr, i+1);

                // backtrack
                sb.setLength(len);
            } else {
                // +
                // helper(num, i+1, path + '+' + curr, calc + curr, curr, target);
                
                // action
                sb.append("+");
                sb.append(curr);

                // recurse
                helper(num, target, sb, calc + curr, curr, i+1);

                //backtrack
                sb.setLength(len);
                

                // -
                // helper(num, i+1, path + '-' + curr, calc - curr, -curr, target);
                
                // action
                sb.append("-");
                sb.append(curr);

                // recurse
                helper(num, target, sb, calc - curr, -curr, i+1);

                //backtrack
                sb.setLength(len);


                // *
                // helper(num, i+1, path + '*' + curr, calc - tail + tail * curr, tail * curr, target);
                
                // action
                sb.append("*");
                sb.append(curr);

                // recurse
                helper(num, target, sb, calc - tail + tail * curr, tail * curr, i+1);

                //backtrack
                sb.setLength(len);
            }
        }
    }
}


