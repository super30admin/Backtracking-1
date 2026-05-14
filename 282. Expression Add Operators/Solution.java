class Solution {
    public List<String> addOperators(String num, int target) {

        List<String> result = new ArrayList();

        helper(num, target, 0, 0, 0, new StringBuilder(), result);

        return result;

    }

    public void helper(String num, int target, long calc, long tail, int pivot, StringBuilder path,
            List<String> result) {

        //base case
        if (pivot == num.length()) {
            if (calc == target) {
                result.add(path.toString());
            }
        }

        //for loop
        for (int i = pivot; i < num.length(); i++) {

            if (num.charAt(pivot) == '0' && i != pivot) {
                break;
            }

            long cur = Long.parseLong(num.substring(pivot, i + 1)); // substring take +1 address to strip

            int length = path.length();

            if (pivot == 0) {

                path.append(cur);

                helper(num, target, cur, cur, i + 1, path, result);

                path.setLength(length);

            } else {

                //+
                path.append("+").append(cur);
                helper(num, target, calc + cur, cur, i + 1, path, result);
                path.setLength(length);

                //-
                path.append("-").append(cur);
                helper(num, target, calc - cur, -cur, i + 1, path, result);
                path.setLength(length);

                //*
                path.append("*").append(cur);
                helper(num, target, calc - tail + tail * cur, tail * cur, i + 1, path, result);
                path.setLength(length);

            }
        }
    }
}

// TC - 4*n
// SC - O(n)