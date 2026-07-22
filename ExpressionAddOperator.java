class Solution {
    /*
        TC - O(4^N), N is the input length and 4 is the possible number of combinations we can choose from
        SC - O(N), N is the input length

        This solution uses backtracking (DFS) to generate all possible expressions by inserting +, -, and * operators between digits of the input string.
        The helper function recursively chooses the next number from the remaining digits.
        calc keeps the current evaluated value of the expression.
        tail stores the last operand value, which helps correctly evaluate multiplication due to operator precedence.
        When adding multiplication: calc - tail + tail * curr removes the previous operand and replaces it with the multiplied result.
        We skip numbers with leading zeros (like "05") to avoid invalid expressions.
        When all digits are processed, if calc == target, the expression is added to the result list.
    */
    List<String> result;
    public List<String> addOperators(String num, int target) {
        this.result = new ArrayList<>();
        helper(num, target, 0, 0l, 0l, new StringBuilder());
        return result;
    }

    private void helper(String num, int target, int pivot, long calc, long tail, StringBuilder path) {
        if (pivot == num.length()) {
            if (calc == target) {
                result.add(path.toString());
            }
        }

        int len = path.length();

        for (int  i = pivot; i < num.length(); i++) {
            if (pivot != i && num.charAt(pivot) == '0') continue;
            long curr = Long.parseLong(num.substring(pivot, i + 1));
            if (pivot == 0) {
                helper(num, target, i + 1, curr, curr, path.append(curr));
                path.setLength(len);
            } else {
                helper(num, target, i + 1, calc + curr, curr, path.append("+" + curr));
                path.setLength(len);
                helper(num, target, i + 1, calc - curr, -curr, path.append("-" + curr));
                path.setLength(len);
                helper(num, target, i + 1, calc - tail + tail * curr, tail * curr, path.append("*" + curr));
                path.setLength(len);
            }
        }
    }
}