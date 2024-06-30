/*
    LC - 282. Expression Add Operators
    TC - O(4^N)
        Where N is the length of the input string 'num'.
    SC - O(N)
*/

class Solution {
    List<String> result;
    public List<String> addOperators(String num, int target) {
        if(num == null || num.length() == 0) {
            return new ArrayList<>();
        }
        result = new ArrayList<>();
        recurse(num, target, 0, 0, 0, "");
        return result;
    }
    public void recurse(String num, int target, int index, long calc, long tail, String path) {
        // base
        if(index == num.length()) {
            if(target == calc) {
                result.add(path);
            }
        }

        // logic
        for(int i=index; i<num.length(); i++) {
            if(num.charAt(index) == '0' && index !=i) {
                continue;
            }
            long curr = Long.parseLong(num.substring(index, i + 1));
            if(index == 0) {
                recurse(num, target, i+1, curr, curr, path + curr);
            } else {
                // "+ operator"
                recurse(num, target, i+1, calc + curr, +curr, path + "+" + curr);
                // "- operator"
                recurse(num, target, i+1, calc - curr, -curr, path + "-" + curr);
                // "* operator"
                recurse(num, target, i+1, calc - tail + tail * curr, tail * curr, path + "*" + curr);
            }
        }
    }
}
