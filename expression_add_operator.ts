function addOperators(num: string, target: number): string[] {
  let result: string[] = [];

  function backtrack(
    pivot: number,
    path: string,
    calculated: number,
    tail: number
  ) {
    // base case
    if (pivot == num.length) {
      if (calculated == target) {
        result.push(path);
      }
    }

    // for loop based choose case
    for (let index = pivot; index < num.length; index++) {
      let strNum: string = num.slice(pivot, index + 1);
      let currentNum = Number(strNum)!;
      if (currentNum == 0 && pivot != index) continue;
      if (index == 0) {
        backtrack(index + 1, path + strNum, currentNum, currentNum);
      } else {
        // +
        backtrack(
          index + 1,
          path + "+" + strNum,
          calculated + currentNum,
          currentNum
        );

        // -
        backtrack(
          index + 1,
          path + "-" + strNum,
          calculated - currentNum,
          -currentNum
        );

        // *
        backtrack(
          index + 1,
          path + "*" + strNum,
          calculated - tail + tail * currentNum,
          tail * currentNum
        );
      }
    }
  }

  backtrack(0, "", 0, 0);

  console.log(result);

  return result;
}

describe("Expression Add Operators", () => {
  it("Happy Path - 01", () => {
    let num = "123",
      target = 6;
    expect(addOperators(num, target)).toStrictEqual(["1+2+3", "1*2*3"]);
  });
});
