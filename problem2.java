// Time Complexity : O(4^n * n) 4^n directions (append, multiply, add, subtract) and each take n to copy toString
// Space Complexity : O(n) excluding output
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Approach : I traverse in all 4 directions and backtrack. I keep a track of current expression using a string builder and current value using a long, I use a tail which is the last the calculated operand - only when I am multiplying, I subtract this from the current number and add the multiplication of tail and number, I update the tail to be multiplication of tail and number

class Solution {
    List<String> res;
    public List<String> addOperators(String num, int target) {
        res = new ArrayList<>();
        helper(num, target, 0, 0, 0, new StringBuilder());
        return res;
    }
    public void helper(String num, int target, int idx, long current, long tail, StringBuilder expression){
        if(idx==num.length()){
            if(current==target) res.add(expression.toString());
            return;
        }
        for(int i = idx; i<num.length(); i++){
            // only the case when we consider just 0, but not 05 or anything else - should not start with 0 (when i is ahead of idx and idx character is 0, substring would be 0..x, so when we see idx char is 0, we only want to consider option when i=idx, basically, just the only number 0)
            if(num.charAt(idx)=='0' && i!=idx) break;
            long number = Long.valueOf(num.substring(idx, i+1));
            int len = expression.length();
            if(idx == 0) {
                expression.append(number);
                helper(num, target, i + 1, current+number, number, expression);
                expression.setLength(len);
            }
            else{
                // add
                expression.append("+" + number);
                helper(num, target, i + 1, current + number, number, expression);
                expression.setLength(len);
                // subtract
                expression.append("-" + number);
                helper(num, target, i + 1, current-number, -number, expression);
                expression.setLength(len);
                // multiply
                expression.append("*" + number);
                helper(num, target, i + 1, current - tail + tail*number, tail * number, expression);
                expression.setLength(len);
            }
        }
    }
}

// keep a track of last operand (tail), for adding or subtracking it is normal, for multiply, just subtract the operant from result and multiply it to the current number and add it to the result. Eg 1+2*3 -> 1+2 would have result as 3 and tail as 2, so 3-2 = 1, now 2*3 = 6, 1+6 = 7.