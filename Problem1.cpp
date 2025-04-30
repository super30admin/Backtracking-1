// Time Complexity : O(2^n)  
// Space Complexity : O(n)  
// Did this code successfully run on Leetcode : Yes

// Your code here along with comments explaining your approach:
// 1. Traverse each element and for each element include and exclude that element.
// 2. For further subset recursively select remaining element combination. 
// 3. Check if we are able to achieve target with given set as elements can be repeated.

class Solution {
public:
    vector<vector<int>> path;
    void cs(vector<int> candidates, int target,vector<int> comb,int i,int sum) {
        cout<<sum<<' ';
        if(sum==target ){
            //cout<<"("<<sum<<")"<<' ';
            path.push_back(comb);return;
        }
        if( i>=candidates.size() || sum>target ){
            return;
        }

        comb.push_back(candidates[i]);
        sum=sum+(candidates[i]);
        cs(candidates,target,comb,i,sum);
        sum=sum-(candidates[i]);
        comb.pop_back();
        cs(candidates,target,comb,i+1,sum);

    }
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        vector<int> comb;
        cs(candidates,target,comb,0,0);
        return path;
    }
};