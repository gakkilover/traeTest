package com.example.leetcode;

import java.util.LinkedList;

/**
 * @ClassName MaxLongChildString
 * @Description:
 * @Author: win10
 * @CreateDate: 2023/12/29 18:38
 * @Version: 1.0
 *  找出最长连续子字符串，只能有一个字母，其余必须是数字，比如abC124ACb，，答案是C124或者124A，长度都是4，输出为4，如果都不满足，输出为-1
 */
public class MaxLongChildString {

    public static void main(String[] args) {
        System.out.println(findMaxLongInString("abC124ACb"));
        System.out.println(findMaxLongInString("abc"));
        System.out.println(findMaxLongInString("123"));
    }

    public static int findMaxLongInString(String origin){
        int maxLength = -1;
        boolean hasLetter = false;

        int left = 0, right = 0;
        LinkedList<Integer> letterIndex = new LinkedList<>();

        while(right < origin.length()){
            char c = origin.charAt(right);

            // 如果是字母
            if (isChar(c)){
                // 字符信号量标记为true
                hasLetter = true;
                // 加入链表中
                letterIndex.add(right);

                // 如果字符数量超出移出第一个，使得left等于第一个出现字符的位置往后移动一个
                if (letterIndex.size() > 1){
                    left = letterIndex.removeFirst() + 1;
                }


                if (right == left){
                    right ++ ;
                    continue;
                }
            }


            maxLength = Math.max(maxLength, right - left + 1);
            right ++;
        }
        if (!hasLetter){
            return  -1;
        }
        return maxLength;
    }

    public static boolean isChar(char c){
        return (c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z');
    }                                                           
}