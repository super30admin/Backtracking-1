#include<iostream>
#include<vector>
using namespace std;
class Solution {
public:
    vector<string>ans;
    void helper(string& num, int target, int idx, long curr, long prev, string exp) {
        if (idx == num.size()) {
            if (curr == target) {
                ans.push_back(exp);
            }
            return;
        }

        for (int i = idx; i < num.size(); i++) {
            if (i != idx && num[idx] == '0') 
                break;
            string currStr = num.substr(idx, i - idx + 1);
            long currNum = stol(currStr);

            if (idx == 0) {
                helper(num, target, i + 1, currNum, currNum, currStr);
            } else {
                helper(num, target, i + 1, curr + currNum, currNum, exp + "+" + currStr);
                helper(num, target, i + 1, curr - currNum, -currNum, exp + "-" + currStr);
                helper(num, target, i + 1, curr - prev + prev * currNum, prev * currNum, exp + "*" + currStr);
            }
        }
    }
    vector<string> addOperators(string num, int target) {
         helper(num, target, 0, 0, 0, "");
        return ans;
    }
};