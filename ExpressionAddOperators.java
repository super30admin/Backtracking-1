import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperators {
    class Solution {
    List<String> result;

    public List<String> addOperators(String num, int target) {
        this.result = new ArrayList<String>();
        helper(num, target, 0, 0, 0, new StringBuilder());
        return result;
    }

    public void helper(String num, int target, long calc, long tail, int index, StringBuilder sb) {

        if (calc == target && index == num.length()) {
            result.add(sb.toString());
            return;
        }
        for (int i = index; i < num.length(); i++) {
            // preceding zero case
            if (i != index && num.charAt(index) == '0') {
                break;
            }

            long curr = Long.parseLong(num.substring(index, i + 1));
            int len = sb.toString().length();

            if (index == 0) {
                sb.append(curr); //action
                helper(num, target, curr, curr, i + 1, sb); //recurse
                sb.setLength(len); //backtrack
            } else {
                sb.append("+");
                sb.append(curr);
                helper(num, target, calc + curr, curr, i + 1, sb);
                sb.setLength(len);

                sb.append("-");
                sb.append(curr);
                helper(num, target, calc - curr, -curr, i + 1, sb);
                sb.setLength(len);

                sb.append("*");
                sb.append(curr);
                helper(num, target, calc - tail + tail * curr, tail * curr, i + 1, sb); // recurse
                sb.setLength(len);// backtrack
            }

        }

    }
}
}
