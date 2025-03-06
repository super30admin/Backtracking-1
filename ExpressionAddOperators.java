// Time Complexity : 4^n
// Space Complexity : O(n)
import java.util.*;
class ExpressionaddOperators {
    List<String> res;
    public List<String> addOperators(String num, int target) {
        this.res = new ArrayList<>();
        helper(num, target, 0,0,0,new StringBuilder());
        return res;
    }
    private void helper(String num, int target, int pivot, long calc, long tail, StringBuilder path) {
        //base case
        if(pivot == num.length()) {
            if(calc == target) {
                res.add(path.toString());
            }
            return;
        }
        
        //logic
        for(int i = pivot; i < num.length(); i++) {
            long curr = Long.parseLong(num.substring(pivot, i+1));
            if(num.charAt(pivot) == '0' && pivot != i) continue;
            int len = path.length();
            if(pivot == 0) {
                path.append(curr);
                helper(num, target, i+1,curr, curr, path);
                path.setLength(len);
            } else {
                path.append("+").append(curr);
                helper(num, target, i+1,calc+curr, curr, path);
                path.setLength(len);
                path.append("-").append(curr);
                helper(num, target, i+1,calc-curr,-curr,path);
                path.setLength(len);
                path.append("*").append(curr);
                helper(num, target,i+1,(calc-tail)+(tail*curr),(tail*curr),path);
                path.setLength(len);
            }
        }
    }
}