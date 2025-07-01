// Time complexity : 4^n

import java.util.ArrayList;
public class Expressions {
    String num = "123";
    int target = 6;
    ArrayList<String> result = new ArrayList<String>();

    public void calculate_expression() {
        helper(0, 0, 0, "");
        System.out.println(result);
    }

    public void helper(int pivot, int calc, int tail, String path) {
        // base condition
        if (pivot == num.length()) {
            if (calc == target) {
                result.add(path);
                return;
            }
        }

        // logic
        for (int i = pivot; i < num.length(); i++) {

            if (num.charAt(i) == '0' && pivot != i) return;
            int number = Integer.parseInt(num.substring(pivot, i+1));

            if (pivot == 0) {
                helper(i+1, number, number, path+number);
            } else {
                // case +
                helper(i+1, calc+number, number, path + "+" + number);

                // case -
                helper(i+1, calc-number, -number, path + "-" + number);

                // case *
                helper(i+1, calc-tail+tail*number, tail*number, path + "*" + number);

            }
            
        }
    }

    public static void main(String [] args) {
        Expressions es = new Expressions();
        es.calculate_expression();
    }
    
}
