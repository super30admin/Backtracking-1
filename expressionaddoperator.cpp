// Time Complexity : O(n) space complexity : O(n)

class Solution {
public:
    vector<string> ans;
    void helper(string &num, int &target, long cal, long tail, int idx, string asf) {
        if(idx == num.length()) {
            if(cal == target) {
                ans.push_back(asf);
            }
            return;    
        }
        string str = "";
        for(int i=idx;i<num.length();i++) {
            if(num[idx]=='0' && idx!=i) continue;
            str += num[i];
            long curr = stol(str);
            
            if(idx == 0) {
                helper(num,target,curr,curr,i+1,asf+str);
            } else {
                //+
                helper(num,target,curr+cal,curr,i+1,asf+"+"+str);
                //-
                helper(num,target,cal-curr,-curr,i+1,asf+"-"+str);
                //*
                helper(num,target,(cal-tail)+(tail*curr),tail*curr,i+1,asf+"*"+str);
            }
        }
    }
    vector<string> addOperators(string num, int target) {
        if(num.length()==0) return ans;
        helper(num, target, 0, 0, 0, "");
        return ans;
    }
};