class Solution:
    def combinationSum(self,candidate,target):
        result=[]

        def backtrack(index,currentCombination,currentSum):
            if currentSum==target:
                result.append(currentCombination[:])
                return
            
            if currentSum>target:
                return
            
            for i in range(index,len(candidate)):
                num=candidate[i]

                currentCombination.append(num)

                backtrack(i,currentCombination,currentSum+num)

                currentCombination.pop()

        backtrack(0,[],0)

        return result
    
sol=Solution()
print(sol.combinationSum([2,3,6,7],7))