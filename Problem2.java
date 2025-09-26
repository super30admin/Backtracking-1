// Time Complexity : O(4ⁿ * n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//Using recusion we first get the substrings of the the given num string
//we either have a case with operators or without operators
//with operators we further recursively caluclate the expression and evualthe res which will be calc value and curr will be the number being evaluated
//Tail value is being stored which would be the change that we apply at each call
//For +, calculate val = calc + cur and tail val = +cur
//For -, calculate val = calc - cur and tail val = -cur
//For *, to adhere to BODMAS rule, calculate val = calc - tail + (tail * cur) and tail val = (tail * cur)

class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        helper(num, 0, 0l, 0l, "", target, res);
        return res;
    }

    private void helper(String num, int pivot, long calc, long tail,String path, int target, List<String> res) {
        //base
        if(pivot == num.length()) {
            if(target == calc) {
                res.add(path);
                return;
            }
        }

        //logic
        //form the numbers
        for(int i = pivot; i < num.length(); i++) {
            //preceeding 0 case
            if(num.charAt(pivot) == '0' && i != pivot) continue;
            Long curr = Long.parseLong(num.substring(pivot, i+1));
            
            if(pivot == 0) {
                //no operators present at pivot 0
                helper(num, i + 1, curr, curr, path + curr, target, res);
            } else {
                //three cases
                //case 1: +
                helper(num, i+1, calc + curr, curr, path + "+" + curr, target, res);
                //case 2: -
                helper(num, i+1, calc - curr, -curr, path + "-" + curr, target, res);
                //case 3: *
                helper(num, i+1, calc -tail + (tail * curr), tail * curr, path + "*" + curr, target, res);
            }

        }
    }
}
