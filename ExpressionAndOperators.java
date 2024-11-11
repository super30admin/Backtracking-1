// constraints: length of number is not going to be more than 10
// target is the length of integer -> declare long
// should not contain leading zeros -> ?
// edge case: what if the number itself is the expression? -> yes
// num can also have 0, any multiplication with 0 will be 0 - any addition or subtraction will not matter

// various combinations
// return is a list of strings

// we also will have to combine digits to subtract or add to, to get the result
//eg: "105" -> 10-5 and 1*0+5

// try all possible operations on all possible combinations
// with bodmas, we know that multiplication has to come first followed by add, subtract
// our solution should not involve revaluating the computation again and again

//step 1: only get the various numbers from the string using for loop based recurssion
//step 2: introduce the operators
// for * operator: calc - tail + tail * curr -> to not recompute the solution
// with every new string, new reference is created, thus we do not do new string when storing path in result

//tc: O(4^n) -> where we do or not have any expression
//sc: O(n)

class Solution {

  List<String> result;

  public List<String> addOperators(String num, int target) {
    this.result = new ArrayList<>();
    helper(num, 0, "", 0, 0, target);
    return result;
  }

  private void helper(
    String num,
    int pivot,
    String path,
    long calc,
    long tail,
    int target
  ) {
    //base
    if (pivot == num.length()) {
      if (target == calc) {
        result.add(path);
        return;
      }
    }
    //logic
    for (int i = pivot; i < num.length(); i++) {
      // leading zeros **
      if (num.charAt(pivot) == '0' && pivot != i) continue;
      long curr = Long.parseLong(num.substring(pivot, i + 1));

      if (pivot == 0) {
        helper(num, i + 1, path + curr, curr, curr, target);
      } else {
        helper(num, i + 1, path + "+" + curr, calc + curr, curr, target);
        helper(num, i + 1, path + "-" + curr, calc - curr, -curr, target);
        helper(
          num,
          i + 1,
          path + "*" + curr,
          calc - tail + tail * curr,
          tail * curr,
          target
        );
      }
    }
  }
}
