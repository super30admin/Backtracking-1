// Time Complexity : O(2^(m+n)), n = target, m = size of candidates array
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no 

// Your code here along with comments explaining your approach
// Go over all combinations recursively
// AT every step either pick or no pick the number
// Store all valid combos which result in target sum

class Solution {
private:
    void helper(vector<int>& candidates, int target, int idx, vector<int>& path, vector<vector<int>>& result) {
        // base:
        if(target < 0 || idx == candidates.size()) {
            return;
        } 
        if(target == 0) {
            result.push_back(path);
            return;
        }
        // logic:
        // pick
        path.push_back(candidates[idx]);
        helper(candidates, target - candidates[idx], idx, path, result);
        path.pop_back();
        // no pick
        helper(candidates, target, idx + 1, path, result);

    }
public:
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        vector<vector<int>> result;
        vector<int> path;
        helper(candidates, target, 0, path, result);
        return result;
    }
};