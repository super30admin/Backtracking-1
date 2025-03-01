import java.util.ArrayList;
import java.util.List;

public class Expression {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();

        if (num == null || num.length() == 0) {
            return result;
        }

        List<Character> list = new ArrayList<>();
        list.add('+');
        list.add('-');
        list.add('*');

        helper(num, target, list, 0, result, new StringBuilder(), 0, 0);
        return result;
    }

    private void helper(String num, int target, List<Character> list, int pivot, List<String> result, StringBuilder ans, long calc, long tail) {
        // base case
        if (pivot == num.length()) {
            if (calc == target) {
                result.add(ans.toString());
            }
            return;
        }

        for (int i = pivot; i < num.length(); i++) {
            // Avoid numbers with leading zeros
            if (i != pivot && num.charAt(pivot) == '0') break;

            String currStr = num.substring(pivot, i + 1);
            long currVal = Long.parseLong(currStr);
            int len = ans.length();

            if (pivot == 0) {
                // action
                ans.append(currStr);
                // recurse
                helper(num, target, list, i + 1, result, ans, currVal, currVal);
                ans.setLength(len); // backtrack
            } else {
                for (char operator : list) {
                    ans.append(operator).append(currStr);
                    if (operator == '+') {
                        helper(num, target, list, i + 1, result, ans, calc + currVal, currVal);
                    } else if (operator == '-') {
                        helper(num, target, list, i + 1, result, ans, calc - currVal, -currVal);
                    } else if (operator == '*') {
                        helper(num, target, list, i + 1, result, ans, calc - tail + tail * currVal, tail * currVal);
                    }
                    ans.setLength(len); // backtrack
                }
            }
        }
    }
}
