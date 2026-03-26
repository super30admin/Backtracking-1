    /**
    Time Complexity : Exponential, approximately O(4^N)
    Explanation:
    At each position, we try different partitions of the number
    and for each partition we try three operators:
        +, -, *
    So the total number of recursive states grows exponentially.

    Space Complexity : O(N)
    Explanation:
    Recursion depth can go up to N and StringBuilder path also holds
    up to N characters/operators along one recursive path.

    Did this code successfully run on LeetCode : Yes

    Any problem you faced while coding this :
    Initially the difficult part was handling multiplication,
    because multiplication has higher precedence than + and -.
    Fixed it by keeping track of the previous operand using 'tail'.
    So when '*' is used:
        calc = calc - tail + tail * curr
    Also had to carefully handle numbers with leading zeros
    like "05", which are not valid.
    */
    class Solution {



        List<String> res;
    
        public List<String> addOperators(String num, int target) {
    
            this.res = new LinkedList<>();
            helper(num, 0, 0L, 0L, new StringBuilder(), target);
            return res;
        }
    
        private void helper(String num, int pivot, long calc, long tail, StringBuilder path, int target) {
    
            // Base case
            if (pivot == num.length()) {
                if (calc == target) {
                    res.add(path.toString());
                }
                return;
            }
    
            // Try every possible next number
            for (int i = pivot; i < num.length(); i++) {
    
                // Skip numbers with leading zero
                if (num.charAt(pivot) == '0' && pivot != i) break;
    
                long curr = Long.parseLong(num.substring(pivot, i + 1));
    
                if (pivot == 0) {
                    // First number, no operator before it
                    int pl = path.length();
                    path.append(curr);
                    helper(num, i + 1, curr, curr, path, target);
                    path.setLength(pl);
                } else {
                    // Addition
                    int pl = path.length();
                    path.append("+").append(curr);
                    helper(num, i + 1, calc + curr, curr, path, target);
                    path.setLength(pl);
    
                    // Subtraction
                    pl = path.length();
                    path.append("-").append(curr);
                    helper(num, i + 1, calc - curr, -curr, path, target);
                    path.setLength(pl);
    
                    // Multiplication
                    pl = path.length();
                    path.append("*").append(curr);
                    helper(num, i + 1, calc - tail + tail * curr, tail * curr, path, target);
                    path.setLength(pl);
                }
            }
        }
    }