# tc O(n^(target/min(candidates))), sc O(n^(target/min(candidates)) + target/min(candidates)).
def dfs(sumn, idx):
    # base case
    if sumn == target:
        res.append(path[:])
        return
    
    if sumn > target:
        return
    if idx == len(candidates):
        return

    # recursive case
    for curridx in range(idx, len(candidates)):
        path.append(candidates[curridx])
        dfs(sumn+candidates[curridx], curridx)
        path.pop()


res = []
path = []
dfs(0, 0)
return res