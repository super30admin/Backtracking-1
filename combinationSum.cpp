// Time Complexity: O(2^n)
// Space Complexity: O(n)
// Did this code successfully run on Leetcode : Yes

// Approach: Backtracking
// 1. We start with an empty path and keep adding elements to the path until the target is reached.
// 2. If the target is reached, we add the path to the result.
// 3. If the target is less than 0, we return.
// 4. For each element in the candidates array, we add the element to the path and recursively call the helper function with the updated target.


class Solution {
    vector<vector<int>> result; 
public:
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        helper(candidates, target, 0, vector<int>());
        return result; 
    }
private: 
    void helper(vector<int>& candidates, int amount, int pivot, vector<int> path){
        //base
        if(amount == 0){
            result.push_back(path);
            return;
        }
        if(amount < 0){return;}

        //logic
        for(int i = pivot; i < candidates.size(); i++){
            //action
            path.push_back(candidates[i]);
            //reurse
            helper(candidates, amount - candidates[i], i, path);
            //backtrack
            path.pop_back();
        }
    }

};