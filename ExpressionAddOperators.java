//Time Complexity: O(4^n)
//Space Complexity: O(n)
public class ExpressionAddOperators {
    List<String> result;

    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();
        helper(0, num, 0, 0, target, new StringBuilder());
        return result;
    }

    private void helper(int index, String num, long temp, long calculated, int target, StringBuilder path) {
        if (index == num.length()) {
            if (calculated == target) {
                result.add(path.toString());
            }
            return;
        }
        for (int i = index; i < num.length(); i++) {

            if(num.charAt(index) == '0' && i != index) break;
            long curr = Long.parseLong(num.substring(index, i + 1));


            int le = path.length();

            if (index == 0) {
                path.append(curr);
                helper(i + 1, num, curr, curr, target, path);
                path.setLength(le);
            } else {
                helper(i + 1, num, curr, curr + calculated, target, path.append("+").append(curr));
                path.setLength(le);

                helper(i + 1, num, -curr, calculated - curr, target, path.append("-").append(curr));
                path.setLength(le);

                path.append("*").append(curr);

                helper(i + 1, num, temp * curr, (calculated - temp) + (temp * curr), target, path);
                path.setLength(le);
            }
        }

    }
}
