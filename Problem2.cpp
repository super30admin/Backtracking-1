// Time Complexity : O(3^n)  
// Space Complexity : O(n)  
// Did this code successfully run on Leetcode : Yes

// Your code here along with comments explaining your approach:
// 1. Traverse each element and for each element try all three operators while maintaining prev and current value.
// 2. Evaluate the expression when we select the operator. 
// 3. If element reaches last for each subset of expressions check if evaluated expression is target.

class Solution {
public:
    vector<string> ans;
    // int evaluat(string t){
    //     int cur=0,su=0,fl=0;
    //     t=t+'+';
    //     // fl=0 is add, 1 is sub,2 is multiply. 
    //     for(int it=0;it=t.size();it++){
    //         if(t[it]<'0' && t[it]>'9'){
    //             if(fl==0){su=cur+su;}
    //             else if(fl==2){su=cur*su;}
    //             else if(fl==1){su=su-cur;}
    //             if(t[it]=='*'){fl=2;}
    //             else if(t[it]=='+'){fl=0;}
    //             else if(t[it]=='-'){fl=1;}
                
    //             cur=0;
    //         }else{
    //             cur=(cur*10) + (t[it]-'0');
    //         }
    //     }
    //     return su;
    // }
    void cs(string t, string path,int target,int pt,long prev,long cur){
        //int st=evaluat(t);
        //cout<<cur<<' ';
        if(pt == t.size()){
            //cout<<path<<' ';
            if(cur==target){
                ans.push_back(path);
            }
            return;
        }
        for(int i=pt;i<t.size();i++){
            string next=t.substr(pt,i-pt+1);
            long nint=stol(next);
            if (i > pt && t[pt] == '0') break;
            if(pt==0){
                cs(t,next,target,i+1,nint,nint);continue;
            }
            //+
            cs(t,path+"+"+next,target,i+1,nint,cur+nint);
            //-
            cs(t,path+"-"+next,target,i+1,-nint,cur-nint);
            //*
            cs(t,path+"*"+next,target,i+1,prev*nint,cur-prev+(prev*nint));
        }
        return;
    }
    vector<string> addOperators(string num, int target) {
        string path="";
        cs(num,path,target,0,0,0);
        return ans;
    }
};