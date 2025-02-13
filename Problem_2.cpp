// Author: Subhed Chavan
// Batch: December 24
// Problem Statement: Expression Add Operators
// Approach: Backtracking
// TC: O(4^N)
// SC: O(N)

class Solution
{
public:
    vector<string> result;

    vector<string> addOperators(string num, int target)
    {

        // Base Case
        if (num.empty())
        {
            return result;
        }

        recurse(num, target, 0, 0, 0, "");

        return result;
    }

    void recurse(string &num, int target, int index, long calc, long tail, string path)
    {
        // Base case
        if (index == num.length())
        {
            if (calc == target)
            {
                result.push_back(path);
            }
            return;
        }

        // Recursive case
        for (int i = index; i < num.length(); i++)
        {
            if (num[index] == '0' && index != i)
            {
                continue;
            }
            long curr = stol(num.substr(index, i - index + 1));
            if (index == 0)
            {
                recurse(num, target, i + 1, curr, curr, path + to_string(curr));
            }
            else
            {
                recurse(num, target, i + 1, calc + curr, curr, path + "+" + to_string(curr));
                recurse(num, target, i + 1, calc - curr, -curr, path + "-" + to_string(curr));
                recurse(num, target, i + 1, calc - tail + tail * curr, tail * curr, path + "*" + to_string(curr));
            }
        }
    }
};