class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        if (num == null || num.length() == 0) return result;
        backtrack(result, num, target, 0, 0, 0, "");
        return result;
    }

    private void backtrack(List<String> result, String num, int target, int index, long currentValue, long lastValue, String expression) {
        if (index == num.length()) {
            if (currentValue == target) {
                result.add(expression);
            }
            return;
        }
        
        for (int i = index; i < num.length(); i++) {
            // Avoid numbers with leading zeros
            if (i != index && num.charAt(index) == '0') break;
            
            String currentStr = num.substring(index, i + 1);
            long currentNum = Long.parseLong(currentStr);
            
            if (index == 0) {
                // First number, pick it without any operator
                backtrack(result, num, target, i + 1, currentNum, currentNum, currentStr);
            } else {
                // Try addition
                backtrack(result, num, target, i + 1, currentValue + currentNum, currentNum, expression + "+" + currentStr);
                
                // Try subtraction
                backtrack(result, num, target, i + 1, currentValue - currentNum, -currentNum, expression + "-" + currentStr);
                
                // Try multiplication
                backtrack(result, num, target, i + 1, currentValue - lastValue + lastValue * currentNum, lastValue * currentNum, expression + "*" + currentStr);
            }
        }
    }
}
