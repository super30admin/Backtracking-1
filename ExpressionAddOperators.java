//TC: O(3^n)
//SC: O(n)
//approach: backtracking, with maintaining tail/last operation

import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperators {
    List<String> result;

    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();
        backtrack(num, target, new StringBuilder(), 0, 0, 0);
        return result;
    }

    private void backtrack(String num, int target, StringBuilder sb, long calculated, long tail, int index) {
        if (index == num.length()) {
            if (calculated == target) {
                result.add(sb.toString());
                return;
            }
        }
        for (int i = index; i < num.length(); i++) {
            if (index != i && num.charAt(index) == '0') break;
            long curr = Long.parseLong(num.substring(index, i + 1));
            int length = sb.toString().length();
            if (index == 0) {
                sb.append(curr);
                backtrack(num, target, sb, curr, curr, i + 1);
                sb.setLength(length);
            } else {
                sb.append("+");
                sb.append(curr);
                backtrack(num, target, sb, calculated + curr, curr, i + 1);
                sb.setLength(length);

                sb.append("-");
                sb.append(curr);
                backtrack(num, target, sb, calculated - curr, -curr, i + 1);
                sb.setLength(length);

                sb.append("*");
                sb.append(curr);
                backtrack(num, target, sb, calculated - tail + tail * curr, tail * curr, i + 1);
                sb.setLength(length);
            }
        }
    }
}
