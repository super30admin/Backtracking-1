from typing import List

class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        def backtrack(index, cur_expr, cur_val, prev_val):
            if index == len(num):
                if cur_val == target:
                    result.append(cur_expr)
                return  
            
            for i in range(index, len(num)):
                if i > index and num[index] == '0':  
                    break
                
                cur_num = int(num[index:i+1])
                
                if index == 0:
                    backtrack(i+1, cur_expr + str(cur_num), cur_num, cur_num)
                else:
                    # Try adding '+'
                    backtrack(i+1, cur_expr + '+' + str(cur_num), cur_val + cur_num, cur_num)
                    # Try adding '-'
                    backtrack(i+1, cur_expr + '-' + str(cur_num), cur_val - cur_num, -cur_num)
                    # Try adding '*'
                    backtrack(i+1, cur_expr + '*' + str(cur_num), cur_val - prev_val + prev_val * cur_num, prev_val * cur_num)

        result = []  
        backtrack(0, "", 0, 0)
        return result