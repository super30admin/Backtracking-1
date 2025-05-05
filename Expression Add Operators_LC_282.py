class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        if len(num) == 0 or not num:
            return []
        self.result = []
        self.recurse(num, target, 0, 0, 0, "")
        return self.result
    
    def recurse(self, num, target, index, calc, tail, path):
        # base
        if index == len(num) and calc == target:
            self.result.append(path)
            return
        if index == len(num):
            return

        # logic

        for i in range(index, len(num)):
            if num[index] == "0" and i != index:
                continue
            curr = int(num[index:i + 1])
            if index == 0:
                self.recurse(num, target, i + 1, curr, curr, path + str(curr))
            else:
                # "+" case
                self.recurse(num, target, i + 1, calc + curr, int(+curr), path + "+" + str(curr))
                # "-" case
                self.recurse(num, target, i + 1, calc - curr, -curr, path + "-" + str(curr))
                # "*" case
                self.recurse(num, target, i + 1, calc - tail + (tail * curr), tail * curr, path + "*" + str(curr))
            
