// Time Complexity : O(4^n) n - length of the string
// Space Complexity : O(4^n) recursive stack space.
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
import java.util.*;
class Solution {

    private void dfs(String s, int target,  int pivot, long sum, long tail, StringBuilder path, List<String> result)
    {
        if(pivot == s.length())
        {
            if(sum == target)
            {
                result.add(path.toString());
                return;
            }
        }

        for(int i=pivot; i<s.length(); i++)
        {
            if(pivot!= i && s.charAt(pivot) == '0') break;
            String str = s.substring(pivot, i+1);
            long curr = Long.parseLong(str);
            int len = path.toString().length();
            if(pivot == 0){
               path.append(curr); 
               dfs(s, target, i + 1, curr, curr, path, result); 
               path.setLength(len);

           } else {
            //Addition
            path.append('+');
            path.append(curr);
            dfs(s, target, i+1, sum+curr, curr, path, result);
            path.setLength(len);

            //substraction
            path.append('-');
            path.append(curr);
            dfs(s, target, i+1, sum-curr, -curr, path, result);
            path.setLength(len);

            //multiplication
            path.append('*');
            path.append(curr);
            dfs(s, target, i+1, sum-tail + tail*curr, tail*curr, path, result);
            path.setLength(len);
           }
        }
    }
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        dfs(num, target, 0, 0L, 0L, new StringBuilder(), result);
        return result;
    }
}