//Way1
//Generate all possible numbers
//Apply all possible combinations
//Once last index is reached, check whether target is made or not
//If equals to target, add to result
//TC: O(4ⁿ * n
//SC: n^2
class Solution {
    List<String> result;
    public List<String> addOperators(String num, int target) {
        this.result=new ArrayList<>();
        helper(num,0,0,0,"",target);
        return result;
        
    }

    private void helper(String num, int pivot, long calc, long prev, String path, int target){
        //
        if(pivot==num.length()){
            if(calc==target){
                result.add(path);
                return;
            }
        }



        for(int i=pivot;i<num.length();i++){
            if(num.charAt(pivot)=='0' && i!=pivot) break;
            long curr=Long.parseLong(num.substring(pivot,i+1));
            if(pivot==0){
                helper(num,i+1,curr,curr,path + curr,target);
            }else{
                //+
                helper(num,i+1,calc+curr,curr,path + '+' + curr,target);


                //-
                helper(num,i+1,calc-curr,-curr,path + '-' + curr,target);


                //*
                helper(num,i+1,calc-prev+prev*curr,curr*prev,path + '*' + curr,target);
            }
        }
    }
}


//way2
//Same prev approach - with string builder
//Generate all possible numbers
//Apply all possible combinations
//Once last index is reached, check whether target is made or not
//If equals to target, add to result
//TC: O(4^n)
//SC: n
class Solution {
    List<String> result;
    public List<String> addOperators(String num, int target) {
        this.result=new ArrayList<>();
        helper(num,0,0,0,new StringBuilder(),target);
        return result;
        
    }

    private void helper(String num, int pivot, long calc, long prev, StringBuilder path, int target){
        //
        if(pivot==num.length()){
            if(calc==target){
                result.add(path.toString());
                return;
            }
        }



        for(int i=pivot;i<num.length();i++){
            if(num.charAt(pivot)=='0' && i!=pivot) break;
            long curr=Long.parseLong(num.substring(pivot,i+1));
            if(pivot==0){
                int len=path.length();
                path.append(curr);
                helper(num,i+1,curr,curr,path,target);
                path.setLength(len);
            }else{
                //+
                int len=path.length();
                path.append('+');
                path.append(curr);
                helper(num,i+1,calc+curr,curr,path,target);
                path.setLength(len);


                //-
                 len=path.length();
                path.append('-');
                path.append(curr);
                helper(num,i+1,calc-curr,-curr,path,target);
                path.setLength(len);


                //*
                 len=path.length();
                path.append('*');
                path.append(curr);
                helper(num,i+1,calc-prev+prev*curr,curr*prev,path,target);
                path.setLength(len);
            }
        }
    }
}
