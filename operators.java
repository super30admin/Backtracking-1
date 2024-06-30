class Solution {
    List<String> res = new ArrayList<>();

    public List<String> addOperators(String num, int target) {
        backtrack(num, target, new StringBuilder(), 0, 0, 0);
        return res;

    }

    public void backtrack(String num, int target, StringBuilder path, int index, long cal, long tail) {
        // BASE
        if (index == num.length()) {
            if (cal == target) {
                res.add(path.toString());

            }
            return;
        }

        // FOR Loop
        for (int i = index; i < num.length(); i++) {
            int plength = path.length();
            if (num.charAt(index) == '0' && index != i) // we dont take trailing 0's 105 -> 1+5 not 1+0+5
                continue;
            long curr = Long.parseLong(num.substring(index, i + 1)); // extracting the string
            if (index == 0) { // if it the first number in the string
                path.append(curr); // just append the character, as no operators are encountered
                backtrack(num, target, path, i + 1, curr, curr);
                path.setLength(plength);
            } else {
                
                path.append("+");
                path.append(curr);
                backtrack(num, target, path, i + 1, cal + curr, curr);
                path.setLength(plength); // make the path go from "1+2" to "1", undos the appending in line 32 and 33
                // before it goes to make the '-' operation, it will remove the '+' that was added above

                path.append("-");
                path.append(curr);
                backtrack(num, target, path, i + 1, cal - curr, -curr);
                path.setLength(plength);

                path.append("*");
                path.append(curr);
                backtrack(num, target, path, i + 1, cal - tail + tail * curr, tail * curr);
                path.setLength(plength);
            }

        }
    }
}