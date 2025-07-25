// TC O(2^n)
// SC O(length of num)
class Solution {
    List<String> result;
    // Using String - recursion not backtracking
    public List<String> addOperators(String num, int target) {
        if (num == null || num.length() == 0) {
            return new ArrayList<>();
        }

        result = new ArrayList<>();
        // recurse(num, 0, 0, 0, target, "");
        backtrack(num, 0, 0, 0, target, new StringBuilder());
        return result;
    }

    // Use StringBuilder for backtracking - this is preferred approach
    private void backtrack(String num, int index, long calc, long tail, int target, StringBuilder path) {
        if (index == num.length()) {
            if (target == calc) {
                result.add(path.toString());
            }
            return;
        }

        // we need to try all possible splits of the string — and that’s exactly 
        // what a for loop does in backtracking
        for (int i = index; i < num.length(); ++i) {

            // if the substring is more than oe char, it should not start with 0.
            // if index == i, then only one char. which is okay. 
            if (num.charAt(index) == '0' && i != index) {
                return;
            }

            long cur = Long.parseLong(num.substring(index, i + 1));

            int pathLen = path.length();

            if (index == 0) {
                backtrack(num, i + 1, cur, cur, target, path.append(cur));
                path.setLength(pathLen);
            } else {
                // multiple recursive calls - Try every possible operation with that number.
                backtrack(num, i + 1, calc + cur, +cur, target, path.append("+").append(cur));
                path.setLength(pathLen);

                backtrack(num, i + 1, calc - cur, -cur, target, path.append("-").append(cur));
                path.setLength(pathLen);

                backtrack(num, i + 1, calc - tail + (tail * cur), tail * cur, target, path.append("*").append(cur));
                path.setLength(pathLen);
            }            
        }  
    }

    private void recurse(String num, int index, long calc, long tail, int target, String path) {
        if (index == num.length()) {
            if (target == calc) {
                result.add(path);
            }
            return;
        }

        for (int i = index; i < num.length(); ++i) {

            // if the substring is more than oe char, it should not start with 0.
            // if index == i, then only one char. which is okay. 
            if (num.charAt(index) == '0' && i != index) {
                return;
            }

            long cur = Long.parseLong(num.substring(index, i + 1));



            if (index == 0) {
                recurse(num, i + 1, cur, cur, target, path + cur);
            } else {
                recurse(num, i + 1, calc + cur, +cur, target, path + "+" + cur);

                recurse(num, i + 1, calc - cur, -cur, target, path + "-" + cur);

                recurse(num, i + 1, calc - tail + (tail * cur), tail * cur, target, path + "*" + cur);
            }
        }
        
    }

    
}