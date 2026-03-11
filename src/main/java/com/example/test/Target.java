package com.example.test;

import java.util.HashMap;

/**
 * @ClassName Target
 * @Description:
 * @Author: win10
 * @CreateDate: 2024/3/14 16:37
 * @Version: 1.0
 */
/*
示例 1：
输入：nums = [2,7,11,15], target = 9
9-2=7, 0
9-7=2,1
9-11=-2,3
9-15=-6,4
输出：[0,1]
解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。

示例 2：
输入：nums = [3,2,4], target = 6
输出：[1,2]

示例 3：
输入：nums = [3,3], target = 6
输出：[0,1]
 */
public class Target {
    public static void main(String[] args) {
//        getTarget(new int[]{2, 7, 11, 15}, 9);
        getTarget2(new int[]{2, 7, 11, 15}, 9);
    }
    public static void getTarget2(int[] nums, int target){
        //输入：nums = [2,7,11,15], target = 9
        //9-2=7, 0
        //9-7=2,1
        //9-11=-2,3
        //9-15=-6,4
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (Integer i : map.keySet()) {
            if (map.containsKey(target - i)){
                System.out.println(map.get(i));
                System.out.println(map.get(target - i));
                break;
            }
        }

    }
    public static void getTarget(int[] nums, int target){
        for(int index = 0;index< nums.length - 1; index++){
            for (int j = 1; j < nums.length; j++) {
                if (target == nums[index] + nums[j]){
                    System.out.println(index);
                    System.out.println(j);
                }
            }
        }
    }
}