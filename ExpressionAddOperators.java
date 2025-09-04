// Idea is to use an exhaustive approach to generate all possible combinations.
// To optimize on space we backtrack the path formed 

//Time Complexity: O(3^n)
//Space Complexity: O(n)

public class ExpressionAddOperators {
    public List<String> result;
    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();
        String currNumStr ;
        for(int i=1;i<=num.length();i++)
        {
            currNumStr = num.substring(0,i);
            if(currNumStr.length()>1 && currNumStr.charAt(0)=='0')
            {
                continue;
            }
            long curNum = Long.parseLong(currNumStr);
            helper(num,target,i,curNum,curNum,currNumStr);
        }
        
        return result;
    }

    private void helper(String num,int target,int index,long currVal,long prevNum,String path)
    {
     if(index==num.length()){
      if(currVal==target)
      {
        result.add(path.toString());
        return;
      }
     }
     for(int i=index+1;i<=num.length();i++)
     {
        String nextNumStr = num.substring(index,i);
        if (nextNumStr.length() > 1 && nextNumStr.charAt(0) == '0') {
            break; // Stop if there's a leading zero
        }
        long nextNum = Long.parseLong(nextNumStr);    
        helper(num,target,i,currVal+nextNum,nextNum,path+"+"+nextNumStr);
        helper(num,target,i,currVal-nextNum,-nextNum,path+"-"+nextNumStr);  
        helper(num,target,i,currVal-prevNum+(prevNum*nextNum),prevNum*nextNum, path+"*"+nextNumStr);  
     }
    }
}
