package com.algo.it.thirty.design;

/**
 * @author ：yanpeidong371
 * @description：
 * @date : 2022年11月17日
 * @since: 1.0.0
 */
public class Singleton {

    private Singleton() {
    }

    //枚举方式实现
    public enum SingleEnum{

        SINGLE_ENUM;

        private Singleton instance;

        private SingleEnum() {
            this.instance = new Singleton();
        }
        public Singleton getInstance(){
            return instance;
        }
    }

    //饿汉式
    private static Singleton SINGLETON = new Singleton();
    public static Singleton getInstance01(){
        return SINGLETON;
    }


    //懒汉式
    private static Singleton instance;
    public static Singleton getInstance02(){
        if(instance ==null){
            synchronized (Singleton.class){
                if(instance ==null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }


    private static class SingletonClass{
        private static Singleton SINGLE_HOLDER = new Singleton();
    }

    public static Singleton getInstance03(){
        return SingletonClass.SINGLE_HOLDER;
    }

    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance03();
        Singleton instance03 = Singleton.getInstance03();
        System.out.println(instance ==instance03);
    }
}
