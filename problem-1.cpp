// 39. Combination Sum
// Time Complexity : O(2^n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : No

class Solution {
public:
    void comb(int i, int n, vector<int>& c, vector<int>& k, vector<vector<int>> &u)
    {
        if(i == c.size() || n < 0)
            return;
        if(n == 0)
        {
            u.push_back(k);
            return;
        }
        k.push_back(c[i]);
        comb(i, n-c[i], c, k, u);
        k.pop_back();
        comb(i+1, n, c, k, u);
    } 
    void forcomb(int pivot, int n, vector<int>& c, vector<int>& k, vector<vector<int>>& u)
    {
        if(n < 0) return;
        if(n == 0)
        {
            u.push_back(k);
            return;
        }
        for(int i = pivot; i < c.size(); i++)
        {
            k.push_back(c[i]);
            forcomb(i, n-c[i], c, k, u);
            k.pop_back();
        }
    }

    vector<vector<int>> combinationSum(vector<int>& c, int n) {
        vector<vector<int>> u;
        vector<int> k;
        forcomb(0, n, c, k, u);
        return u;
    }
};
