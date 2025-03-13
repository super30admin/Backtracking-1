// Time Complexity: O(4^n)
// Space Complexity: O(n)
// Did this code successfully run on Leetcode : Yes

// Approach: Backtracking
// 1. For each digit in the input string, we have 3 choices: +, -, *.
// 2. We keep track of the calculated value and the tail value.
// 3. If the pivot reaches the end of the string, we check if the calculated value is equal to the target.
// 4. + and - operations are straightforward. For * operation, we need to subtract the tail value and add the tail value multiplied by the current value.
// 5. We keep track of the current value and the string formed so far.
// 6. We backtrack and try all possible combinations.
// 7. If the pivot is not equal to i and the current value is 0, we break the loop.

class Solution {
    vector<string> result;
    public:
        vector<string> addOperators(string num, int target) {
            string s;
            backtrack(num, target, 0, 0, 0, s);
            return result;
        }
    private: void backtrack(string num, int target, long tail, int pivot, long calculated, string& s){
        // base case
        if(pivot == num.size()){
            if(calculated == target){
                result.push_back(s);
            }
        }
    
        //logic
        for(int i = pivot; i < num.size(); i++){
           //preceding 0
           if(pivot != i && num[pivot] == '0'){break;}
           string current = num.substr(pivot, i - pivot + 1);
           long curr = stol(current);
           int len = s.size();
           if(pivot == 0){
            s += current;
            backtrack(num, target, curr, i + 1, curr, s);
            s.resize(len);
           }
           else{
            s += ('+');
            s += current;
            backtrack(num, target, curr, i + 1, calculated + curr, s);
            s.resize(len);
    
            s += ('-');
            s += current;
            backtrack(num, target, -curr, i + 1, calculated - curr, s);
            s.resize(len);
    
            s += ('*');
            s += current;
            backtrack(num, target, curr * tail, i + 1, calculated - tail + tail * curr, s);
            s.resize(len);
           }
    
        }
    }
    };