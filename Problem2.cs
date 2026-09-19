// Time Complexity : O(4^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

/*
This solution uses backtracking to generate all valid mathematical expressions by placing `+`, `-`, or `*` operators between the digits of a given string. At each step, it extracts a multi-digit number, handles edge cases like leading zeros, and recursively evaluates the expression's total value while keeping track of the previous operand to properly enforce multiplication precedence. The algorithm backtracks by resetting the `StringBuilder` length after exploring each choice, restoring the string state for subsequent iterations. When the entire input string is processed, any constructed expression whose evaluated total matches the target is appended to the results list.
*/

public class Solution {
    List<string> result;
    public IList<string> AddOperators(string num, int target) {
        result = new();
        Helper(num, target, 0, 0, 0, new StringBuilder());
        return result;
    }

    private void Helper(string num, int target, int pivot, long total, long prev, StringBuilder sb)
    {
        // Base Condition
        if(pivot == num.Length)
        {
            if(target==total)
            {
                result.Add(sb.ToString());
            }
            return;
        }

        // Core Logic
        long curr = 0;

        for(int i = pivot; i < num.Length; i++)
        {
            if(num[pivot] == '0' && i != pivot)
            {
                continue;
            }

            curr = curr * 10 + (num[i] - '0');

            int length = sb.Length;

            if(pivot == 0)
            {
                sb.Append(curr);
                Helper(num, target, i + 1, curr, curr, sb);
                sb.Length = length;
            }

            else
            {
                // + 
                sb.Append('+');
                sb.Append(curr);
                Helper(num, target, i+1, total + curr, curr, sb);
                sb.Length = length;

                // -
                sb.Append('-');
                sb.Append(curr);
                Helper(num, target, i+1, total - curr, -curr, sb);
                sb.Length = length;

                // *
                sb.Append('*');
                sb.Append(curr);
                Helper(num, target, i+1, total-prev + (prev*curr), prev*curr, sb);
                sb.Length = length;
            }
        }
    }
}