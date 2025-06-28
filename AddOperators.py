# Time complexity - o(n*4^n)
# Space Complexity - o(n)

class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        res = []

        def helper(idx, path, value, prev):
            if idx == len(num):
                if value == target:
                    res.append(path[:])
                return

            for i in range(idx,len(num)):

                if i!=idx and num[idx]=='0':
                    break

                curr_str = num[idx:i+1]
                curr_num = int(curr_str)

                if idx==0:
                    helper(i+1,curr_str,curr_num,curr_num)
                else:
                    helper(i+1,path+'+'+curr_str,value+curr_num, curr_num)
                    helper(i+1,path+'-'+curr_str,value-curr_num, -curr_num)
                    helper(i+1,path+'*'+curr_str,value - prev + prev*curr_num, prev*curr_num)

            

        helper(0,[],0,0)
        return res
