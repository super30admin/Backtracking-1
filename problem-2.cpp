// https://leetcode.com/problems/expression-add-operators/
// Time Complexity : O(4^n) where n is the length of the string
// Space Complexity : O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
// Recursively take each elements and perform 4 operations - no operation, +, -, and *.
// Check for the leading zero case
// If the calculated value is equal to the target, then add the path to the ans else backtrack the path.

class Solution {
    public:
        void helper(string num, int target, vector<string> &ans, string path, long calVal, long tail, int pivot ){
            if(pivot == num.length()){
                if(calVal == target){
                    ans.push_back(path);
                }
                return;
            }
            string str="";
            long curNum=0;
            for(int i=pivot; i<num.length(); i++){
                if(i>pivot && num[pivot] == '0') return;
                str += num[i];
                curNum = curNum*10 + num[i] - '0';
                if(pivot == 0){
                    helper(num, target, ans, path+str, curNum, curNum, i+1);
                }
                else{
                    //+
                    helper(num, target, ans, path+'+'+str, calVal+curNum, curNum, i+1);
                    //-
                    helper(num, target, ans, path+'-'+str, calVal-curNum, -curNum, i+1);
                    //*
                    helper(num, target, ans, path+'*'+str, calVal-tail+(tail*curNum), tail*curNum, i+1);
                }
            }
        }
        vector<string> addOperators(string num, int target) {
            vector<string> ans;
            helper(num, target, ans, "", 0, 0, 0);
            return ans;
        }
    };