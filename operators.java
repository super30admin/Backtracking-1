// TC:3*2^n
// SC: 3*2^n

class Solution {
    List<String> result;
    public List<String> addOperators(String num, int target) {
       this.result = new ArrayList<>();
        helper(num,0,new StringBuilder(),0,0,target);
        return result;
    }

    private void helper(String num, int pivot, StringBuilder path, long calc, long tail, int target){
        
        // base
        if(pivot==num.length()){
            if(calc==target){
                result.add(path.toString());
            }
            return;
        }
        // logic
        for(int i=pivot;i<num.length();i++){
            // preceding zero
        if(num.charAt(pivot)=='0'&&i!=pivot) continue;
            long curr = Long.parseLong(num.substring(pivot,i+1));
            int len = path.toString().length();
            if(pivot==0){
                // action
                path.append(curr);
                // recurse
                helper(num,i+1,path,curr,curr,target);
                // backtrack
                path.setLength(len);
            }else{
                path.append("+");
                path.append(curr);
                helper(num,i+1,path,calc+curr,curr,target);
                path.setLength(len);

                path.append("-");
                path.append(curr);
                helper(num,i+1,path,calc-curr,-curr,target);
                path.setLength(len);

                path.append("*");
                path.append(curr);
                helper(num,i+1,path,calc-tail+tail*curr,curr*tail,target);
                path.setLength(len);
            }
        }
    }
}