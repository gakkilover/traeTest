package com.example.test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.PrimitiveIterator;
import java.util.Set;
import java.util.stream.IntStream;

public class Test {

    static String str = "hello";

    static String str2 = new String("hello");

    static String str3 = "hello";

    static String str4 = new String(str3);
    // 13579
    // 2468
    public static void main(String[] args) {

        System.out.println(str == str2);
        System.out.println(str == str3);
        System.out.println(str2 == "hello");
        System.out.println(str3 == str4);
        int a=1 ;
        int b=2;
        change(a,b);
        System.out.println(a);


//        StringBuffer buffer = new StringBuffer(str);
//
//        System.out.println(buffer.reverse());
//
//        Integer[] numbers = new Integer[]{1,2,3,45,6,1,4,3,45};
//
//        Set<Integer> result = new HashSet<>(Arrays.asList(numbers));
    }


    public static void change(int a, int b){
        int temp = a;
        a= b;
        b= temp;
    }



    public int[] twoSum1(int[] nums, int target) {
        int length = nums.length;
        Set<Integer> correctSet = new HashSet<>();
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (i != j) {
                    if (nums[i] + nums[j] == target) {
                        correctSet.add(i);
                        correctSet.add(j);
                    }
                }
            }
        }
        Integer[] correctSum = correctSet.
        toArray(new Integer[correctSet.size()]);
        return Arrays.stream(correctSum).
        mapToInt(Integer::valueOf).toArray();
    }
    public static int binarySearch(int[] arr, int target) {
        int max = arr.length - 1;
        int min = 0;
        int mid = (max + min) / 2;
        int count = 0;
        while (max >= min) {
            count++;
            if (target > arr[mid]) {
                min = mid + 1;
            } else if (target < arr[mid]) {
                max = mid - 1;
            } else {
                return count;
            }
            mid = (max + min) / 2;
        }

        return -1;
    }

    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length-1; i++) {
            boolean flg = false;
            for (int j = 0; j < array.length-1 -i; j++) {
                if(array[j] > array[j+1]) {
                    int tmp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = tmp;
                    flg = true;
                }
            }
            if(flg == false) {
                return;
            }
        }
    }
}