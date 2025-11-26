/**** Method 1 ****/
//Time Complexity: O((4^n)*n)
//Space Complexity: O(n^2)

//Successfully submitted in LeetCode

//To solve this problem, we store prev, with last completed operation and index, calculated values and string to hold the operations string. As we can partition the number at any index we take loop and run through all the partitions, and at each partition we have three options +,- and *, we perform the calculations, and when it *, as we can't directly do * as it will be left to right, we subtract the previous value from and add prev*curr, and store the previous as prev*curr as this will be helpful if there are consecutive *. For index is at 0 we don't have two numbers to perform operations, we just include the starting indexs and continue with recursion. Also to avoid  forming leading 0's we check if there are more than one consecutive zero and break if true. For base condition, we check we have reached at end of the string and the calculated value is equals to target then add it ans list.

/**** Method 2 ****/
//Time Complexity: O(4^n)
//Space Complexity: O(n)

//Successfully submitted in LeetCode

// Same process as above but we use backtracking with help of string builder by appending before recursive call and removing it after the call. This is decreases the time complexity as string operations are expensive.

import java.util.ArrayList;
import java.util.List;

public class _282_Expression_Add_Operators {

  public List<String> addOperators(String num, int target) {
    ArrayList<String> list = new ArrayList<>();

    helper(num, 0, target, 0, 0, "", list);

    return list;
  }

  private void helper(
    String num,
    int index,
    int target,
    long cal,
    long prev,
    String str,
    ArrayList<String> list
  ) {
    if (index == num.length()) {
      if (target == cal) {
        list.add(str);
      }
    }

    for (int i = index; i < num.length(); i++) {
      if (num.charAt(index) == '0' && i != index) break;
      long curr = Long.parseLong(num.substring(index, i + 1));

      if (index == 0) {
        helper(num, i + 1, target, curr, curr, str + curr, list);
      } else {
        helper(num, i + 1, target, cal + curr, curr, str + "+" + curr, list);
        helper(num, i + 1, target, cal - curr, -curr, str + "-" + curr, list);
        helper(
          num,
          i + 1,
          target,
          cal - prev + (prev * curr),
          prev * curr,
          str + "*" + curr,
          list
        );
      }
    }
  }

  public List<String> addOperators1(String num, int target) {
    ArrayList<String> list = new ArrayList<>();

    helper1(num, 0, target, 0, 0, new StringBuilder(), list);

    return list;
  }

  private void helper1(
    String num,
    int index,
    int target,
    long cal,
    long prev,
    StringBuilder stb,
    ArrayList<String> list
  ) {
    if (index == num.length()) {
      if (target == cal) {
        list.add(stb.toString());
      }
    }

    for (int i = index; i < num.length(); i++) {
      if (num.charAt(index) == '0' && i != index) break;
      String s = num.substring(index, i + 1);
      long curr = Long.parseLong(s);

      int le = stb.length();
      if (index == 0) {
        stb.append(s);
        helper1(num, i + 1, target, curr, curr, stb, list);
        stb.setLength(le);
      } else {
        stb.append("+").append(s);
        helper1(num, i + 1, target, cal + curr, curr, stb, list);
        stb.setLength(le);

        stb.append("-").append(s);
        helper1(num, i + 1, target, cal - curr, -curr, stb, list);
        stb.setLength(le);

        stb.append("*").append(s);
        helper1(
          num,
          i + 1,
          target,
          cal - prev + (prev * curr),
          prev * curr,
          stb,
          list
        );
        stb.setLength(le);
      }
    }
  }
}
