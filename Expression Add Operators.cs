/*
  Time complexity: O(n*4^n)
  Space complexity: O(n*4^n)
*/

public class Solution {
    public IList<string> AddOperators(string num, int target) {
        List<string> result = new();

        helper(num,0,new StringBuilder(),0L,0L,target,result);

        return result;
    }

    private void helper(string num, int pivot, StringBuilder path, long calc, long tail, int target, List<string> result)
    {
        //base
        if(pivot==num.Length)
        {
            if(calc==target)
                result.Add(path.ToString());

            return;
        }
        //logic
        for(int i=pivot;i<num.Length;i++)
        {
            if (i != pivot && num[pivot] == '0') break;
            long current = long.Parse(num.Substring(pivot,i-pivot+1));
            int len = path.ToString().Length;
            if(pivot==0)
            {
                path.Append(current);
                helper(num,i+1,path,current,current,target,result);
                path.Length=len;
            }
            else
            {
                //+
                path.Append("+"+current);
                helper(num, i+1, path, calc+current, current,target,result);
                path.Length=len;
                //-
                path.Append("-"+current);
                helper(num, i+1, path, calc-current, -current,target,result);
                path.Length=len;
                //*
                path.Append("*"+current);
                helper(num, i+1, path, calc-tail+current*tail, current*tail,target,result);
                path.Length=len;
            }
        }
    }

}
