// Time Complexity:  O(n*(4^n))
// Space Complexity: O(n)
// where n is length of a string

class Solution {

    List<String> result;
    
    public List<String> addOperators(String num, int target) {
        
        result = new ArrayList<>();
        helper(num, target, 0, 0, 0, new StringBuilder());
        return result;

    }

    private void helper(String num, int target, int index, long calc, long tail, StringBuilder path) {

        // BASE
        if(index == num.length()) {                                                              // all the characters passed
            if(calc == target) {                                                                 // and we got the target
                result.add(path.toString());                                                     // append the path in result
            }
            return;
        }

        // ACTION
        for(int i=index; i<num.length(); i++) {

            if(i != index && num.charAt(index) == '0') {                                         // e.g. "05" index at '0', i at '5'
                continue;                                                                        // then continue as "1+05" = "1+5" and it would skip '0' which doesn't make sense
            }

            long curr = Long.parseLong(num.substring(index, i+1));                               // getting curr value
            int size = path.length();

            if(index == 0) {
                
                path.append(curr);
                helper(num, target, i+1, curr, curr, path);                                      // if it is first operand
                path.setLength(size);

            }
            else {

                path.append('+').append(curr);
                helper(num, target, i+1, calc + curr, curr, path);                               // 'Plus' operator
                path.setLength(size);

                path.append('-').append(curr);
                helper(num, target, i+1, calc - curr, -curr, path);                              // 'Minus' operator
                path.setLength(size);

                path.append('*').append(curr);
                helper(num, target, i+1, calc - tail + tail * curr, tail*curr, path);            // 'Multiplication' operator
                path.setLength(size);

            }
            
        }

    }

}






// // ******************** Another Method ********************
// //
// // Time Complexity:  O(n*(4^n))
// // Space Complexity: O(n)
// // where n is length of a string
// // there would be extra space covered by strings being created all the time we pass "path" string variable as it creates new string reference all the time.

// class Solution {

//     List<String> result;
    
//     public List<String> addOperators(String num, int target) {
        
//         result = new ArrayList<>();
//         helper(num, target, 0, 0, 0, "");
//         return result;

//     }

//     private void helper(String num, int target, int index, long calc, long tail, String path) {

//         // BASE
//         if(index == num.length()) {                                                                        // all the characters passed
//             if(calc == target) {                                                                           // and we got the target
//                 result.add(path);                                                                          // append the path in result
//             }
//             return;
//         }

//         // ACTION
//         for(int i=index; i<num.length(); i++) {

//             if(i != index && num.charAt(index) == '0') {                                                  // e.g. "05" index at '0', i at '5'
//                 continue;                                                                                 // then continue as "1+05" = "1+5" and it would skip '0' which doesn't make sense
//             }

//             long curr = Long.parseLong(num.substring(index, i+1));                                        // getting curr value

//             if(index == 0) {
//                 helper(num, target, i+1, curr, curr, path + curr);                                        // if it is first operand
//             }
//             else {
//                 helper(num, target, i+1, calc + curr, curr, path+'+'+curr);                               // 'Plus' operator
//                 helper(num, target, i+1, calc - curr, -curr, path+'-'+curr);                              // 'Minus' operator
//                 helper(num, target, i+1, calc - tail + tail * curr, tail*curr, path+'*'+curr);            // 'Multiplication' operator
//             }
            
//         }

//     }

// }







// // ******************** First Method with slight different representation ********************
// //
// // Time Complexity:           O(2n * 4^n)    = O(n*4^n)
// // Space Complexity:          O(n + n + n-1) = O(n)
// // where n is length of given String
// // Yes, this code ran successfully
// // No, I didn't face any problem in this problem statement

// import java.util.ArrayList;
// import java.util.List;

// public class ExpressionAddOpeartors {
//     public static void main(String[] args) {
//         String str = "105";
//         int target = 5;
//         SolutionExpressionAddOpeartors obj = new SolutionExpressionAddOpeartors();
//         List<String> list = obj.addOperators(str, target);
//         System.out.println(list);
//     }
// }


// class SolutionExpressionAddOpeartors {

//     private List<String> result;
//     private String num;
//     private int target;

//     public List<String> addOperators(String num, int target) {
//         this.result = new ArrayList<>();
//         this.num = num;
//         this.target = target;

//         addOperators(0,0,0,new ArrayList<>());

//         return result;
//     }

//     private void addOperators(int index, long val, long tail, List<String> ops) {

//         // BASE CASE
//         if(index == num.length()) {
//             if(val == target) {                             // got target using current combination
//                 StringBuilder sb = new StringBuilder();     // getting string from List<String> "ops"
//                 for(String op : ops) {
//                     sb.append(op);
//                 }
//                 result.add(sb.toString());                  // adding String to result
//             }
//             return;
//         }


//         // RECURSION
//         for(int i=index; i<num.length(); i++) {
//             String oprndStr = num.substring(index, i+1);
//             long oprndLong = Long.parseLong(oprndStr);

//             if(index == 0) {                                    // if first operand
//                 ops.add(oprndStr);                              // directly adding in "oprndStr"
//                 addOperators(
//                         i+1,
//                         oprndLong,
//                         oprndLong,
//                         ops
//                 );
//                 ops.remove(ops.size()-1);                 // bactracking
//             }

//             else {
//                 // add
//                 ops.add("+" + oprndStr);
//                 addOperators(
//                         i+1,
//                         val + oprndLong,
//                         oprndLong,
//                         ops
//                 );
//                 ops.remove(ops.size()-1);       // bactracking

//                 // sub
//                 ops.add("-" + oprndStr);
//                 addOperators(
//                         i+1,
//                         val - oprndLong,
//                         -oprndLong,
//                         ops
//                 );
//                 ops.remove(ops.size()-1);       // bactracking

//                 // mul
//                 ops.add("*" + oprndStr);
//                 addOperators(
//                         i+1,
//                         val - tail + (tail * oprndLong),
//                         tail * oprndLong,
//                         ops
//                 );
//                 ops.remove(ops.size()-1);       // bactracking

//                 // nothing
//             }

//             if(oprndStr.charAt(0) == '0')
//                 break;
//         }
//     }
// }

