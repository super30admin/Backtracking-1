/*
 * Expression Add Operators - LeetCode 282
 * Approach: Backtracking. Recursively try all possible operator insertions between digits. Uses StringBuilder for efficient path building.
 * Time Complexity: O(4^n), where n is the length of the input string.
 * Space Complexity: O(n), for recursion stack and path building.
 * LeetCode Link: https://leetcode.com/problems/expression-add-operators/
 */

import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperators2 {
    List<String> result;

    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();
        helper(num, 0, 0, 0, new StringBuilder(), target);
        return result;
    }

    private void helper(String num, int pivot, long currentValue, long tale, StringBuilder path, int target) {
        //base
        if (pivot == num.length()) {
            if (currentValue == target) {
                result.add(path.toString());
            }
            return;
        }

        for (int i = pivot; i < num.length(); i++) {
            if (i != pivot && num.charAt(pivot) == '0') continue;
            long current = Long.parseLong(num.substring(pivot, i + 1));
            int length = path.length();
            if (pivot == 0) {
                path.append(current);
                helper(num, i + 1, current, current, path, target);
                path.setLength(length);
            } else {
                // + operation
                path.append("+");
                path.append(current);
                helper(num, i + 1, currentValue + current, current, path, target);
                path.setLength(length);

                // - operation
                path.append("-");
                path.append(current);
                helper(num, i + 1, currentValue - current, -current, path, target);
                path.setLength(length);

                // * operation
                path.append("*");
                path.append(current);
                helper(num, i + 1, currentValue - tale + current * tale, tale * current, path, target);
                path.setLength(length);
            }

        }

    }


    public static void main(String[] args) {
        System.out.println(new ExpressionAddOperators2().addOperators("123", 9));
    }
}
