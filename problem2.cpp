// Time Complexity : O(4^n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no 

// Your code here along with comments explaining your approach:
// Explore all the ways to insert the operators between the digits
// Maintain current total, last number and add to result when expression = target
// Special case: * -> since * has higher precedence, backtrack the last operation 
// For *, we backtrack the last addition using tail and recalculate properly because * has higher precedence.

class Solution {
private:
    void helper(string num, int pivot, long calc, long tail, string path, int target, vector<string>& result) {
        // base:
        if (pivot == num.length()) {
            if (calc == target) {
                result.push_back(path);
            }
            return;
        }

        // logic:
        for (int i = pivot; i < num.length(); i++) {
            if (num[pivot] == '0' && i > pivot) break;

            long curr = stol(num.substr(pivot, i - pivot + 1));

            if (pivot == 0) {
                helper(num, i + 1, curr, curr, to_string(curr), target, result);
            } else {
                // +
                helper(num, i + 1, calc + curr, curr, path + "+" + to_string(curr), target, result);
                // -
                helper(num, i + 1, calc - curr, -curr, path + "-" + to_string(curr), target, result);
                // *
                helper(num, i + 1, calc - tail + tail * curr, tail * curr, path + "*" + to_string(curr), target, result);
            }
        }
    }

public:
    vector<string> addOperators(string num, int target) {
        vector<string> result;
        helper(num, 0, 0, 0, "", target, result);
        return result;
    }
};