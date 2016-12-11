package com.calculator.ching.calculator.calculate;

import java.util.ArrayList;
import java.util.List;

public class calculate {

    //*和/的计算
    public static List<String> test2(String s){
        List<String> list_ = new ArrayList<String>();
        String[] str1 = s.split(" ");
        for (String s1 : str1){  list_.add(s1);  }
        int index = 0;
        String str = null;
        double multiplyBefore,multiplyAfter,divideBefore,divideAfter,result;

        for (int i = 0;i < list_.size();i ++) {
//            System.out.println("\nLoop:" + index + "");
            index++;
            str = (String) list_.get(i);
            switch (str) {
                case "*":
                    multiplyBefore = Double.parseDouble(list_.get(i - 1));
                    multiplyAfter = Double.parseDouble(list_.get(i + 1));
                    result = multiplyBefore * multiplyAfter;
//                    for (String s1 : list_) {  System.out.print(s1);  }

                    list_.add(i, result + "");
                    list_.remove(i + 1);
                    list_.remove(i + 1);
                    list_.remove(i - 1);
//                    System.out.println("\nNeed Calculate:" + multiplyBefore + str + multiplyAfter + "=" + result + "\n\n");
                    i = 0;
                    break;

                case "/":
                    divideBefore = Double.parseDouble(list_.get(i - 1));
                    divideAfter = Double.parseDouble(list_.get(i + 1));
                    if (divideAfter == 0){
//                        System.out.println("Error!");
                        list_.clear();
                        list_.add("错误");
                        return list_;
                    }
                    result = divideBefore / divideAfter;
//                    for (String s1 : list_) {  System.out.print(s1);  }

                    list_.add(i, result + "");
                    list_.remove(i + 1);
                    list_.remove(i + 1);
                    list_.remove(i - 1);
//                    System.out.println("\nNeed Calculate:" + divideBefore + str + divideAfter + "=" + result + "\n\n");
                    i = 0;
                    break;
            }
            if (!list_.contains("/") && !list_.contains("*")) {
//                System.out.println("No * or /");
//                for (String s1 : list_) {  System.out.print(s1);  }
//                System.out.println("\n");
                i = list_.size();
            }
        }
        return list_;
    }

    //+和-的计算
    public static List<String> test3 (List<String> list){
        List<String> list1 = new ArrayList<>();
        list1 = list;
        String op = "";
        double plusBefore,plusAfter,subtractBefore,subtractAfter,result;
        for (int i = 0;i < list.size();i ++){
            op = list.get(i);
            switch (op){
                case "+":
                    plusBefore = Double.parseDouble(list1.get(i - 1));
                    plusAfter = Double.parseDouble(list1.get(i + 1));
                    result = plusBefore + plusAfter;
                    list.add(i, result + "");
                    list.remove(i + 1);
                    list.remove(i + 1);
                    list.remove(i - 1);
//                    System.out.println(plusBefore+op+plusAfter+"="+result);
                    i = 0;
                    break;
                case "-":
                    subtractBefore = Double.parseDouble(list1.get(i - 1));
                    subtractAfter = Double.parseDouble(list1.get(i + 1));
                    result = subtractBefore - subtractAfter;
                    list.add(i, result + "");
                    list.remove(i + 1);
                    list.remove(i + 1);
                    list.remove(i - 1);
//                    System.out.println(subtractBefore+op+subtractAfter+"="+result);
                    i = 0;
                    break;
            }
        }
        return list1;
    }

    public static String test(String s){
        List<String> list_ = new ArrayList<String>();
        String[] str1 = s.split(" ");
        for (String s1 : str1){  list_.add(s1);  }
        int index = 0;
        String str = null;
        double multiplyBefore,multiplyAfter,divideBefore,divideAfter,result;
        double plusBefore,plusAfter,subtractBefore,subtractAfter;
        for (int i = 0;i < list_.size();i ++) {
            System.out.println("\nLoop:" + index + "");
            index++;
            str = (String) list_.get(i);
            switch (str) {
                case "*":
                    multiplyBefore = Double.parseDouble(list_.get(i - 1));
                    multiplyAfter = Double.parseDouble(list_.get(i + 1));
                    result = multiplyBefore * multiplyAfter;

                    for (String s1 : list_) {  System.out.print(s1);  }

                    list_.add(i, result + "");
                    list_.remove(i + 1);
                    list_.remove(i + 1);
                    list_.remove(i - 1);
                    System.out.println("\nNeed Calculate:" + multiplyBefore + str + multiplyAfter + "=" + result + "\n\n");
                    i = 0;
                    break;

                case "/":
                    divideBefore = Double.parseDouble(list_.get(i - 1));
                    divideAfter = Double.parseDouble(list_.get(i + 1));
                    result = divideBefore / divideAfter;

                    for (String s1 : list_) {  System.out.print(s1);  }

                    list_.add(i, result + "");
                    list_.remove(i + 1);
                    list_.remove(i + 1);
                    list_.remove(i - 1);
                    System.out.println("\nNeed Calculate:" + divideBefore + str + divideAfter + "=" + result + "\n\n");
                    i = 0;
                    break;
            }
            if (!list_.contains("/") && !list_.contains("*")) {
                switch (str) {
                    case "+":
                        plusBefore = Double.parseDouble(list_.get(i - 1));
                        plusAfter = Double.parseDouble(list_.get(i + 1));
                        result = plusBefore + plusAfter;

                        for (String s1 : list_) {  System.out.print(s1);  }

                        list_.add(i, result + "");
                        list_.remove(i + 1);
                        list_.remove(i + 1);
                        list_.remove(i - 1);
                        i = 0;
                        System.out.println("\nNeed Calculate:" + plusBefore + str + plusAfter + "=" + result + "\n\n");
                        break;
                    case "-":
                        subtractBefore = Double.parseDouble(list_.get(i - 1));
                        subtractAfter = Double.parseDouble(list_.get(i + 1));
                        result = subtractBefore - subtractAfter;

                        for (String s1 : list_) {  System.out.print(s1);  }

                        list_.add(i, result + "");
                        list_.remove(i + 1);
                        list_.remove(i + 1);
                        list_.remove(i - 1);
                        i = 0;
                        System.out.println("\nNeed Calculate:" + subtractBefore + str + subtractAfter + "=" + result + "\n\n");
                        break;
                }
            }

            if (!list_.contains("/") && !list_.contains("*") &&
                    !list_.contains("-") && !list_.contains("+")) {
                System.out.println(list_.get(i));
            }
        }
        return list_.get(1);
    }
}
