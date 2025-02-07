class Solution {
    List<String> result;

    public List<String> addOperators(String num, int target) {
        if (num == null || num.length() == 0) {
            return new ArrayList<>();
        }
        result = new ArrayList<>();
        recurse(num, target, 0, 0, 0, "");
        return result;
    }

    private void recurse(String num, int target, int index, long calc, long tail, String path) {
        if (index == num.length()) {
            if (calc == target) {
                result.add(path);
            }
            return;
        }

        for (int i = index; i < num.length(); i++) {
            // Prevent numbers with leading zeroes (except single "0")
            if (num.charAt(index) == '0' && i != index) {
                continue;
            }
            long curr = Long.parseLong(num.substring(index, i + 1));

            if (index == 0) {
                // First number, no operator
                recurse(num, target, i + 1, curr, curr, path + curr);
            } else {
                // Addition
                recurse(num, target, i + 1, calc + curr, +curr, path + "+" + curr);
                // Subtraction
                recurse(num, target, i + 1, calc - curr, -curr, path + "-" + curr);
                // Multiplication (corrected)
                recurse(num, target, i + 1, calc - tail + tail * curr, tail * curr, path + "*" + curr);
            }
        }
    }
}