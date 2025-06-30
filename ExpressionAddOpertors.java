class Solution {
    //Backtracking Solution : Using StringBuilder avoids creating many new strings (path + "+" + curr creates a new string every time)
    public List<String> addOperators(String num, int target) {
        List<String>output = new ArrayList<>();
        helper(num , 0 , new StringBuilder(), 0L , 0L , target , output);
        return output;
    }
    private void helper(String num , int pivot , StringBuilder path , long calc , long tail , int target , List<String>output ){
        //base
        if(pivot == num.length()){
            if(calc == target){
                output.add(path.toString());
            }
            return ; 
        }

        //logic
        for(int i = pivot ; i < num.length() ; i++){
            //precedding zeroes
            if (num.charAt(pivot) == '0' && i > pivot) {
                break;  // stop further processing this substring and larger ones starting with '0'
            }

            //step 1 :in the top layer form all possible numbers
            long curr = Long.parseLong(num.substring(pivot , i+1)); //i+1 as substring takes one extra index and long to prevent integr overflow in large input cases
            int l = path.length();
            if(pivot == 0){ //top layer - we dont have operators , we only have ealier path+substring. In top layer earlier path is []  
               path.append(curr); //action
               helper(num , i+1 , path  , curr , curr , target , output); //recurse
               path.setLength(l); //l is earlier length
            }
            else{
                //addition
                path.append("+").append(curr); //action
                helper(num , i+1 , path , calc + curr , curr , target , output); //recurse
                path.setLength(l); //backtrack
                //subtraction
                path.append("-").append(curr); //action
                helper(num , i+1 , path  , calc - curr , -curr , target , output); //recurse
                path.setLength(l);
                //multiplication
                path.append("*").append(curr); //action
                helper(num , i+1 , path , (calc - tail) + (tail * curr) , tail*curr ,target , output); //recurse
                path.setLength(l); //backtrack
            }



        }
    }

    //Recursive Solution
    // public List<String> addOperators(String num, int target) {
    //     List<String>output = new ArrayList<>();
    //     helper(num , 0 , "" , 0L , 0L , target , output);
    //     return output;
    // }
    // private void helper(String num , int pivot , String path , long calc , long tail , int target , List<String>output ){
    //     //base
    //     if(pivot == num.length()){
    //         if(calc == target){
    //             output.add(path);
    //         }
    //         return ; 
    //     }

    //     //logic
    //     for(int i = pivot ; i < num.length() ; i++){
    //         //precedding zeroes
    //         if (num.charAt(pivot) == '0' && i > pivot) {
    //             break;  // stop further processing this substring and larger ones starting with '0'
    //         }

    //         //step 1 :in the top layer form all possible numbers
    //         long curr = Long.parseLong(num.substring(pivot , i+1)); //i+1 as substring takes one extra index and long to prevent integr overflow in large input cases
    //         if(pivot == 0){ //top layer - we dont have operators , we only have ealier path+substring. In top layer earlier path is []
    //            helper(num , i+1 , path + curr , curr , curr , target , output);
    //         }
    //         else{
    //             //addition
    //             helper(num , i+1 , path + "+" + curr , calc + curr , curr , target , output);
    //             //subtraction
    //             helper(num , i+1 , path + "-" + curr , calc - curr , -curr , target , output);
    //             //multiplication
    //             helper(num , i+1 , path + "*" + curr , (calc - tail) + (tail * curr) , tail*curr ,target , output);
    //         }



    //     }
    // }
}