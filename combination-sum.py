# Time Complexity:
# O(n * 2^(m+n)) where m is the candidates length and n is the target

# Space Complexity:
# O(n * h) -> O(n^2)
class Solution:
    def combinationSum(self, candidates, target):
        self.result = []
        self.helper(candidates,target,0,[])
        return self.result 

    def helper(self, candidates, target, i,path):

        # base
        if target < 0 or i == len(candidates):
            return

        if target == 0:
            self.result.append(path)
            return

        # no choose
        self.helper(candidates,target,i+1,list(path)) # create new deep copies otherwise the recursive calls will all reference the same path

        path.append(candidates[i])

        # choose
        self.helper(candidates,target-candidates[i],i,list(path))

# Time Complexity:
# O(n * 2^(m+n)) where m is the candidates length and n is the target

# Space Complexity:
# O(n * h) -> O(n^2)

# the first solution copies all lists - creating snapshots at each fork in the tree. With 1,000 forks, you create 1,000 lists
# In this solution, you have 1 list and just add/remove from it 1,000 times 
class Solution:
    def combinationSum(self, candidates, target):
        self.result = []
        self.helper(candidates,target,0,[])
        return self.result 


    def helper(self,candidates,target,i,path):
        if target < 0 or i == len(candidates):
            return 

        if target == 0:
            self.result.append(list(path))

        self.helper(candidates,target,i+1,path)
        path.append(candidates[i])
        self.helper(candidates,target-candidates[i],i,path)
        path.pop()

# Time Complexity:
# O(n*2^(m+n))
# conversion to list is the n (copy). Otherwise at each branch you have 2 decisions, so total nodes is 2^depth
# At each recursive step you do 1 of 2 things:
# increment i by moving to next candidate (M candidates). 
# reduce target (stay at same index but reduce target)
# So, M (exhausting candidates) + T (exhausting target)
# Space Complexity:
# O(n)

class Solution:
    def combinationSum(self, candidates, target):
        self.result = []
        self.helper(candidates,target,i,path)
        return self.result

    def helper(self,candidates, target, pivot, path):
        if target < 0 or pivot == len(candidates):
            return 
        if target == 0:
            self.result.append(list(path))
            return 

        for i in range(pivot,len(candidates)):
            path.append(candidates[i])
            self.helper(candidates,target-candidates[i],i,path)
            path.pop()






