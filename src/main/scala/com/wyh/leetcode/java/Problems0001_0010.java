package com.wyh.leetcode.java;

import java.util.HashMap;

class Problems0001_0010 {

    public int[] twoSum(int[] nums, int target) {
        for(int i = nums.length - 1; i >= 0; i--){
            for(int j = 0; j < i; j++){
                if (nums[i] + nums[j] == target){
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

    int[] twoSum2(int[] nums, int target) {
        HashMap<Integer, Integer> hashTable = new HashMap<>();
        for(int i = nums.length - 1; i >= 0; i--){
            if (hashTable.containsKey(target - nums[i])) {
                return new int[]{i, hashTable.get(target - nums[i])};
            }
            hashTable.put(nums[i], i);
        }
        return new int[0];
    }

}
