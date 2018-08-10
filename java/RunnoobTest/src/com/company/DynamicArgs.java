package com.company;

public class DynamicArgs {

    public DynamicArgs(double... nums){
        System.out.println("***** Dynamic args *****");

        if(nums.length == 0){
            System.out.println("No argument passed");
            return;
        }

        double result = nums[0];

        for(int i = 0; i < nums.length; i++){
            if(nums[i] > result){
                result = nums[i];
            }
        }

        System.out.println("Max value is " + result + "\n");
    }

}
