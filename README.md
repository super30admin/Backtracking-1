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
TC: O(2^N)
SC: O(N)

//Approach:-
1. I wrote a backtracking function where either I will pick the element or not pick the element
2. If the target becomes 0 I will add the list in my result list
3. If we reached the end of the list we will simply return

class Solution {

    List<List<Integer>> result;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates == null || candidates.length == 0){
            return new ArrayList<>();
        }

        result = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();

        backtrack(candidates, target, 0, list);

        return result;
    }

    private void backtrack(int[] candidates, int target, int ind, ArrayList<Integer> list){
        //base case
        if(ind == candidates.length || target < 0){
            return;
        }

        //when we found the combination
        if(target == 0){
            result.add(new ArrayList<>(list));
            return;
        }

        //case 1: Pick the current element
        list.add(candidates[ind]);
        backtrack(candidates, target - candidates[ind], ind, list);

        //case 2: Do not pick the current element
        list.remove(list.size()-1);
        backtrack(candidates, target, ind+1, list);
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

TC : O(3^N * N)
SC : O(3^N * N)

//Approach:-

1. I wrote a bactracking solution in which I will backtrack for 3 possibilties: +,-,*
2. We will simply add or subtract to the sum but in case of multiplication as precedence of the operators matter we will first multiply the current number to the last number and the subtract the last number from the sum and add the product

import java.util.*;

class Solution {
    List<String> result;

    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();
        if (num == null || num.length() == 0) return result;
        backtrack(num, target, 0, 0, 0, new StringBuilder());
        return result;
    }

    private void backtrack(String num, int target, int index, long sum, long tail, StringBuilder str) {
        // Base case: all digits are used
        if (index == num.length()) {
            if (sum == target) {
                result.add(str.toString());
            }
            return;
        }

        for (int i = index; i < num.length(); i++) {
            // Skip numbers with leading zeros
            if (num.charAt(index) == '0' && i != index) break;

            long curr = Long.parseLong(num.substring(index, i + 1));
            int len = str.length();

            if (index == 0) {
                // First number, no operator
                str.append(curr);
                backtrack(num, target, i + 1, curr, curr, str);
                str.setLength(len); // backtrack
            }
            else {
                // +
                str.append('+').append(curr);
                backtrack(num, target, i + 1, sum + curr, curr, str);
                str.setLength(len);

                // -
                str.append('-').append(curr);
                backtrack(num, target, i + 1, sum - curr, -curr, str);
                str.setLength(len);

                // *
                str.append('*').append(curr);
                backtrack(num, target, i + 1, sum - tail + (tail * curr), tail * curr, str);
                str.setLength(len);
            }
        }
    }
}