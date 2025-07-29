// Time Complexity: O(4^n) where n is the length of the input string
// Space Complexity: O(n) where n is the stack space
// Were you able to solve the problem? Yes
// Did you face any challenges while solving the problem? The substring passing was tricky to understand at first

class Solution {
public:
    vector<string> result;
    vector<string> addOperators(string num, int target) {
        if (num=="" || num.size() == 0){
            return {};
        }
        
        recurse(num, target, 0, 0, 0, "");

        return result;
        
    }

private:
    void recurse(string num, int target, int index, long calc, long tail, string path){
        // base case
        if (index == num.size()){
            if (calc == target){
                result.push_back(path);
                return;
            }
        }


        // main logic
        for (int i = index; i<num.size(); i++){

            if ( num[index] == '0' && index != i){
                continue;
            }
            // std::cout<<path<<"\n";
            
            
            string curr = num.substr(index, i-index+1 );
            // cout<<"len of curr: "+to_string(i-index+1)+"curr: "+curr+"\n";
            path
            // cout<<curr<<'\t';
            long curr_num = stol(curr);
            if (index == 0){
                recurse(num, target, i+1, curr_num, curr_num, path+curr);

            }
            else{
                // + case
                recurse(num, target, i+1, calc + curr_num, curr_num, path+'+'+curr);

                // - case
                recurse(num, target, i+1, calc - curr_num, -curr_num, path+'-'+curr);

                // * case
                recurse(num, target, i+1, calc - tail + tail * curr_num, tail * curr_num, path+'*'+curr);

            }


        }
    }

};
