package com.example.leetcode;

import java.math.BigInteger;

/**
 * @ClassName StringMinSum
 * @Description:
 * @Author: win10
 * @CreateDate: 2023/12/29 18:21
 * @Version: 1.0
 * 找出给定字符串中最小的整数和，比如ab23-34c中 2 + 3 - 34=-29是最小整数和
 */
public class StringMinSum {
    public static void main(String[] args) {
        System.out.println(calculateMinSum("-23-34a"));
    }

    public static String calculateMinSum(String origin){
        boolean isNegative = false;

        StringBuffer sb = new StringBuffer();

        BigInteger result = new BigInteger("0");

        for (int i = 0; i < origin.length(); i++) {
            char c = origin.charAt(i);

            // 如果是数字
            if (c >= '0' && c <= '9'){
                if (isNegative){
                    // 如果是负数, 代表需要拼接
                    sb.append(c);
                }else {
                    // 不是负数则直接相加
                    result = result.add(new BigInteger(c + ""));
                }
            }else {
                if (isNegative){
                    result = result.subtract(new BigInteger(sb.toString()));
                    sb = new StringBuffer();
                }
                isNegative = c == '-';
            }
        }

        if (sb.length() > 0){
            result = result.subtract(new BigInteger(sb.toString()));
        }
        return result.toString();
    }
}