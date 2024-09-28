/*
Time Complexity = Exponential
Space Complexity = Exponential
*/
class Solution {
public:
    vector<vector<int>> result;
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        vector<int> path;
        helper(candidates, 0, target, path);
        return result;
    }
    void helper(vector<int>& candidates, int index, int target, vector<int> path)
    {
        //base
        if(index==candidates.size())
            return ;
        if(target<0)
            return;
        if(target==0)
        {
            result.push_back(path);
            return;
        }
            
        //logic
        //do not choose
        helper(candidates, index+1, target, path);
        
        //choose
        path.push_back(candidates[index]);
        helper(candidates, index, target-candidates[index], path);
    }
};

/*
Time Complexity = Exponential
Space Complexity = Exponential
Backtracking
*/
class Solution {
public:
    vector<vector<int>> result;
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        vector<int> path;
        helper(candidates, 0, target, path);
        return result;
    }
    void helper(vector<int>& candidates, int index, int target, vector<int>& path)
    {
        //base
        if(index==candidates.size())
            return;
        if(target<0)
            return;
        if(target==0)
        {
            result.push_back(path);
            return;
        }
            
        //logic
        //do not choose
        helper(candidates, index+1, target, path);
        
        //choose
        //action
        path.push_back(candidates[index]);
        //recurse
        helper(candidates, index, target-candidates[index], path);
        //backtrack
        path.pop_back();
    }
};

/*
Time Complexity = Exponential
Space Complexity = Exponential
*/
class Solution {
public:
    vector<vector<int>> result;
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        vector<int> path;
        helper(candidates, 0, target, path);
        return result;
    }
    void helper(vector<int>& candidates, int index, int target, vector<int> path)
    {
        //base
        if(target<0)
            return;
        if(target==0)
        {
            result.push_back(path);
            return;
        }
            
        //logic
        for(int i=index;i<candidates.size();i++)
        {
            vector<int> copy(path);
            copy.push_back(candidates[i]);
            helper(candidates, i, target-candidates[i], copy);
        }
    }
};

/*
Time Complexity = Exponential
Space Complexity = Exponential
Backtracking
*/
class Solution {
public:
    vector<vector<int>> result;
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
        vector<int> path;
        helper(candidates, 0, target, path);
        return result;
    }
    void helper(vector<int>& candidates, int index, int target, vector<int> &path)
    {
        //base
        if(target<0)
            return;
        if(target==0)
        {
            result.push_back(path);
            return;
        }
            
        //logic
        for(int i=index;i<candidates.size();i++)
        {
            //action
            path.push_back(candidates[i]);
            //recurse
            helper(candidates, i, target-candidates[i], path);
            //backtrack
            path.pop_back();
        }
    }
};
