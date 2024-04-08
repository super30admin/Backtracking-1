//combination sum
//time complexity O(N) and space O(n)
class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        result = new ArrayList<>();
        if(candidates==null || candidates.length==0) return result;

        helper(candidates,0,target,new ArrayList<>());


        return result;
        
    }

    public void helper(int[] candidates,int pivot, int target, List<Integer> path){
        //base case
        if(target==0){
            result.add(new ArrayList<>(path));
            return;
        }

        if(target<0) return;


        for(int i=pivot;i<candidates.length;i++){

            path.add(candidates[i]);
            helper(candidates,i,target-candidates[i],path);
            path.remove(path.size()-1);

        }
        
        
        
        

        

    }
}


//expression add operator
//Time complexity N * 4^N
class Solution {

    List<String> result; 
    public List<String> addOperators(String num, int target) {
        
        result = new ArrayList<>();

        helper(num,0,0,0,target,new StringBuilder());

        return result;
    }

    public void helper(String num, int pivot ,long cal, long tail, int target,StringBuilder path){

        //base
        if(pivot==num.length()){
            if(cal==target){
                result.add(path.toString());   
            }
            return;
        }



        //logic
        for(int i=pivot;i<num.length();i++){
            if(num.charAt(pivot)=='0' && pivot!=i) continue;
            int len = path.length();

            Long curr= Long.parseLong(num.substring(pivot,i+1)); 
            //action
            if(pivot==0){
                path.append(curr);
                helper(num,i+1,curr,curr,target,path);
                path.setLength(len);

            }else{

                //+
                path.append("+");
                path.append(curr);
                helper(num,i+1,cal+curr,curr,target,path);
                path.setLength(len);
                //-
                
                path.append("-");
                path.append(curr);
                helper(num,i+1,cal-curr,-curr,target,path);
                path.setLength(len);

                //*
                path.append("*");
                path.append(curr);
                helper(num,i+1,cal-tail+tail*curr,tail*curr,target,path);
                path.setLength(len);

            }
        }

    }
}
