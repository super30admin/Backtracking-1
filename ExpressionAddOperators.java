import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperators { //O(2^n) T.C, O(n) S.C where n is length of string
    static List<String> result;
    public static List<String> addOperators(String num, int target, int input) {
        result = new ArrayList<>();

        //input here is added only to run both regular recursion and backtracking from the same method call
        if(input == 1) recursion(num, target, "", 0, 0, 0);
        else if (input == 2) backtrack(num, target, new StringBuilder(), 0, 0, 0);
        else throw new RuntimeException("Valid input is 1 for regular recursion and 2 for backtracking");

        return result;
    }

    /**
     *
     * @param num input String with digits
     * @param target input target value to form
     * @param path Individual String path with operators
     * @param pivot start index
     * @param count calculated value of digits at each operation level
     * @param tail the most recently performed operation's value
     */
    static void recursion(String num, int target, String path, int pivot, long count, long tail) {
        //base
        if(pivot == num.length()) { //if the pivot reaches the length of the input
            if(count == target) { //and the calculated count is equal to the target
                result.add(path); //we have found a valid path
            }
            return;
        }

        //logic
        for(int i=pivot; i < num.length(); i++) { //for-loop-based recursion to form sub-strings
            //to handle leading zeroes
            if(i != pivot && num.charAt(pivot) == '0') continue; //if leading 0 is encountered, skip exploring this path

            long current = Long.parseLong(num.substring(pivot, i+1)); //store the long parsed substring value

            //recurse
            if(pivot == 0) { //if the first character, do not add any operators
                recursion(num, target, path+current, i+1, current, current);
            } else { //for all the other sub-strings,
                //add
                //append + between the sub-strings and add the current substring's value to the existing current
                //tail is actual current itself
                recursion(num, target, path+"+"+current, i+1, count+current, current);

                //sub
                //append - between the sub-strings and subtract the current substring's value from existing current
                //tail is the negation of current
                recursion(num, target, path+"-"+current, i+1, count-current, -current);

                //multiplication
                //append * between the sub-strings and multiplication is different because of BODMAS rule precedence
                //First, remove the previously operated tail value from current count and then add the multiplication
                //of this tail to the current. tail is also the existing tail multiplied by current.
                recursion(num, target, path+"*"+current, i+1,
                        count-tail+tail*current, tail*current);
            }
        }
    }

    /**
     *
     * @param num input String with digits
     * @param target input target value to form
     * @param sb StringBuilder to build string path and backtrack
     * @param pivot start index
     * @param count calculated value of digits at each operation level
     * @param tail the most recently performed operation's value
     */
    static void backtrack(String num, int target, StringBuilder sb, int pivot, long count, long tail) {
        //base
        if(pivot == num.length()) {
            if(count == target) {
                result.add(sb.toString());
            }
            return;
        }

        //logic
        //Instead of creating new strings each time, we use the same stringbuilder to form new string path
        for(int i=pivot; i < num.length(); i++) {
            //handling leading zeros
            if(i != pivot && num.charAt(pivot) == '0') break;

            int len = sb.length();
            long current = Long.parseLong(num.substring(pivot, i+1));

            if(pivot == 0) { //everything is the same as above except
                //action
                sb.append(current); //add the current to the stringbuilder

                //recurse
                backtrack(num, target, sb, i+1, current, current);

                //backtrack
                sb.setLength(len); //and after recursion, remove the current
            } else {
                //add
                //action
                sb.append("+").append(current); //for non-first character, append the operator sign before the current

                //recurse
                backtrack(num, target, sb, i+1, count+current, current);

                //backtrack
                sb.setLength(len);

                //sub
                //action
                sb.append("-").append(current);

                //recurse
                backtrack(num, target, sb, i+1, count-current, -current);

                //backtrack
                sb.setLength(len);

                //multiplication
                //action
                sb.append("*").append(current);

                //recurse
                backtrack(num, target, sb, i+1,
                        count-tail+tail*current, tail*current);

                //backtrack
                sb.setLength(len);
            }
        }
    }

    public static void main(String[] args) {
        String num = "12304";

        int target1 = 11;
        System.out.println("The ways " + num + " can be modified to include operators +,-,* to form "
                + target1 + " using regular recursion is: " + addOperators(num, target1, 1));

        int target2 = 9;
        System.out.println("The ways " + num + " can be modified to include operators +,-,* to form "
                + target2 + " using backtracking recursion is: " + addOperators(num, target2, 2));
    }
}