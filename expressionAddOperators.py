# TC: O(4^n)
# SC: O(n)
class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        n=len(num)
        res=[]
        def helper(num, target, pivot, path, tail, cval, res):
            #base
            if pivot==len(num) and cval==target:
                res.append(path)
            #logic
            for i in range(pivot, len(num)):
                if num[pivot] == '0' and i > pivot:
                    break
                #action
                curr_str=num[pivot:i+1]
                curr=int(curr_str)
                if pivot == 0:
                    helper(num, target, i+1, curr_str, curr, curr, res)
                    continue

                # '+'
                temp=tail
                cval+=curr
                path+='+'+curr_str
                tail=curr
                
                #recurse
                helper(num,target,i+1,path,tail,cval,res)
                #backtrack
                tail=temp
                cval-=curr
                path=path[:-(len(curr_str)+1)]


                # '-'
                temp=tail
                cval-=curr
                path+='-'+curr_str
                tail=-curr
                
                #recurse
                helper(num,target,i+1,path,tail,cval,res)
                #backtrack
                tail=temp
                cval+=curr
                path=path[:-(len(curr_str)+1)]


                # '*'
                tempT=tail
                tempC=cval
                cval=(cval-tail)+(tail*curr)
                path+='*'+curr_str
                tail=tail*curr
                
                #recurse
                helper(num,target,i+1,path,tail,cval,res)
                #backtrack
                tail=temp
                cval=tempC
                path=path[:-(len(curr_str)+1)]

                
        
        helper(num,target,0,"",0,0,res)
        return res