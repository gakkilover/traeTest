package com.example.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/*
* leetcode 1
* */
public class TwoSum {
    public static void main(String[] args) {
        int[] result = findLocation(new int[]{3,2,4}, 6);
        System.out.println(Arrays.toString(result));
    }

    public static int[] findLocation(int[] arr, int target) {
        int length = arr.length;
        Map<Integer, Integer> table = new HashMap<>();
        for (int i = 0; i < length; i++) {
            if (table.containsKey(target - arr[i])) {
                return new int[]{table.get(target - arr[i]), i};
            }
            table.put(arr[i], i);
        }
        return new int[0];
    }
}