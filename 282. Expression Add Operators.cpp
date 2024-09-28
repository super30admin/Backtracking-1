/*
Time Complexity = Exponential
Space Complexity = Exponential
*/
class Solution {
public:
    vector<string>result;
    int goal;
    vector<string> addOperators(string num, int target) {
        goal = target;
        helper(num, 0,0,0,"");
        return result;
    }
    void helper(string num, int index, long calc, long tail, string path)
    {
        //base
        if(index == num.size())
        {
            if(calc == goal)
                result.push_back(path);
            return;
        }
        
        //logic
        for(int i=index; i<num.size();i++)
        {
            if(num[index]=='0' && index!=i)
                continue;
            string s = num.substr(index,i-index+1);
            long curr = stol(s,nullptr,10);
            if(index==0){
                helper(num, i+1, curr, curr, path+to_string(curr));
            }
            else{
                //+
                helper(num, i+1, calc+curr, curr,path+"+"+to_string(curr));
                //-
                helper(num, i+1, calc-curr, -1*curr, path+"-"+to_string(curr));
                //*
                helper(num, i+1, calc-tail+(tail*curr), tail*curr, path+"*"+to_string(curr));
            }
        }
    }
};
