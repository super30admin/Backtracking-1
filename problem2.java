// Time Complexity : O(4^n)
// Space Complexity :O(1)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :yes

/*
 * Approach
 * we are using recusion and backstack here to solve the problem
 * 
 * idea here is to check all the combination of -,+,* with all the combination of of digit utilising all the digits
 * 
 * for the recusion we keep track of the current calcuation and how it was achived(this is used to follow the rules of BOADMAS)
 * in the recusion we start using a for loop, we check if the pivot is at 0 that mean we are at the first level where we will only take the number
 * else we start 3 recursion calls, for "-","+","*" and we backstack each time the recursive call is done
 * need to be aware of one edge case we pivot index of word is "0" because it will create strings like 1+0*5 that is not acceptable
 * 
 * the way we keep BOADMAS rule valid is by doing the follow
 * 
 * for - (calc - cur)(-cur)
 * for + (calc + cur)(cur)
 * for * (calc - tail + tail*cur)(tail*cur)
 * for / (calc - tail + tail/cur)(tail/cur)(not need for this problem but can be done)
 * 
 * 
 */

class Solution {
    List<String> result;

    public List<String> addOperators(String num, int target) {
        this.result = new ArrayList<>();
        StringBuilder path = new StringBuilder();
        helper(num, target, path, 0, 0l, 0l);
        return result;
    }

    private void helper(String num, int target, StringBuilder path, int pivot, long calc, long tail) {
        // base
        if (pivot == num.length()) {
            if (target == calc) {
                result.add(path.toString());
            }

        }
        int le = path.length();

        // logic
        for (int i = pivot; i < num.length(); i++) {
            //
            if (i != pivot && num.charAt(pivot) == '0')
                continue;
            long cur = Long.parseLong(num.substring(pivot, i + 1));
            if (pivot == 0) {
                path.append(cur);
                helper(num, target, path, i + 1, cur, cur);
                path.setLength(le);
            } else {
                // -
                // add
                path.append("-").append(cur);
                // recurse
                helper(num, target, path, i + 1, calc - cur, -cur);
                // backtrack
                path.setLength(le);

                // +
                // add
                path.append("+").append(cur);
                // recurse
                helper(num, target, path, i + 1, calc + cur, cur);
                // backtrack
                path.setLength(le);

                // *
                // add
                path.append("*").append(cur);
                // recurse
                helper(num, target, path, i + 1, calc - tail + tail * cur, tail * cur);
                // backtrack
                path.setLength(le);
            }
        }
    }
}