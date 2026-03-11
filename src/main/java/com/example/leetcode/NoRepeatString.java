package com.example.leetcode;

import org.apache.logging.log4j.util.Strings;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName NoRepeatString
 * @Description: leetcode3
 * @Author: win10
 * @CreateDate: 2023/12/20 14:04
 * @Version: 1.0
 */
public class NoRepeatString {

    public static void main(String[] args) {
        System.out.println(findMaxLength2(" "));
    }

    /**
     * 暴力破解法
     * @param s
     * @return
     */
    public static int findMaxLength(String s){
        if (s == null){
            return 0;
        }
        int length = s.length();
        if (length == 1){
            return 1;
        }
        int maxLength = 0;
        StringBuffer maxStr = new StringBuffer();
        for (int i = 0; i < length - 1; i++) {
            maxStr.append(s.charAt(i));
            for (int j = i + 1; j < length; j++) {
                String jString = String.valueOf(s.charAt(j));
                if (maxStr.toString().contains(jString)){
                    if (maxLength < maxStr.length()){
                        maxLength = maxStr.length();
                    }
                    break;
                }
                maxStr.append(s.charAt(j));
                if (maxLength < maxStr.length()){
                    maxLength = maxStr.length();
                }
            }

            // 当i 结束时清空改字符串
            maxStr = new StringBuffer();
        }
        return maxLength;
    }

    /**
     * 滑动窗口法
     * 比如abcabcbc的结果是abc，当再出现a时，将开头的a移出，将新的a添加进去，然后继续移动
     * @param s
     * @return
     */
    public static int findMaxLength2(String s){
        if (s == null){
            return 0;
        }
        int length = s.length();
        if (length == 1){
            return 1;
        }
        StringBuffer result = new StringBuffer();
        int maxLength = 0;
        for (int i = 0; i < length; i++) {
            String dest = String.valueOf(s.charAt(i));
            if (result.toString().contains(dest)){
                int index = result.indexOf(dest);
                result.delete(0, index + 1);
            }
            result.append(dest);
            maxLength = Math.max(result.length(), maxLength);
        }
        return maxLength;
    }

    /**
     * 滑动窗口法
     * 比如abcabcbc的结果是abc，当再出现a时，将开头的a移出，将新的a添加进去，然后继续移动
     * @param s
     * @return
     */
    public static int findMaxLength3(String s){
        if (s.length()==0) return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0;
        int left = 0;
        for(int i = 0; i < s.length(); i ++){
            if(map.containsKey(s.charAt(i)){
                left = Math.max(left,map.get(s.charAt(i)) + 1);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-left+1);
        }
        return max;

    }

}