function combinationSum(candidates: number[], target: number): number[][] {
  function backtrack(
    candidates: number[],
    index: number,
    target: number,
    path: number[],
    result: number[][]
  ) {
    // Base Case
    if (target == 0) {
      result.push(path);
      return;
    }
    if (target < 0 || index == candidates.length) {
      return;
    }
    // Logic
    // No Choose Case
    backtrack(candidates, index + 1, target, [...path], result);
    // Choose Case
    // NOTE: Creating new array everytime.
    let list = [...path];
    list.push(candidates[index]);
    backtrack(candidates, index, target - candidates[index], list, result);
  }

  let results: number[][] = [];
  backtrack(candidates, 0, target, [], results);
  return results;
}

function combinationSumV2(candidates: number[], target: number): number[][] {
  function backtrack(
    candidates: number[],
    index: number,
    target: number,
    path: number[],
    result: number[][]
  ) {
    // Base Case
    if (target == 0) {
      result.push([...path]);
      return;
    }
    if (target < 0 || index == candidates.length) {
      return;
    }
    // Logic
    // No Choose Case
    backtrack(candidates, index + 1, target, path, result);
    // Choose Case
    path.push(candidates[index]);
    backtrack(candidates, index, target - candidates[index], path, result);
    path.pop(); // Backtracking Approach
  }

  let results: number[][] = [];
  backtrack(candidates, 0, target, [], results);
  return results;
}

function combinationSumPivot(candidates: number[], target: number): number[][] {
  let results: number[][] = [];
  function backtrack(pivot: number, sum: number, path: number[]) {
    if (sum == target) {
      results.push([...path]);
      return;
    }

    if (pivot == candidates.length || sum > target) {
      return;
    }

    for (let index = pivot; index < candidates.length; index++) {
      path.push(candidates[index]);
      backtrack(index, sum + candidates[index], path);
      path.pop();
    }
  }

  backtrack(0, 0, []);

  return results;
}

describe("Combination Sum", () => {
  it("Happy Path - 01", () => {
    let candidates = [2, 3, 6, 7];
    let target = 7;
    expect(combinationSum(candidates, target)).toStrictEqual([[7], [2, 2, 3]]);
  });

  it("Happy Path - 02", () => {
    let candidates = [2, 3, 6, 7];
    let target = 7;
    expect(combinationSumV2(candidates, target)).toStrictEqual([
      [7],
      [2, 2, 3],
    ]);
  });

  it("Happy Path - Pivot", () => {
    let candidates = [2, 3, 6, 7];
    let target = 7;
    expect(combinationSumPivot(candidates, target)).toEqual([[2, 2, 3], [7]]);
  });
});
