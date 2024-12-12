/*
 * TC - O(4^n)
 */
import java.util.ArrayList;
import java.util.List;

public class EvaluationAdd {
    //with backtracking and stringbuilder
    List<String> result;
    public List<String> addOperators(String num, int target) {
        this.result =  new ArrayList<>();
        helper(num, 0,0l,0l,new StringBuilder(),target);
        return result;
    }

    private void helper(String num, int pivot, long calc, long tail, StringBuilder path, int target){
        //base 
        if(pivot == num.length() && calc == target){
            result.add(path.toString());
        }
        
        //logic 
        for(int i = pivot;i < num.length(); i++){
            if(num.charAt(pivot) == '0' && i!= pivot){
                continue;
            }
            int le = path.length();
            long currNum = Long.parseLong(num.substring(pivot,i+1));
            if(pivot == 0){
                //at first we dont have any operators thats why
                path.append(currNum);
                helper(num, i+1, currNum, currNum, path, target);
                path.setLength(le);
            }
            else{
                path.append("+");
                path.append(currNum);
                helper(num, i+1, calc + currNum, currNum, path,target);
                path.setLength(le);

                path.append("-");
                path.append(currNum);
                helper(num, i+1, calc - currNum, -currNum, path,target);
                path.setLength(le);
                
                path.append("*");
                path.append(currNum);
                helper(num, i+1, (calc - tail) + (tail * currNum), tail*currNum, path,target);
                path.setLength(le);
            }

        }

    }

    //without backtracking - O(4^n)
    // List<String> result;
    // public List<String> addOperators(String num, int target) {
    //     this.result =  new ArrayList<>();
    //     helper(num, 0,0l,0l,"",target);
    //     return result;
    // }

    // private void helper(String num, int pivot, long calc, long tail, String path, int target){
    //     //base 
    //     if(pivot == num.length() && calc == target){
    //         result.add(path);
    //     }
        
    //     //logic 
    //     for(int i = pivot;i < num.length(); i++){
    //         if(num.charAt(pivot) == '0' && i!= pivot){
    //             continue;
    //         }
    //         long currNum = Long.parseLong(num.substring(pivot,i+1));
    //         if(pivot == 0){
    //             //at first we dont have any operators thats why
    //             helper(num, i+1, currNum, currNum, path+currNum, target);
    //         }
    //         else{
    //             helper(num, i+1, calc + currNum, currNum, path+"+"+currNum,target);
    //             helper(num, i+1, calc - currNum, -currNum, path+"-"+currNum,target);
    //             helper(num, i+1, (calc - tail) + (tail * currNum), tail*currNum, path+"*"+currNum,target);
    //         }

    //     }

    // }
}
