/*
TC : O(2^N)
SC : O (2^N)
*/
class Solution
{
public:
    vector<vector<int>> result;
    vector<vector<int>> combinationSum(vector<int> &candidates, int target)
    {
        if (candidates.empty() || candidates.size() == 0)
        {
            return {};
        }

        recurse(candidates, target, 0, {});
        return result;
    }

    void recurse(vector<int> &candidates, int target, int index, vector<int> path)
    {
        // base
        if (index == candidates.size() || target < 0)
        {
            return;
        }

        if (target == 0)
        {
            result.push_back(path);
            return;
        }

        // logic
        // zero case or not pick case
        recurse(candidates, target, index + 1, path);

        // one case or pick case
        // build the list
        path.push_back(candidates[index]);                            // action
        recurse(candidates, target - candidates[index], index, path); // recurse
        path.pop_back();                                              // backtrack
    }
};