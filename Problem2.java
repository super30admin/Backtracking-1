//space complexity o(n)
//time complexity o(4^n)
//using dfs for loop exploring every solution
class Solution {

    List<String> result = new ArrayList<>();

    public List<String> addOperators(String num, int target) {

        helper(num, 0, "", target, 0, 0);

        return result;
    }

    private void helper(String num,
            int i,
            String path,
            int target,
            long totalSum,
            long prev) {

        if (i == num.length()) {

            if (totalSum == target) {
                result.add(path);
            }

            return;
        }

        long current = 0;

        for (int j = i; j < num.length(); j++) {

            if (j > i && num.charAt(i) == '0') {
                break;
            }

            current = current * 10 + (num.charAt(j) - '0');

            String currentString = num.substring(i, j + 1);

            if (i == 0) {

                helper(
                        num,
                        j + 1,
                        currentString,
                        target,
                        current,
                        current);

            } else {

                helper(
                        num,
                        j + 1,
                        path + "+" + currentString,
                        target,
                        totalSum + current,
                        current);

                helper(
                        num,
                        j + 1,
                        path + "-" + currentString,
                        target,
                        totalSum - current,
                        -current);

                helper(
                        num,
                        j + 1,
                        path + "*" + currentString,
                        target,
                        totalSum - prev + prev * current,
                        prev * current);
            }
        }
    }
}
