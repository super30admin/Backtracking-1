// Time Complexity : O(3^n)
// Space Complexity : O(n+k)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

// Recursion
/*class Solution {
    List<String> result;
    public List<String> addOperators(String num, int target) {
        result = new ArrayList<>();
        if(num == null) return result;
        recurse(num, target, 0, 0, 0, "");
        return result;
    }

    void recurse(String num, int target, int index, long calc, long tail, String path) {
        // Base
        if(index == num.length() && calc == target) {
            result.add(path);
        }
        // Logic
        for(int i = index; i<num.length(); i++) {
            if(num.charAt(index) == '0' && index!=i) continue;
            long current = Long.parseLong(num.substring(index, i+1));
            if(index == 0) {
                recurse(num, target, i+1, current, current, path+current);
            }else {
                // + case
                recurse(num, target, i+1, calc+current, +current, path+"+"+current);
                // - case
                recurse(num, target, i+1, calc-current, -current, path+"-"+current);
                // * case
                recurse(num, target, i+1, calc-tail + tail*current, tail*current, path+"*"+current);
            }
        }

    }
}*/

// Backtracking
class Solution {
  List<String> result;
  public List<String> addOperators(String num, int target) {
    result = new ArrayList<>();
    if(num == null || num.length() == 0) return result;
    recurse(num, target, 0, 0, 0, new StringBuilder());
    return result;
  }

  void recurse(String num, int target, int index, long calc, long tail, StringBuilder path) {
    // Base
    if(index == num.length() && calc == target) {
      result.add(path.toString());
      return;
    }
    // Logic
    for(int i = index; i<num.length(); i++) {
      if(num.charAt(index) == '0' && index!=i) continue;
      long current = Long.parseLong(num.substring(index, i+1));
      int pathLength = path.length();
      if(index == 0) {
        path.append(current);
        recurse(num, target, i+1, current, current, path);
        path.setLength(pathLength);
      }else {
        // + case
        path.append("+").append(current);
        recurse(num, target, i+1, calc+current, +current, path);
        path.setLength(pathLength);
        // - case
        path.append("-").append(current);
        recurse(num, target, i+1, calc-current, -current, path);
        path.setLength(pathLength);
        // * case
        path.append("*").append(current);
        recurse(num, target, i+1, calc-tail + tail*current, tail*current, path);
        path.setLength(pathLength);
      }
    }

  }
}