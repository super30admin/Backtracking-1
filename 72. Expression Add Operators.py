class Solution:
    def addOperators(self, num: str, target: int) -> List[str]:
        res = []

        # dfs is being used to explore all possible operator insertions
        def dfs(index, path, value, prev):
            # If we are reaching the end of string and value == target
            if index == len(num):
                if value == target:
                    res.append("".join(path))  # Appending valid expression
                return

            # We are iterating over all possible splits of the remaining string
            for i in range(index, len(num)):
                # Avoiding numbers with leading zeros
                if i != index and num[index] == "0":
                    break

                cur_str = num[index:i+1]      # Taking current substring
                cur_num = int(cur_str)        # Converting substring to integer

                if index == 0:
                    # Starting new expression without operator
                    dfs(i+1, [cur_str], cur_num, cur_num)
                else:
                    # Adding '+' operator and updating value
                    dfs(i+1, path + ["+", cur_str], value + cur_num, cur_num)

                    # Adding '-' operator and updating value
                    dfs(i+1, path + ["-", cur_str], value - cur_num, -cur_num)

                    # Adding '*' operator and fixing previous multiplication precedence
                    dfs(i+1, path + ["*", cur_str], value - prev + prev * cur_num, prev * cur_num)

        # Starting DFS from index 0
        dfs(0, [], 0, 0)
        return res
# Time Complexity (TC): O(4^n), where n is the length of the input string num. This is because for each digit, we have 4 choices (adding '+', '-', '*', or no operator).
# Space Complexity (SC): O(n), where n is the length of the input string num. This is due to the recursion stack and the space used to store the current expression path.