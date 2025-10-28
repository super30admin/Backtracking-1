class Solution {
    List<String> result;
    public List<String> addOperators(String num, int target) {
        if (num == null || num.length() == 0) return new ArrayList<>();

        result = new ArrayList<>();
        
        backtrack(num, target, 0, 0, 0, "");

        return result;
    }

    public void backtrack(String num, int target, int index, long calc, long tail, String exp) {

        if (index == num.length()) {
            if (target == calc) result.add(exp);
            return;
        }

        for (int i=index; i<num.length(); i++) {

            long curr = Long.parseLong(num.substring(index, i + 1));

            // if it is not a single digit number and the first digit is 0 then we should skip this iteration

            if (index != i && num.charAt(index) == '0') break;

            if (index == 0) {
                // 1st digit or number
                backtrack(num, target, i + 1, calc + curr, curr, curr + "");
            } else {
                // + operator
                backtrack(num, target, i + 1, calc + curr, curr, exp + "+" + curr);
                // - operator
                backtrack(num, target, i + 1, calc - curr, -curr, exp + "-" + curr);
                // * operator
                backtrack(num, target, i + 1, (calc-tail) + (tail*curr), tail*curr, exp + "*" + curr);
            }
        }

    }
}
