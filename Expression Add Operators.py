#Time Complexity: O(4^N) * N (4^N --> Decisions, N for joining the result)
#Space Complexity: O(N)
class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        result = []
        def dfs(curr_idx, curr_result, curr_sum, prev):
            if(curr_idx==len(num)):
                if(curr_sum==target):
                    result.append("".join(curr_result))
                return
            for i in range(curr_idx,len(num)):
                curr_str = num[curr_idx:i+1]
                curr_num = int(curr_str)
                if not curr_result:
                    dfs(i+1,[curr_str],curr_num,curr_num)
                else:
                    dfs(i+1,curr_result+["+"]+[curr_str],curr_sum+curr_num,curr_num)
                    dfs(i+1,curr_result+["-"]+[curr_str],curr_sum-curr_num,-curr_num)
                    dfs(i+1,curr_result+["*"]+[curr_str],curr_sum-prev+curr_num*prev,curr_num*prev)
                if(num[curr_idx]=="0"):
                    break
        dfs(0,[],0,0)
        return result


        
        