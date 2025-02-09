#space:O(height of recursion stack)
#Time: O(n)
class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        self.final= list()
        self.backtrack(num, target,'',0,0,0,)
        return self.final


    def backtrack(self, num, target, path,calc, tail,index):
        if index == len(num) :
            if (calc == target):
                self.final.append(path)

        for i in range(index, len(num)):
            if(num[index] =='0') and index!=i:
                continue
            curr= int(num[index:i+1])
            if index== 0:
                self.backtrack(num, target, path+ str(curr), curr,curr, i+1)
            else:
                # + operator
                self.backtrack(num, target, path + '+'+str(curr), calc + curr, +curr, i+1)
                # - operator
                self.backtrack(num, target, path + '-'+str(curr), calc - curr, -curr, i+1)
                # * operator
                self.backtrack(num, target, path + '*'+str(curr), (calc- tail)+ tail*curr, tail*curr, i+1)
