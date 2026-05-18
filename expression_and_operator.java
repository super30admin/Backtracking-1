class Solution {
    List<String> result;
    public List<String> addOperators(String num, int target) {
        this.result = new ArrayList<>();
        helper(num,target,0,0,0, new StringBuilder());
        return result;
    }
    private void helper(String num,int target, int pivot, long calc, long tail, StringBuilder path){
        //base 
        if(pivot==num.length()) {
            if(calc == target){
                result.add(path.toString());
            }
        }
        //logic 
        for(int i=pivot;i<num.length();i++){
            if(num.charAt(pivot) == '0' && i != pivot) break; // preoccuring zero
            long curr = Long.parseLong(num.substring(pivot,i+1));
            int le = path.length(); // stack variable 
            if(pivot==0){
                path.append(curr);
                helper(num,target,i+1,curr,curr,path);
                path.setLength(le);
            }else{
                //+
                path.append("+").append(curr);
                helper(num,target,i+1,calc+curr,curr,path);
                path.setLength(le); 
                //-
                path.append("-").append(curr);
                helper(num,target,i+1,calc-curr,-curr,path); // why - sign ?? 
                path.setLength(le);
                //*
                path.append("*").append(curr);
                helper(num,target,i+1,calc-tail+(tail*curr),tail*curr,path);
                path.setLength(le);
            }
        }
    }
}