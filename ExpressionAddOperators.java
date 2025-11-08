/*
 * Expression Add Operators - LeetCode 282
 * Approach: Backtracking. Recursively try all possible operator insertions between digits.
 * Time Complexity: O(4^n), where n is the length of the input string.
 * Space Complexity: O(n), for recursion stack and path building.
 * LeetCode Link: https://leetcode.com/problems/expression-add-operators/
 */

import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperators {
    List<String> result;

    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();
        helper(num, 0, 0, 0, "", target);
        return result;
    }

    private void helper(String num, int pivot, long currentValue, long tale, String path, int target) {
        //base
        if (pivot == num.length()) {
            if (currentValue == target) {
                result.add(path);
            }
            return;
        }

        for (int i = pivot; i < num.length(); i++) {
            if (i != pivot && num.charAt(pivot) == '0') continue;
            long current = Long.parseLong(num.substring(pivot, i + 1));
            if (pivot == 0) {
                helper(num, i + 1, current, current, path + current, target);
            } else {
                // + operation
                helper(num, i + 1, currentValue + current, current, path + '+' + current, target);

                // - operation
                helper(num, i + 1, currentValue - current, -current, path + '-' + current, target);

                // * operation
                helper(num, i + 1, currentValue - tale + current * tale, tale * current, path + '*' + current, target);
            }

        }

    }


    public static void main(String[] args) {
        System.out.println(new ExpressionAddOperators().addOperators("123", 9));
    }
}
