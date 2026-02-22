'''
Time Complexity: 
for given N length of candidates, there is utmost N-1 gaps to include operators, that would mean 
2^(N-1) ways to insert an operator for N candidates 
Now for given separation of operators, we can have at most 3 choices for each gap: +, -, *.
That would mean 3^(N-1) possible expressions to evaluate.
So, total time complexity would be O(2^(N-1) * 3^(N-1)) = O((2*3)^(N-1)) = O(6^(N-1)) 

Space Complexity: 
Recursive Stack: O(N) because depth is utmost N for N candidates
Where N is the length of the input string.
Output Space: O(K)
Where K is the number of valid expressions. 

Total Space Complexity: O(N+K)
''' 
class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        output = []
        def solve(index, expression, current_value, prev_value):
            if index == len(num) and current_value == target:
                output.append(expression)
                return 
            
            for i in range(index, len(num)):
                if num[index]=='0' and i>index:
                    break
                value = int(num[index:i+1])
                if index == 0:
                    solve(i+1, num[index:i+1], value, value)
                else:
                  
                    solve(i+1, expression+"+"+num[index:i+1], current_value+value, value)
                    solve(i+1, expression+"-"+num[index:i+1], current_value-value, -value)
                    solve(i+1, expression+"*"+num[index:i+1], (current_value-prev_value)+(prev_value*value) , prev_value*value)
            
        solve(0, "", 0, 0)

        return output

                



        
        