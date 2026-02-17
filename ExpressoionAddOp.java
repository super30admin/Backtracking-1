// Time Complexity : O(4^(N))
// Space Complexity :O(length of string)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

class Solution {
    List<String> result;

    public List<String> addOperators(String num, int target) {
        this.result = new ArrayList<>();
        helper(num, 0, new StringBuilder(), 0, 0, target);
        return result;
    }

    private void helper(String num, int pivot, StringBuilder path, long calc, long tail, int target) {
        // base
        if (pivot == num.length()) {
            if (target == calc) {
                result.add(path.toString());
            }
        }

        for (int i = pivot; i < num.length(); i++) {
            if (num.charAt(pivot) == '0' && pivot != i)
                continue;

            long curr = Long.parseLong(num.substring(pivot, i + 1));

            if (pivot == 0) {
                int inl = path.length();
                path.append(curr);
                helper(num, i + 1, path, curr, curr, target);
                path.setLength(inl);
            } else {
                int inl = path.length();

                path.append("+");
                path.append(curr);
                helper(num, i + 1, path, calc + curr, curr, target);
                path.setLength(inl);

                path.append("-");
                path.append(curr);
                helper(num, i + 1, path, calc - curr, -curr, target);
                path.setLength(inl);

                path.append("*");
                path.append(curr);
                helper(num, i + 1, path, calc - tail + tail * curr, tail * curr, target);
                path.setLength(inl);
            }
        }
    }
}