# Problem2: Expression Add Operators(https://leetcode.com/problems/expression-add-operators/)
# Time Complexity: O(4^n * n), We have n minus 1 gaps between digits. At each gap we have up to 4 real choices: plus, minus, times or letting digits join into a longer number. This gives roughly 4^n different expressions we build. Building each expression also costs up to n work,because we copy the path string every time we add a piece to it.
# Space Complexity: O(n),The recursion goes at most n levels deep, one level for each digit we place. Each level holds a path string of length up to about 2n. This does not count the final result list, since that is the required output, not extra working space.

# Approach:
# We walk through the digit string left to right and decide, at each step, how many digits to grab for the next number, then which operator to place before it.
# We carry calc, the running value of the expression and tail, the value of the last piece we added into calc. Tail lets us undo the last addition when we hit a multiply, since multiply must be applied before the operator that came before it.
class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        self.result = []  # holds every finished expression whose value equals target

        def helper(num, target, pivot, calc, tail, path):
            # pivot is the index where the next number will start
            # calc is the value of the expression built so far
            # tail is the value of the last piece that was added into calc
            # path is the expression string built so far

            if pivot == len(num):   # we have used every digit in num, so path is a complete expression
                if calc == target:   # calc already holds the value of path, so no need to evaluate the string
                    self.result.append(path)
                return
        
            for i in range(pivot, len(num)):
                # i is the last index we include in the next number
                # trying every i in turn lets the next number be one digit, two digits and so on

                if num[pivot] == '0' and i != pivot:
                    # the number we are building starts with 0 and has more than one digit
                    # that is not allowed, for example 05 is not a valid number
                    break
                    # every longer slice from this pivot will also start with this same 0
                    # so there is no point checking any larger i, we leave the loop

                curr = int(num[pivot:i+1])
                # take the substring from pivot up to and including i, then turn it into a number
                # the plus 1 is needed because slicing stops before the index we give it

                if pivot == 0:
                    # this is the very first number of the expression
                    # it has no operator in front of it, so we just place it as is
                    helper(num, target, i+1, curr, curr, path + str(curr))
                    # calc becomes curr since this is the only piece so far
                    # tail becomes curr as well since it is also the last piece added

                else:
                    # every number after the first one needs an operator in front of it
                    # we try all three operators, one after another, not just one of them

                    # plus branch
                    helper(num, target, i+1, calc + curr, curr, path + "+" + str(curr))
                    # add curr to calc, tail becomes curr since curr is now the last piece added

                    # minus branch
                    helper(num, target, i+1, calc - curr, -curr, path + "-" + str(curr))
                    # subtract curr from calc, tail becomes negative curr
                    # storing tail as negative here makes the multiply undo trick work later
                    # without needing any special case for minus

                    # times branch
                    helper(num, target, i+1, calc - tail + (tail * curr), tail * curr, path + "*" + str(curr))
                    # first remove tail from calc, undoing the last piece we added
                    # then add back tail times curr, which is the correct value once multiply
                    # is applied before the earlier operator
                    # tail becomes tail times curr, since that whole product is now the last piece

        helper(num, target, 0, 0, 0, "")
        # start with pivot at 0, calc and tail at 0, and an empty path
        # calc and tail being 0 here does not matter since the pivot equals 0 branch
        # does not use their old values anyway

        return self.result
