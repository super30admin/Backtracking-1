# Time Complexity : O(2^n)
# space complexity : O(n)

# Approach :

#   Choose or not choose recursion
#   keep two recursive calls, one which includes the element and another which moves the index to the next position
#   keep a list which adds element to it
#   if target is negative or equal to length of candidates array, return back. If target is 0, add the combination to a final result array
#   in recursive call, make sure to pass a copy of the array and not the reference as it can lead to appending all the elements in the answer


#   Choose or not choose backtracking
#   keep two recursive calls, one which includes the element and another which moves the index to the next position
#   keep a list which adds element to it
#   if target is negative or equal to length of candidates array, return back. If target is 0, add the combination to a final result array
#   in backtracking, remove the last element from the array and add a copy of the array to the final list as otherwise the array can become empty


#   for loop based recursion
#   keep one recursive call
#   keep a newlist which keeps getting new elements added
#   iterate from index to length of the candidates array
#   if target is negative return back. If target is 0, add the combination to a final result array

#   for loop based bactracking
#   keep one recursive call
#   keep adding to the elements to path list array
#   iterate from index to length of the candidates array
#   if target is negative return back. If target is 0, add the combination to a final result array
#   keep popping the last element from the list
#   keep a copy of the list to be appended to the final array list, else it will be empty.

# Choose or not choose recursion solution
class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:

        self.path = []
        self.recurse(candidates, target, 0, [])
        return self.path

    def recurse(self, candidates, target, index, pathNew):

        if target < 0 or len(candidates) == index:
            return

        if target == 0:
            self.path.append(pathNew)
            return

        self.recurse(candidates, target, index+1, list(pathNew))
        pathNew.append(candidates[index])
        self.recurse(candidates, target -
                     candidates[index], index, list(pathNew))


# Choose or not choose backtrack solution
class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:

        self.path = []
        self.backtrack(candidates, target, 0, [])
        return self.path

    def backtrack(self, candidates, target, index, pathNew):

        if target < 0 or len(candidates) == index:
            return

        if target == 0:
            self.path.append(list(pathNew))
            return

        self.backtrack(candidates, target, index+1, pathNew)
        pathNew.append(candidates[index])
        self.backtrack(candidates, target-candidates[index], index, pathNew)
        pathNew.pop()


# for loop based  recursion solution
class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:

        self.path = []
        self.backtrack(candidates, target, 0, [])
        return self.path

    def backtrack(self, candidates, target, index, pathNew):

        if target < 0:
            return

        if target == 0:
            self.path.append(pathNew)
            return

        for i in range(index, len(candidates)):

            new_path = list(pathNew)
            new_path.append(candidates[i])
            self.backtrack(candidates, target-candidates[i], i, new_path)


# for loop based  backtracking solution
class Solution:
    def combinationSum(self, candidates: List[int], target: int) -> List[List[int]]:

        self.path = []
        self.backtrack(candidates, target, 0, [])
        return self.path

    def backtrack(self, candidates, target, index, pathNew):

        if target < 0:
            return

        if target == 0:
            self.path.append(list(pathNew))
            return

        for i in range(index, len(candidates)):

            pathNew.append(candidates[i])
            self.backtrack(candidates, target-candidates[i], i, pathNew)
            pathNew.pop()
