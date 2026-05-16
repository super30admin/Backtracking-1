
# Time Complexity: O(4^N) 
# Space Complexity: O(N) 
# Did this code successfully run on Leetcode : Yes

class Solution(object):
    def addOperators(self, num, target):
        """
        :type num: str
        :type target: int
        :rtype: List[str]
        """
        res=[]
        N=len(num)
        path=[]
        def helper(pivot,calc,tail):
            #base
            if pivot==N:
                if calc==target:
                    res.append(''.join(path))
                return
            #logic

            for i in range(pivot,N):
                if num[pivot]=='0' and pivot!=i:
                    break
                
                curr=int(num[pivot:i+1])
                if pivot==0:
                    path.append(str(curr))
                    helper(i+1,curr,curr)
                    path.pop()
                    # path.pop()
                else:
                    #+
                    path.append('+')
                    path.append(str(curr))
                    helper(i+1,calc+curr,curr)
                    path.pop()
                    path.pop()

                    #-
                    path.append('-')                    
                    path.append(str(curr))
                    helper(i+1,calc-curr,-curr)
                    path.pop()
                    path.pop()

                    #*
                    path.append('*')
                    path.append(str(curr))
                    helper(i+1,calc-tail+tail*curr,tail*curr)
                    path.pop()
                    path.pop()
        
        helper(0,0,0)
        return res