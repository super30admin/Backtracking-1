#include<iostream>
#include<bits/stdc++.h>
#include<vector>
using namespace std;
/*
We use recursion to put each value and its corresponding operator to reach the
final target, the for loop based recursion uses pivot, to go through each element 
in the string and finally we return the result
*/
class Solution{
    vector<string> result;
public:
    vector<string> addOperator(string s, int target){
        string numStr;
        helper(s, target, 0, numStr, 0, 0);
        return result;
    }
private:
    void helper(string& s, int target, int pivot, string numStr, long eval, long residual){
        if(pivot == s.length()){
            if(eval == target){
                result.push_back(numStr);
                return;
            }
        }
        string currStr; long num = 0;
        for(int i=pivot; i<s.length(); i++){
            if(i>pivot && s[pivot] == '0') return;
            currStr += s[i];
            num = num*10 + s[i] - '0';
            if(pivot == 0) helper(s, target, i+1, numStr + currStr, num, num);
            else{
                helper(s, target, i+1, numStr + "+" + currStr, eval+num, num);
                helper(s, target, i+1, numStr + "-" + currStr, eval-num, -num);
                helper(s, target, i+1, numStr + "*" + currStr, eval - residual + residual*num, residual*num);
            }
        }
    }
};
