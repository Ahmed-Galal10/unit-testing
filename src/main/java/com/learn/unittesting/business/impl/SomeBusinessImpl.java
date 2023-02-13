package com.learn.unittesting.business.impl;

import com.learn.unittesting.data.DataService;
import org.springframework.stereotype.Service;

@Service
public class SomeBusinessImpl {

    private DataService dataService;

    public void setDataService(DataService dataService) {
        this.dataService = dataService;
    }

    public int calculateSum(int[] nums) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        return total;
    }

    public int calculateSumUsingDataService() {
        int total = 0;
        int[] nums = dataService.getAllNums();
        for (int num : nums) {
            total += num;
        }
        return total;
    }
}
