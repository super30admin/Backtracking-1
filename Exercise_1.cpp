// Time Complexity: O(2^(m+n)) where n is the number of candidates
// Space Complexity: O(n) where n is the stack space
// Were you able to solve the problem? Yes
// Did you face any challenges while solving the problem? No

class Solution {

public:
    vector<vector<int>> result;
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {

        if (candidates.size() == 0){
            return {};
        }
        vector<int> path;

        recurse(candidates, 0, target, path);

        return result;
        
    }
private:
    void recurse(vector<int>& arrays, int index, int target, vector<int>& path ){
        // Base case: out of bounds or target becomes negative
        if (index >= arrays.size() || target < 0) {
            return;
        }
        // if target met
        if(target == 0){
            result.push_back(path) ;
            return;
        }
        // for loop recursion  
        for (int i=index; i < arrays.size(); i++){
            // vector<int> newList = path;
            // action
            path.push_back(arrays[i]);
            // recurse
            recurse(arrays, i, target - arrays[i], path);
            // backtrack
            path.pop_back();

        }
        
    }
};