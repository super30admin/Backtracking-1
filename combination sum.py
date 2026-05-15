#repeatition allowed
#for loop based recursion:
#when amount <0: go back and go to second baby
#after all current babies are done ie for loop is complete,we will go back to previous functional call's next baby.. done with all babies ie completed for loop... go to previous....
#keep track of paths and if amount ==0: add that path to result list
#logic: 1)action 2)recurse 3)backtrack the action
#logic: 1)action with new li 2)recurse with new li
class Solution:
    def combinationSum(self,candidates,target):
        res = []
        def helper(pivot,target,path):
            #1 base ie return and boundary conditions
            if target==0:
                res.append(list(path)) #append deepcopy of the path
                return
            if target<0:
                return
            if pivot==len(candidates):
                return
            
            #2 logic
            for i in range(pivot,len(candidates)):
                #action
                path.append(candidates[i])

                #recurse
                helper(i,target-candidates[i],path)

                #backtrack
                path.pop()

        helper(0,target,[])
        return res

        # #2 logic
        # for i in range(pivot,len(candidates)):
        #     #action
        #     li = list(path) ie deep copy everytime to avoid backtracking the action
        #     li.append(candidates[i])

        #     #recurse
        #     helper(i,target-candidates[i],li)
