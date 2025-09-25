//Time Complexity: O(4^n) since we have 4 options at every node
//Space Complexity: O(n)
import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperators {

    public List<String> addOperators(String num, int target) {
        final List<String> output = new ArrayList<>();
        helper(num, target, 0, 0L, 0L, new StringBuilder(), output);
        return output;
    }

    private void helper(String num, int target, int pivot, long calc, long tail, StringBuilder path, List<String> output) {
        if (pivot == num.length()) {
            if (target == calc) output.add(path.toString());
            return;
        }

        for (int i = pivot; i < num.length(); i++) {
            //if the char at pivot is 0 and i != pivot
            if (num.charAt(pivot) == '0' && i != pivot) continue;

            long current = Long.parseLong(num.substring(pivot, i + 1));
            int length = path.length();

            if (pivot == 0) {
                path.append(current);
                helper(num, target, i + 1, current, current, path, output);
                path.setLength(length);
            } else {
                path.append("+").append(current);
                helper(num, target, i + 1, calc + current, current, path, output);
                path.setLength(length);

                path.append("-").append(current);
                helper(num, target, i + 1, calc - current, -current, path, output);
                path.setLength(length);

                path.append("*").append(current);
                helper(num, target, i + 1, calc - tail + current * tail, current * tail, path, output);
                path.setLength(length);
            }
        }
    }

    public static void main(String[] args) {
        final ExpressionAddOperators addOperators = new ExpressionAddOperators();
        System.out.println(addOperators.addOperators("123", 6));
        System.out.println(addOperators.addOperators("123", 36));
        System.out.println(addOperators.addOperators("123", 9));
        System.out.println(addOperators.addOperators("1233", 9));
        System.out.println(addOperators.addOperators("123", 23));
        System.out.println(addOperators.addOperators("105", 5));
        System.out.println(addOperators.addOperators("3456237490", 9191));
        System.out.println(addOperators.addOperators("232", 8));
    }
}
