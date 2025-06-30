#TimeComplexit: O(N ^ (T / min_val)) T is target , min_val in nums .  every combination of numbers (with repetition allowed) that can sum to the target. 
# In the worst case, each recursive call can branch into up to n calls.
#Space Complexity: O(T / min_val)
#App: Do a for loop based recursion with backtracking ..fix a pivot and then move to see if you find target sum if yes add to path 
# else try different combiations with pivot fixed 







class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        ans,n=[],len(candidates)

        def helper(idx,target,path,c):
            #base
            if target<0 or idx==n:return
            if target==0:ans.append([val for val in path]) #pass by refernce



            #logic
            #include
            path.append(candidates[idx])
            
            helper(idx,target-candidates[idx],path,c+1)

            #backtrack
            if c==0 and path:path.pop()
            else:

                while(c and path):
                    path.pop()
                    c-=1
            

            #dont include
            helper(idx+1,target,path,c)
        helper(0,target,[],0)
        return ans

################################################################################################################
class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:

        res=[]
        
        def dfs(i, cur, total):
            if total == target:
                res.append(cur.copy())
                return
            if i>=len(candidates) or total > target:
                return
            
            cur.append(candidates[i])
            dfs(i, cur, total + candidates[i])
            cur.pop()
            dfs(i+1, cur, total)

        dfs(0, [], 0)
        return res
