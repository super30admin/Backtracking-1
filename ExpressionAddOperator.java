import java.util.ArrayList;
import java.util.List;

// TC: O(4 ^ n) as 4 recursion calls are invoked for every index.
// SC: O(n) for recursion stack size which can be equal to the length of num string in a worst case.

// This approach is an exhaustive approach which explores all the possibilities. Following is loop based recursion
public class ExpressionAddOperator {
    static List<String> result = null;

    public static void main(String[] args) {
        addOperators("123", 6); // [1+2+3, 1*2*3]
        addOperators("0123", 6); // [0+1+2+3, 0+1*2*3, 0*1+2*3]
        addOperators("1023", 6); // [1+0+2+3, 1-0+2+3, 1*0+2*3]
    }

    public static void addOperators(String num, int target) {
        result = new ArrayList<>();
        recurse(num, target, 0, 0L, 0L, ""); // num, target, index, cal,tail, path""
        System.out.println(result);
    }

    private static void recurse(String num, int target, int index, Long cal, Long tail, String path) {
        // base
        if (index == num.length() && cal == target) {
            result.add(path);
            return;
        }
        // logic
        for (int i = index; i < num.length(); i++) {
            if (num.charAt(index) == '0' && index < i)
                continue;
            Long curr = Long.parseLong(num.substring(index, i + 1));
            if (index == 0) {
                recurse(num, target, i + 1, curr, curr, path + curr);
            } else {
                recurse(num, target, i + 1, cal + curr, +curr, path + "+" + curr); // +
                recurse(num, target, i + 1, cal - curr, -curr, path + "-" + curr); // -
                // Formula for cal in * is cal - tail + tail * curr
                recurse(num, target, i + 1, cal - tail + tail * curr, tail * curr, path + "*" + curr); // *
            }
        }
    }
}