/*
Time Complexity : O(4^N), 4 choices between numbers no operator, +,- and *
Space Complexity : O(N)
Did this code successfully run on Leetcode : yes
Any problem you faced while coding this : no
Approach :
Main objective is to first create digits and numbers out of the number string. We will need to use recursion for that.
We can sub-string the number recursively and create valid combination.

After the digits are created, we need to evaluate them by putting operators between them +,- and *.
We calculate the value in each recursion call and keep pass it to the next child. If the entire number is evaluated and
if the calculated is equal to the target, we add the expression to the result.

When evaluating a path, we will need to back track the last value and the operator that got added, so we will need to
maintain tail variable to identify the last operator/expression appended.
operator    tail        calculated
+           +curr       calculated+curr
-           -curr       calculated-curr
*           tail*curr   calculated-tail+tail*curr
/           tail/curr   calculated-tail+tail/curr

CAVEATS:
1. At index = 0, we cant use an operator(+4, -4, *4) of the expression, so, we just call recursion on the next index.
2. Preceding 0 problem, "05" is not valid, "10" is valid.
*/

import java.util.ArrayList;
import java.util.List;

public class ExpressionAndOperators {
    List<String> result = new ArrayList<>();

    public List<String> addOperators(String num, int target) {
        StringBuilder sb = new StringBuilder();
        findExpression(0, num, target, 0, 0, sb);
        return result;
    }

    void findExpression(int index, String num, int target, long calculated, long tail, StringBuilder sb) {
        int length = num.length();
        if (length == index) {
            if (target == calculated) {
                result.add(sb.toString());
                return;
            }
        }

        int len = sb.length();
        for (int i = index; i < length; i++) {
            // To solve the preceding zero problem
            if(num.charAt(index) == '0' && i > index)  break;
            long curr = Long.parseLong(num.substring(index, i + 1));

            if (index == 0) {
                sb.append(curr);
                // At this point curr is just number, without any operator
                findExpression(i+1, num, target, curr, curr, sb);
                sb.setLength(len);
            } else {
                sb.append("+"+curr);
                findExpression(i + 1, num, target, calculated + curr, curr, sb);
                sb.setLength(len);

                sb.append("-"+curr);
                findExpression(i + 1, num, target, calculated - curr, -curr, sb);
                sb.setLength(len);

                sb.append("*"+curr);
                findExpression(i + 1, num, target, calculated - tail + (tail * curr), tail * curr, sb);
                sb.setLength(len);
            }
        }
    }
}
