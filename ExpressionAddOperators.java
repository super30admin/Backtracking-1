class Solution {
	//Time Complexity:O(3^n)
	//Space Complexity:O(n) Only the stack space for every character
    List<String> res = new ArrayList<>();
    public List<String> addOperators(String num, int target) {

       recurse (num, target, 0,0,0, ""); 
       return res;
    }

        private void recurse(String num, int target, int index, long current ,long tail,String path){
            // base 
            if (index == num.length()){
        if (current == target){
            res.add (path);
        }
        return;
            }
            //logic
        if (index == num.length()){
            return;
        }
        for (int i = index;i < num.length();i++){
            Long cur = Long.parseLong(num.substring(index, i+1));
            if (num.charAt(index) == '0' && i!= index){
                continue;
            }
           if (index == 0) {
           recurse(num, target,i+1,cur,cur, ""+cur);
           } else {
                // + operator
            recurse (num,target, i+1,current+cur, +cur,path+"+"+cur);

                // - operator
            recurse (num,target, i+1,current-cur, -cur,path+"-"+cur);

                //* operator
            recurse (num,target, i+1,current-tail + tail*cur, tail*cur,path+"*"+cur);
           }
        }
    }
}
