// Time Complexity: O(4^n) – At each digit, we can branch into up to 4 choices (concatenate digit or add +, -, *), so exponential with respect to the number of digits n.
//Space Complexity: O(n) – Due to recursion depth and path string (StringBuilder) used in backtracking for expressions of length n.

//Use backtracking to try all combinations of inserting +, -, *, or no operator between digits.
//Track the current evaluated value, the last operand (tail) for handling multiplication, and the current number being formed.
//When the end of the string is reached, add the expression to the result if the evaluation equals the target.

class Solution {
    List<String> result;
    public List<String> addOperators(String num, int target) {
        this.result = new ArrayList<>();

        helper(num, target, 0, 0, 0, 0, new StringBuilder());

        return result;
    }

    private void helper(String num, int target, int i, long curr, long calc, long tail, StringBuilder path) {

        if(i == num.length()) {
            if(calc == target && curr == 0) {
                result.add(path.toString());
            }
            return;
        }

        curr = curr * 10 + num.charAt(i) - '0';

        if(curr > 0) {
            helper(num, target, i + 1, curr, calc, tail, path);
        }

        int le = path.length();

        if(path.length() == 0) {
            path.append(curr);
            helper(num, target, i + 1, 0, curr, curr, path);
            path.setLength(le);
        } else {
            path.append("+").append(curr);
            helper(num, target, i + 1, 0, calc + curr, curr, path);
            path.setLength(le);

            path.append("-").append(curr);
            helper(num, target, i + 1, 0, calc - curr, -curr, path);
            path.setLength(le);

            path.append("*").append(curr);
            helper(num, target, i + 1, 0, calc - tail + (tail * curr), tail * curr, path);
            path.setLength(le);
        }
    }
}
