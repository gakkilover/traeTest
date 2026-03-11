package com.example.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @ClassName RichFamily
 * @Description:
 * @Author: win10
 * @CreateDate: 2024/3/14 21:10
 * @Version: 1.0
 */
public class RichFamily {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        // 维护成员以及对应价值
        HashMap<Integer, Integer> members = new HashMap<Integer, Integer>();
        for (int i = 0; i < count; i++) {
            members.put(i + 1, in.nextInt());
        }

        //维护成员关联关系
        HashMap<Integer, ArrayList<Integer>> memberRelation = new HashMap<>();
        for (int i = 0; i < count; i++) {
            String nextLine = in.nextLine();
            if ("".equals(nextLine)){
                continue;
            }
            String[] arrs = nextLine.split(" ");
            if (arrs.length >= 2){
                Integer memberIndex = Integer.valueOf(arrs[0]);
                Integer memberChild = Integer.valueOf(arrs[1]);
                if (memberRelation.containsKey(memberIndex)){
                    ArrayList<Integer> memberData = memberRelation.get(memberIndex);
                    memberData.add(memberChild);
                    memberRelation.put(memberIndex, memberData);
                }else{
                    ArrayList<Integer> memberData = new ArrayList<>();
                    memberData.add(memberChild);
                    memberRelation.put(memberIndex, memberData);
                }
            }
        }

        // 计算最大价值
        int maxCount = 0;
        for (Integer memberIndex : memberRelation.keySet()) {
            int value = 0;
            ArrayList<Integer> memberData = memberRelation.get(memberIndex);
            if (!memberData.isEmpty()){
                value += members.get(memberIndex);
                for (int i = 0; i < memberData.size(); i++) {
                    Integer memberChild = memberData.get(i);
                    value += members.get(memberChild);
                }
            }

            maxCount = Math.max(value, maxCount);
        }
        System.out.println(maxCount);
    }
}