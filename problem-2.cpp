// 282. Expression Add Operators
// Time Complexity : O(4^n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

class Solution {
public:
    vector<string> addOperators(string num, int target) {
        vector<string> result;
        helper(0, "", num, target, 0, 0, result);
        return result;
    }
    void helper(int ind, string path, string num, int target, long sum, long prevnum, vector<string>& result)
    {
        long currnum = 0;
        if(ind == num.size())
        {
            if (target == sum)
                result.push_back(path);
            return;
        }
        for(int i = ind; i < num.size(); i++)
        {
            if(i > ind && num[ind] == '0') continue;
            currnum = currnum*10 + (num[i] - '0');

            if(path == "")
            {
                helper(i+1, path + to_string(currnum), num, target, sum + currnum, currnum, result);
            }
            else
            {
                helper(i+1, path + "*" + to_string(currnum), num, target, (sum - prevnum) + ((prevnum) * currnum),  prevnum*currnum, result);

                helper(i+1, path + "-" + to_string(currnum), num, target,  sum - currnum, -currnum, result);

                helper(i+1, path + "+" + to_string(currnum), num, target, sum + currnum, currnum, result);    
            }
        } 
    }

};
