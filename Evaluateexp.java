// Time Complexity :O(4^N)
// Space Complexity : Recursion stack space
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no , just that 2 level tree


// Your code here along with comments explaining your approach
// Do 2 level tree recursion . first only for the numbers
// next for the operators
// for each operator do a seperate recursion, when it comes to * and % maintain a tail
// Strin builder + backtracking to avoid new space everytime.
import java.util.*;

public class Evaluateexp {
    List<String> res;

    public List<String> addOperators(String num, int target) {
        this.res = new ArrayList<>();

        helper(num, 0, 0L, new StringBuilder(), 0L, target);

        return res;
    }

    private void helper(String num, int pivot, long calc,
                         StringBuilder path, long tail, int target) {

        if (pivot == num.length()) {
            if (calc == target) {
                res.add(path.toString());
            }
            return;
        }

        for (int i = pivot; i < num.length(); i++) {

            // Don't allow numbers with leading zeros
            if (num.charAt(pivot) == '0' && i != pivot) {
                break;
            }

            long curr = Long.parseLong(
                num.substring(pivot, i + 1)
            );

            int len = path.length();

            if (pivot == 0) {
                path.append(curr);

                helper(
                    num,
                    i + 1,
                    curr,
                    path,
                    curr,
                    target
                );

                path.setLength(len);
            } else {

                // +
                path.append("+");
                path.append(curr);

                helper(
                    num,
                    i + 1,
                    calc + curr,
                    path,
                    curr,
                    target
                );

                path.setLength(len);

                // -
                path.append("-");
                path.append(curr);

                helper(
                    num,
                    i + 1,
                    calc - curr,
                    path,
                    -curr,
                    target
                );

                path.setLength(len);

                // *
                path.append("*");
                path.append(curr);

                helper(
                    num,
                    i + 1,
                    calc - tail + (tail * curr),
                    path,
                    tail * curr,
                    target
                );

                path.setLength(len);
            }
        }
    }
}