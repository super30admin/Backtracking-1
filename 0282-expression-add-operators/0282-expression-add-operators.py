class Solution(object):
    def addOperators(self, num, target):
        ans = []
        
        def dfs(ind, path, curr_total, prev_num):
            if ind == len(num):
                if curr_total == target:
                    ans.append("".join(path))
                return
            
            for i in range(ind, len(num)):
                curr_str = num[ind:i+1]
                curr_num = int(curr_str)
                
                # Skip numbers with leading zeroes, except the number '0' itself
                if i > ind and num[ind] == '0':
                    break
                
                if ind == 0:
                    # Initial call, no operator before the first number
                    dfs(i+1, [curr_str], curr_num, curr_num)
                else:
                    # Addition
                    dfs(i+1, path+['+']+[curr_str], curr_total+curr_num, curr_num)
                    
                    # Subtraction
                    dfs(i+1, path+['-']+[curr_str], curr_total-curr_num, -curr_num)
                    
                    # Multiplication
                    dfs(i+1, path+['*']+[curr_str], curr_total-prev_num+prev_num*curr_num, prev_num*curr_num)

        dfs(0, [], 0, 0)
        return ans

        """
        :type num: str
        :type target: int
        :rtype: List[str]
        """

