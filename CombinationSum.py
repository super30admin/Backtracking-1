class Solution(object):
    # tc : O(2*hm) each time we check choosign or not choosing so 2 power and h is the target/nums[i] so each node the hieght is until the target is formed and 2*h is for every m elements in the inoput arr 
    # sc : O(n) every element is explored with taking and not taking at one point we keep on gng (not taking path) til the n  elemenst so at worst case at one time we can have n space in the recrussive stack. 
    def combinationSum(self, candidates, target):
        """
        :type candidates: List[int]
        :type target: int
        :rtype: List[List[int]]
        """
        # intution 
        # trick parts are : to know how many times a number can be taken and which number to skip tp form the target
        # to solve this, we have to exhaustielvy check taking each number x times or not take and keep checking the sum of the numbers is target or not
        # will use recurssion and at every time recurssively check by choosing the number nd not choosing ith number and following the same pattern for the i+1th number as well until we check all the possibilities of each number which can give the target
        # to stop the recurssive condition once if the target-nums[i] turns negative then its no more a viable path we will stop from exhaustlievly checking that path and go back one step ahead and recursively check the parent path 

        self.result = []
        idx = 0
        path = []
        self.helper(candidates,idx,target,path)

        return self.result

    # will have a helper function where we will start form a index and then iterativekly check the combinations of the paths possible from index to the end of the arr list once we foudn the possibel paths with index we will move 
    # our index one step as we already explored the paths possibel with the index, now we will check the paths possibel with the next element in the arr
    def helper(self,candidates,idx,target,path):
        # base condition
        if target < 0 or idx > len(candidates)-1 : #check if idx is out of bounds 
            return 

        # valid path found
        if target == 0:
            self.result.append(list(path)) # since the path will be override everytime the final output will be the final path in the recursive function rather than the valid paths we found in recurssion, hence will create a deep copy while adding in the final output
            return

        # not choosing the element moving piviot one step
        self.helper(candidates,idx+1,target,path) # everyting remains the same we move the index and check possibilitis with the next element
        
        # action
        # choosing this element which reduces th target and also we can chose the same element again so will continue from idx itself, out helper function will take care tocheck possibilitie sof taking this number and also skipping the number
        path.append(candidates[idx])   

        # recruse 
        self.helper(candidates,idx,target-candidates[idx],path)# path will have the choosen element in it 

        # backtrack
        path.pop() # once we are done of both choosing and not choosing of an element then we have to pop it up before it goes back tot he parent path to explore if not we will have all the elemenst explored in the path which is wrong 




        
