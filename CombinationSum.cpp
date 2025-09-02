#include<iostream>
#include<bits/stdc++.h>
#include<vector>
using namespace std;
/*
We use recursion and backtracking to solve this problem, when target is less than
0 or pivot becomes equal to size of the array we return, when target is zero we push 
the numbers into the result vector and then using for loop based resursion we return the result
*/
class Solution{
    vector<vector<int>> result;
public:
    vector<vector<int>> combinationSum(vector<int>& candidates, int target){
        vector<int> path;
        helper(candidates, target, 0, path);
        return result;
    }
private:
    void helper(vector<int>& candidates, int target, int pivot, vector<int>& path){
        if(target < 0 || pivot == candidates.size()) return;
        if(target == 0){
            result.push_back(path);
            return;
        }
        for(int i=pivot; i<candidates.size(); i++){
            path.push_back(candidates[i]);
            helper(candidates, target-candidates[i], i, path);
            path.pop_back();
        }
    }
};
