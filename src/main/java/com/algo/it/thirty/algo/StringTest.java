package com.algo.it.thirty.algo;

/**
 * @author ：yanpeidong371
 * @description：
 * @date : 2022年11月28日
 * @since: 1.0.0
 */
public class StringTest {

    public static void main(String[] args) {
        boolean check = StringTest.check("aleex", "aalex");

        boolean longPressedName = StringTest.isLongPressedName("alex", "blex");
        System.out.println(check);

        System.out.println(longPressedName);
    }

    public static boolean isLongPressedName(String name, String typed) {
        int i = 0, j = 0;
        while (j < typed.length()) {
            if (i < name.length() && name.charAt(i) == typed.charAt(j)) {
                i++;
                j++;
            } else if (j > 0 && typed.charAt(j) == typed.charAt(j - 1)) {
                j++;
            } else {
                return false;
            }
        }
        return i == name.length();
    }

    public static boolean check(String name, String type){
        String[] nameArr = name.split("");
        String[] typeArr = type.split("");
        int p1=0;int p2=0;
        while (p2<typeArr.length){
            if(typeArr[p2].equals(nameArr[p1])){
                p2++;
            }else{
                if(p2==0){
                    return false;
                }
                p1++;
            }
            if(p1>p2){
                return false;
            }
        }
        return true;

    }
}
