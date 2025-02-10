
/**
 * Time Complexity: 4^N where N is length of the num
 * Space Complexity: O(N) recursive stack space
 */

import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperators {

    List<String> result;

    public List<String> addOperators(String num, int target) {
        if (num == null || num.length() == 0) {
            return new ArrayList<>();
        }
        result = new ArrayList<>();
        backtrack(num, target, 0, 0, 0, "");
        return result;
    }

    private void backtrack(String num, int target, int index, long calc, long tail, String path) {
        // base
        if (index == num.length()) {
            if (calc == target) {
                result.add(path);
            }
            return;
        }

        // logic
        for (int i = index; i < num.length(); i++) {
            // Leading zeros
            if (num.charAt(index) == '0' && index != i) {
                continue;
            }

            long current = Long.parseLong(num.substring(index, i + 1));
            if (index == 0) {
                backtrack(num, target, i + 1, current, current, path + current);
            } else {
                // + operator
                backtrack(num, target, i + 1, calc + current, +current, path + "+" + current);

                // - operator
                backtrack(num, target, i + 1, calc - current, -current, path + "-" + current);

                // * operator
                backtrack(num, target, i + 1, calc - tail + tail * current, tail * current, path + "*" + current);

            }

        }
    }

}
