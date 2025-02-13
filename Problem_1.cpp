// Author: Subhed Chavan
// Batch: December 24
// Problem Statement: Combination Sum
// Approach: Backtracking
// TC: O(2^N)
// SC: O(N)

class Solution
{
public:
    vector<vector<int>> result;

    vector<vector<int>> combinationSum(vector<int> &candidates, int target)
    {

        if (candidates.empty())
        {
            return result;
        }

        vector<int> path;
        recurse(candidates, target, 0, path);
        return result;
    }

    void recurse(vector<int> &candidates, int target, int index, vector<int> &path)
    {
        // Base case
        if (target < 0)
        {
            return;
        }

        if (target == 0)
        {
            result.push_back(path);
            return;
        }

        // Recursive case
        for (int i = index; i < candidates.size(); i++)
        {
            path.push_back(candidates[i]);
            recurse(candidates, target - candidates[i], i, path);
            path.pop_back();
        }
    }
};
