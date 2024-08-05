//time: O(3*2^n)
//space: O(logn)
class Solution {
vector<string> result;
public:
    vector<string> addOperators(string num, int target) {
        if(num.length() == 0) {
            return result;
        }
        recurse(num, target, 0, 0, 0, "");
        return result; 
    }
private:
    void recurse(string num, int target, int pivot, long calc, long tail, string path) {
        //base
        if(pivot == num.length()) {
            if(calc == target) {
                result.push_back(path);
            }
            return;
        }
        //logic
        for(int i = pivot; i < num.length(); i++) {
            //preceding 0
            if(num[pivot] == '0' && i != pivot) {
                continue;
            }
            
            // string temp = "";
            // for(int j = pivot; j <= i; j++) {
            //     temp = temp + num[j];
            // }
            string temp = num.substr(pivot, i - pivot + 1);
            long curr = stol(temp);
            int le = path.length();
            //top lvl
            if(pivot == 0) {
                path += temp;
                recurse(num, target, i+1, curr, curr, path);
                path.resize(le);

            }
            else {
                //+
                path += "+" + temp;
                //path += curr;
                recurse(num, target, i+1, calc+curr, +curr, path);
                path.resize(le);
                //-
                path += "-" + temp;
                //path += curr;
                recurse(num, target, i+1, calc-curr, -curr, path);
                path.resize(le);
                //*
                path += "*" + temp;
                //path += curr;
                recurse(num, target, i+1, calc-tail+tail*curr, tail*curr, path);
                path.resize(le);
            }
        }
    }
};