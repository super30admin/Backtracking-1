class Solution {
public:
  vector<vector<int>> result;
    //vector<vector<int>> result;
    vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
      if(candidates.size()==0)
        return {};
    vector<int> path;
  
    recurse(candidates,target,0 ,path);
    return result;  
    }
    void recurse(vector<int>& candidates, int target, int index, vector<int>&path)
    {
        //base
        if(target==0)
        {
            result.push_back(path);
        }   
        if(target<0)
        {
            return;
        }

        //logic
        for(int i=index;i<candidates.size();i++)
        {
            path.push_back(candidates[i]);
            recurse(candidates, target-candidates[i], i, path);
            path.pop_back();
        }

    }
    };
