class Solution {
    List<String> res;
    public List<String> addOperators(String num, int target) {
        res=new ArrayList<>();
        helper(num,0,0,0,target,"");
        return res;
    }
    private void helper(String num, int pivot, long calc, long tail, int target, String path){
        if(calc==target && pivot==num.length()){
            res.add(path);
        }

        long currNum=0;
        for(int i=pivot;i<num.length();i++){
            currNum=currNum*10+num.charAt(i)-'0';
            if(pivot==0){
                helper(num,i+1,currNum,currNum,target,path+currNum);
            }
            else{
                long ncalc = calc+currNum;
                helper(num,i+1,ncalc,currNum,target,path+"+"+currNum);

                ncalc= calc-currNum;
                helper(num,i+1,ncalc,-currNum,target,path+"-"+currNum);

                ncalc= calc-tail+tail*currNum;
                helper(num,i+1,ncalc,tail*currNum,target,path+"*"+currNum);
            }
            if(currNum==0) break;
        }
    }
}
