package com.learn.unittesting.business;

import org.springframework.stereotype.Service;

@Service
public class SomeBusinessImpl {

    public int calculateSum(int[] nums){
        int total = 0;
        for (int num : nums){
            total += num;
        }
        return total;
    }
}
