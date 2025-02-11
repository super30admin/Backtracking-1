// TC: O(4^n)
// SC: O(n)
// where n is the length of the input string num

import java.util.ArrayList;
import java.util.List;

public class LC282 {
    List<String> ans = new ArrayList<>();
    private void recurse(String num, int n, int target, int pos, long cal, long tail, String sb){
        // Base Case
        if(pos==n){
            if(cal==target) ans.add(sb);
            return;
        }

        // Logic
        for(int i=pos;i<n;i++){
            if(num.charAt(pos)=='0' && i>pos) break;
            String ss = num.substring(pos, i+1);
            long newNum = Long.parseLong(ss);
            if(pos==0){
                recurse(num, n, target, i+1, newNum, newNum, sb + ss);
            } else {
                // Addition
                recurse(num, n, target, i+1, cal+newNum, +newNum, sb+"+"+ss);
                // Subtraction
                recurse(num, n, target, i+1, cal-newNum, -newNum, sb+"-"+ss);
                // Multiplication
                long prev = cal - tail;
                long newMulti = tail * newNum;
                long fin = prev + newMulti;
                recurse(num, n, target, i+1, fin, newMulti, sb+"*"+ss);
            }
        }
    }
    public List<String> addOperators(String num, int target) {
        if(num==null || num.length()==0) return ans;
        recurse(num, num.length(), target, 0, 0, 0, "");
        return ans;
    }
}
