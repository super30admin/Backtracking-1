class Solution {
    List<String> res;

    public List<String> addOperators(String num, int target) {
        // Tc: O(3^n) Sc: O(n)
        res = new ArrayList<>();
        helper(num, 0, 0, 0, "", target);
        return res;
    }

    private void helper(String num, int index, long calc, long tail, String path, int target) {
        if (index == num.length()) {
            if (calc == target) {
                res.add(path);
            }
            return;
        }
        for (int i = index; i < num.length(); i++) {

            if (i != index && num.charAt(index) == '0') {
                break;
            }
            long cur = Long.parseLong(num.substring(index, i + 1));
            if (index == 0) {

                helper(num, i + 1, cur, cur, path + cur, target);
            } else {

                helper(num, i + 1, calc + cur, cur, path + "+" + cur, target);
                helper(num, i + 1, calc - cur, -cur, path + "-" + cur, target);
                helper(num, i + 1, calc - tail + tail * cur, tail * cur, path + "*" + cur, target);
            }
        }
    }
}