package com.algo.it.thirty.thread;

/**
 * @author ：yanpeidong371
 * @description：
 * @date : 2022年11月13日
 * @since: 1.0.0
 */
public class SyncTest {
    public static void main(String[] args) {
        SyncTest syncTest = new SyncTest();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i =0;i < 10;i++){
                    syncTest.set();
                }
            }
        }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i =0;i < 10;i++){
                    syncTest.get();
                }
            }
        }).start();
    }


    public boolean flag =true;
    public synchronized void set(){
        try{
            while (flag){
                this.wait();
            }
            System.out.println("A");
            flag = !flag;
            this.notify();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public synchronized void get(){
        try{
            while (!flag){
                this.wait();
            }
            System.out.println("B");
            flag = !flag;
            this.notify();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
