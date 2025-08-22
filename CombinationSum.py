# Approach 1 (w/o backtracking)
class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        if candidates == None or len(candidates) == 0:
            return []
        self.result = []
        self.recurse(candidates, target, [], 0)
        return self.result

    def recurse(self, candidates: List[int], target: int, path: List[int], indx: int) -> None:
        # base (invalid and valid cases)
        if target < 0 or indx >= len(candidates):
            return []
        
        if target == 0:
            self.result.append(path)
            return

        # Logic

        # case 0
        # self.recurse(candidates, target, path, indx + 1) -- if we use this method, the path is always adding every new element in the path list, because the memory reference of that list is the same for every iteration. We need to create new list for every iteration.
        self.recurse(candidates, target, [num for num in path], indx + 1) # this creates a copy of the values of path list rather than calling the path list directly

        # case 1
        path.append(candidates[indx])
        # self.recurse(candidates, target - candidates[indx], path, indx)
        self.recurse(candidates, target - candidates[indx], [num for num in path], indx)

# Approach 2 (with backtracking)
class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        if candidates == None or len(candidates) == 0:
            return []
        self.result = []
        self.recurse(candidates, target, [], 0)
        return self.result

    def recurse(self, candidates: List[int], target: int, path: List[int], indx: int) -> None:
        # base (invalid and valid cases)
        if target < 0 or indx >= len(candidates):
            return []
        
        if target == 0:
            self.result.append([nums for nums in path])
            return

        # Logic

        # case 0
        self.recurse(candidates, target, path, indx + 1)

        # case 1
        #action
        path.append(candidates[indx])

        #recursion
        self.recurse(candidates, target - candidates[indx], path, indx)

        #backtrack
        path.pop()


# Approach 3 (for loop recursion method) (with backtracking)
class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:
        if candidates == None or len(candidates) == 0:
            return []
        self.result = []
        self.recurse(candidates, target, [], 0)
        return self.result

    def recurse(self, candidates: List[int], target: int, path: List[int], pivot: int) -> None:
        # base (invalid and valid cases)
        if target < 0:
            return []
        
        if target == 0:
            self.result.append([nums for nums in path])
            return

        # Logic
        for i in range(pivot, len(candidates)):
            #action
            path.append(candidates[i])

            #recursion
            self.recurse(candidates, target - candidates[i], path, i)

            #backtrack
            path.pop()