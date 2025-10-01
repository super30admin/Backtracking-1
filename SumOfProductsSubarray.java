//package Backtracking-1;

public class SumOfProductsSubarray {
    long sum;
    long prod;
    boolean choose;
    private long calSumOfProducts(int[] nums){
        this.sum = 0;
        this.prod = 1;
        this.choose = true;
        helper(nums, 0, prod, choose);
        return sum;
    }

    private void helper(int[] nums, int idX, long prod, boolean choose){

        //base
        if(idX == nums.length) return;

        //logic 
        prod*=nums[idX];
        System.out.println("prod = " + prod);
        helper(nums, idX+1, sum + prod, true);
        helper(nums, idX+1, prod, false);

    }

    public static void main(String[] args){
        int[] nums = {2,3,6,7};
        SumOfProductsSubarray solution  = new SumOfProductsSubarray();
        long res = solution.calSumOfProducts(nums);
        System.out.println("Sum of product of all sub arrays = " + res);
    }
    
}
