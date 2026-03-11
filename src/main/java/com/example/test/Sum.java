package com.example.test;

import org.springframework.boot.web.server.Ssl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 * @ClassName Sum
 * @Description:
 * @Author: win10
 * @CreateDate: 2024/3/14 20:22
 * @Version: 1.0
 */
public class Sum {

    // 4
    //8 6 2 8 6
    //cam 66 70 46 158 80
    //vic 94 76 86 189 211
    //cn 29 17 83 21 48
    //em 53 97 1 19 218
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 多少个
        int count = in.nextInt();

        // 维护权重
        int[] percent = new int[5];
        int index = 0;
        while(in.hasNextInt()){
            percent[index] = in.nextInt();
            index ++;
        }

        // 维护名称以及对应认热度信息
        Map<String, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < count + 1; i++) {
            String nextLine = in.nextLine();
            if ("".equals(nextLine)){
                continue;
            }
            String[] s = nextLine.split(" ");
            String name = s[0];
            ArrayList<Integer> data = new ArrayList<>();
            for (int i1 = 1; i1 < s.length; i1++) {
                data.add(Integer.valueOf(s[i1]));
            }
            map.put(name, data);
        }

        // 计算热度值
        Map<Integer, String> result = new HashMap<>();
        for (String name : map.keySet()) {
            ArrayList<Integer> data = map.get(name);
            Integer sum = 0;
            for (int i = 0; i < percent.length; i++) {
                sum += data.get(i) * percent[i];
            }
            result.put(sum, name);
        }
        Object[] array = result.keySet().stream().sorted().toArray();
        for (int i = array.length - 1; i >=0 ; i--) {
            System.out.println(result.get(array[i]));
        }
    }
}