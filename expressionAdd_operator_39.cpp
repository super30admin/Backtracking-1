//TC: O(n*4^n)
//SC:
class Solution {
public:
vector<string> res;
    vector<string> addOperators(string num, int target) {
        if(num.empty())
            return {};
        string expression="";
        recurse(num, target, 0, 0, 0, expression);

    return res;
    }
    void recurse(string num, int target, int index, long calc, long tail, string exp)
    {   
        //base
        if(index==num.size()) //at the end of string 
        {
             if(target==calc) 
            {
                res.push_back(exp);
                return;
            }
        }
       
        
        ///logic
        string currString="";
        long long currNum=0;
        for(int i=index; i<num.size();++i)
        {
            if(i>index && num[index]=='0')break;

            currString+=num[i];
            currNum=currNum*10+(num[i]-'0');
            
            if(index==0)
            { 
                recurse(num, target, i+1, calc+currNum, currNum, exp+currString);
            }
            else
            {
            //+
            recurse(num, target, i+1, calc+currNum,+currNum, exp+"+"+currString);
            //-
            recurse(num, target, i+1, calc-currNum, -currNum, exp+"-"+currString);
            //*
            recurse(num, target, i+1, calc-tail+tail*currNum, tail*currNum, exp+"*"+currString);
            }
            
        }

    }
};
