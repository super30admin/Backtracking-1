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

## solution
class Solution {

    List<List<Integer>> result;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        result = new ArrayList<>();

        if(candidates == null ) return result;

        

        helper(candidates ,0,target,new ArrayList<>());

            return result;

    }

    private void helper(int[] candidates , int pivot ,int amount,List<Integer> path){

        //base

        if(amount ==0){

            result.add(new ArrayList<>(path));

            return;

        }

        if(amount<0) return;

    
        //logic

         for(int i=pivot ;i<candidates.length;i++){

             path.add(candidates[i]);

             helper(candidates, i,amount -candidates[i] ,path);

             path.remove(path.size()-1);

         } 

    }

}


## Problem2
Expression Add Operators(https://leetcode.com/problems/expression-add-operators/)

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

## solution
class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        if (num == null || num.length() == 0) {
            return result;
        }
        backtrack(num, target, 0, 0, 0, "", result);
        return result;
    }

    private void backtrack(String num, int target, int index, long currentValue, long lastOperand, String expression, List<String> result) {
        // Base case: If we've reached the end of the string
        if (index == num.length()) {
            if (currentValue == target) {
                result.add(expression);
            }
            return;
        }

        // Iterate through all possible positions of the next operand
        for (int i = index + 1; i <= num.length(); i++) {
            String currentNumStr = num.substring(index, i);

            // Skip numbers with leading zeros, e.g., "05" or "001"
            if (currentNumStr.length() > 1 && currentNumStr.charAt(0) == '0') {
                continue;
            }

            long currentNum = Long.parseLong(currentNumStr);

            // If we're at the start, we can't add any operator, just take the current number
            if (index == 0) {
                backtrack(num, target, i, currentNum, currentNum, currentNumStr, result);
            } else {
                // Add '+'
                backtrack(num, target, i, currentValue + currentNum, currentNum, expression + "+" + currentNumStr, result);

                // Add '-'
                backtrack(num, target, i, currentValue - currentNum, -currentNum, expression + "-" + currentNumStr, result);

                // Add '*'
                backtrack(num, target, i, currentValue - lastOperand + lastOperand * currentNum, lastOperand * currentNum, expression + "*" + currentNumStr, result);
            }
        }
    }
}
