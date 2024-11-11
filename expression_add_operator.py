class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        result = []

        self.helper(num, 0, 0, 0, "", target, result)
        return result

    def helper(self, num, pivot, calc, tail, path, target, result):
        # base case
        if pivot == len(num):
            if calc == target:
                result.append(path)
            return

        # logic
        for i in range(pivot, len(num)):
            if i != pivot and num[pivot] == "0":
                break
            curr_num = int(num[pivot : i + 1])

            if pivot == 0:
                # First number, pick it without any operator
                self.helper(
                    num, i + 1, curr_num, curr_num, path + str(curr_num), target, result
                )
            else:
                # Addition
                self.helper(
                    num,
                    i + 1,
                    calc + curr_num,
                    curr_num,
                    path + "+" + str(curr_num),
                    target,
                    result,
                )
                # Subtraction
                self.helper(
                    num,
                    i + 1,
                    calc - curr_num,
                    -curr_num,
                    path + "-" + str(curr_num),
                    target,
                    result,
                )
                # Multiplication
                self.helper(
                    num,
                    i + 1,
                    (calc - tail) + (tail * curr_num),
                    tail * curr_num,
                    path + "*" + str(curr_num),
                    target,
                    result,
                )


# time complexity is O(4^n)
# space complexity is O(n)
