# tc O(n*3^n), sc O(n).
def dfs(idx, path, sumn, prev):
    if idx == len(num):
        if sumn == target:
            res.append(path)
        return
    
    for i in range(idx, len(num)):
        curr_str = num[idx:i+1]
        curr_num = int(curr_str)
        if idx == 0:
            dfs(i+1, curr_str, curr_num, curr_num)
        else:
            dfs(i+1, path + "+" + curr_str, sumn + curr_num, curr_num)
            dfs(i+1, path + "-" + curr_str, sumn - curr_num, -curr_num)
            dfs(i+1, path + "*" + curr_str, (sumn - prev) + (curr_num * prev), curr_num * prev)
        
        # remove trailing zero case
        if num[idx] == "0":
            break
    
res = []
dfs(0, '', 0, 0)
return res