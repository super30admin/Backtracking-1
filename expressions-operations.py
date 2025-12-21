
# If pivot is out of bounds and the calcualted exp==target, append the path to result. Else, return
# Run a loop from pivot to len of num. if i!=pivot and num[pivot] is 0, skip the loop.
# current will be the number between pivot and 1. When pivot is 0, call helper function where pivot is i+1
# and path, calcualted and tail = current.
# Else, call recursively the helper function :

# (num,target,i+1,path+"+"+str(current),calculated+current,current) for addition
# (num,target,i+1,path+"-"+str(current),calculated-current,-current) for sub
# (num,target,i+1,path+"*"+str(current),calculated-tail+(tail*current),tail*current) for multiplication

# Time: O(4^n)
# Space: O(n)



class Solution(object):
    def addOperators(self, num, target):
        """
        :type num: str
        :type target: int
        :rtype: List[str]
        """
        self.result=[]
        self.helper(num,target,0,'',0,0)
        return self.result
    
    def helper(self, num, target, pivot, path, calculated, tail):
        if pivot==len(num):
            if calculated==target:
                self.result.append(path)
            return
        for i in range(pivot, len(num)):
            if i!=pivot and num[pivot]=='0':
                continue
            current=int(num[pivot:i+1])
            if pivot ==0:
                self.helper(num,target,i+1,str(current),current,current)
            else:
                self.helper(num,target,i+1,path+"+"+str(current),calculated+current,current)
                self.helper(num,target,i+1,path+"-"+str(current),calculated-current,-current)
                self.helper(num,target,i+1,path+"*"+str(current),calculated-tail+(tail*current),tail*current)
        