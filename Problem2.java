import java.util.ArrayList;
import java.util.List;\

class Problem2 {
    List<String> result;

    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();
        if (num == null || num.length() == 0) return result;

        helper(num, target, 0, 0, 0, "");
        return result;
    }

    private void helper(String num, int target, int idx, long eval, long prev, String path) {
        // base case
        if (idx == num.length()) {
            if (eval == target) {
                result.add(path);
            }
            return;
        }

        // choose numbers of different lengths
        for (int i = idx; i < num.length(); i++) {

            // avoid leading zero numbers like "05"
            if (i != idx && num.charAt(idx) == '0') break;

            long curr = Long.parseLong(num.substring(idx, i + 1));

            // first number (no operator)
            if (idx == 0) {
                helper(num, target, i + 1, curr, curr, path + curr);
            } else {
                // +
                helper(num, target, i + 1,
                        eval + curr,
                        curr,
                        path + "+" + curr);

                // -
                helper(num, target, i + 1,
                        eval - curr,
                        -curr,
                        path + "-" + curr);

                // *
                helper(num, target, i + 1,
                        eval - prev + prev * curr,
                        prev * curr,
                        path + "*" + curr);
            }
        }
    }
}

//time complexity: O(N * 4^N) where N is the length of the input string num.
//space complexity: O(N) for the recursion stack and the path string.

