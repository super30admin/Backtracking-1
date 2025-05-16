import java.util.ArrayList;
import java.util.List;

//Time Complexity: O(n)
// Space Complexity: O(n)

public class ExpressionAddOperators {
        List<String> al;
        public List<String> addOperators(String num, int target) {
            if(num == null || num.length() == 0){
                return new ArrayList<String>();
            }

            al = new ArrayList<>();
            recurse(num,target, 0,new StringBuilder(), 0, 0);
            return al;
        }

        public void recurse(String num, int target, int index, StringBuilder sb, long calc,long tail){
            if(index == num.length()){
                if(target == calc){
                    al.add(sb.toString());
                }
                return;
            }
            for(int i=index;i<num.length();i++){
                //if(num.charAt(index) == '0' && index != i) break;
                long curr = Long.parseLong(num.substring(index, i+ 1));
                int len = sb.toString().length();
                if(index==0){
                    sb.append(curr);
                    recurse(num, target, index+1, sb, calc+curr, curr);
                    sb.setLength(len);
                }else{
                    sb.append("+");//action
                    sb.append(curr);
                    recurse(num, target, index+1, sb, calc+curr, curr);
                    sb.setLength(len);

                    sb.append("-");//action
                    sb.append(curr);
                    recurse(num, target, index+1, sb, calc-curr, -curr);
                    sb.setLength(len);

                    sb.append("*");//action
                    sb.append(curr);
                    recurse(num, target, index+1, sb, calc-curr+tail*curr, tail*curr);
                    sb.setLength(len);
                }
            }
        }
}
