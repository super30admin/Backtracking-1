
# this is every new list for every stage
#space -- o(2^(m+n))
#time - o(2^(m+n))
class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:

        if candidates == None or len(candidates) == 0:
            return []

        self.result = []
        self.recurse(candidates, [], 0, target)
        return self.result

    def recurse(self, candidates: List[int], path: List[int], pivot: int, target: int) -> None:
        # base
        if target < 0:
            return

        if target == 0:
            self.result.append([i for i in path])
            return

        # logic
        for i in range(pivot, len(candidates)):
            newList = [i for i in path]
            newList.append(candidates[i])
            self.recurse(candidates, newList, i, target - candidates[i])


#space -- o(m+n)
#time - o(2^(m+n))
#back track  method
class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:

        if candidates == None or len(candidates) == 0:
            return []

        self.result = []
        self.recurse(candidates, [], 0, target)
        return self.result

    def recurse(self, candidates: List[int], path: List[int], pivot: int, target: int) -> None:
        # base
        if target < 0:
            return

        if target == 0:
            self.result.append([i for i in path])
            return

        # logic
        for i in range(pivot, len(candidates)):
            #action
            path.append(candidates[i])
            #recurse
            self.recurse(candidates, path, i, target - candidates[i])
            #backtrack
            path.pop()