#include<iostream>
#include<vector>
using namespace std;
class Solution {
public:
    void helper(vector<int>& candidates, int target, int sum, int index,vector<int>& path, vector<vector<int>>& ans) {
        int n=candidates.size();
        if(sum==target){
            ans.push_back(path);
            return;
        }
        if(sum>target)
            return;
        for(int i=index;i<n;i++){
            path.push_back(candidates[i]);
            helper(candidates,target,sum+candidates[i],i,path,ans);
            path.pop_back();
        }
   
    }
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        vector<vector<int>>ans;
        vector<int> path;
        helper(candidates,target,0,0,path,ans);
        return ans;
    }
};