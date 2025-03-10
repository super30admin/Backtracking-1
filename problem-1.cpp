// https://leetcode.com/problems/combination-sum/description/
// Time Complexity : O(2^t) where t is the target 
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Recursively take each element and subtract it from the target.
// If the target is going under 0, then backtrack and remove that element.
// Else add the elements into path until the target becomes 0, then add the path to the ans.

class Solution {
    public:
        void helper(vector<int>& candidates, vector<vector<int>> &ans, vector<int> &res, int target, int pivot){
            if(target<0) return;
            if(target == 0){
                ans.push_back(res);
                return;
            }
            for(int i=pivot; i<candidates.size(); i++){
                res.push_back(candidates[i]);
                helper(candidates, ans, res, target-candidates[i], i);
                res.pop_back();
            }
        }
        vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
            vector<vector<int>> ans;
            vector<int> res;
            helper(candidates, ans, res, target, 0);
            return ans;
        }
    };