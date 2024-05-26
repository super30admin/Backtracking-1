import java.util.ArrayList;
import java.util.List;

class Solution {
    List<String> result;
    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();
        helper(num, 0, 0, 0, target, new StringBuilder());
        return result;
    }

    private void helper(String num, long calc, long tail, int pivot, int target, StringBuilder path)
    {
        //base
        if(pivot == num.length())
        {
            if(calc == target)
            {
                result.add(path.toString());
            }
            return;
        }

        //logic
        for(int i= pivot; i<num.length(); i++)
        {
            if(num.charAt(pivot) == '0' && pivot != i) continue;
            Long curr = Long.parseLong(num.substring(pivot, i+1));
            int len = path.length();
            //make combinations

            if(pivot == 0)
            {
                //action
                path.append(curr); //*234  +2345678

                //recurse
                helper(num, curr, curr, i+1, target, path);

                //backtrack
                path.setLength(len);
            }
            else
            {
                //+
                path.append("+");
                path.append(curr); //*234  +2345678
                helper(num, calc+curr, curr, i+1, target, path);

                //-
                path.append("-");
                path.append(curr); //*234  +2345678
                helper(num, calc-curr, -curr, i+1, target, path);

                //*
                path.append("*");
                path.append(curr); //*234  +2345678
                helper(num, calc-tail + tail*curr, tail*curr, i+1, target, path);
            }
        }

    }
}