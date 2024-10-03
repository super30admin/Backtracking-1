//time complexity:O(n) space complexity:O(n)

class Solution {
public:
    void helper(vector<int>& can, int target, int idx, vector<int>& sub,vector<vector<int>> &ans) {
        if(target==0) {
            ans.push_back(sub);
            return;
        }   
        for(int i=idx;i<can.size();i++) {
            if(can[i] <= target) {
                sub.push_back(can[i]);
                helper(can,target-can[i],i,sub,ans);
                sub.pop_back();
            }
        }
    }
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        vector<int> sub;
        vector<vector<int>> ans;
        helper(candidates,target,0,sub,ans);
        return ans;
    }
};