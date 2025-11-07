// Time Complexity :O(4^n * n)
// Space Complexity :O(n^2)
// Did this code successfully run on Leetcode :yes
//     | calc val             |   tail
//   + | calc+curr            |   curr    
//   - | calc-curr            |   -curr
//   * | calc-tail+tail*curr  |  tail*curr

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> answer = new ArrayList<>();
        helper(num, target, 0, 0, 0, "",answer);
        return answer;
    }
    private void helper(String num, int target, int pivot, long calc, long tail, String path, List<String> answer ) {
        if (pivot == num.length()) {
            if (calc == target) {
                answer.add(path);
            }
        }
        for (int i = pivot; i < num.length(); i++) {
            if (num.charAt(pivot) == '0' && i != pivot) break; // preceding 0 case
            long curr = Long.parseLong(num.substring(pivot, i + 1));
            if (pivot == 0) {
                helper(num, target, i + 1, curr, curr, path + curr, answer);
            } else {
                // +
                helper(num, target, i + 1, calc + curr, curr, path + "+" + curr, answer);
                // -
                helper(num, target, i + 1, calc - curr, -curr, path + "-" + curr, answer);
                // *
                helper(num, target, i + 1, calc - tail + (tail * curr), tail * curr, path + "*" + curr, answer);
            }
        }
    }
}
