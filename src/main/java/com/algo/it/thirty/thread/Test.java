package com.algo.it.thirty.thread;

/**
 * @author ：yanpeidong371
 * @description：'
 * @date : 2022年11月13日
 * @since: 1.0.0
 */
public class Test implements Runnable{

    public static void main(String[] args) {
        Object a = new Object();
        Object b = new Object();
        Object c = new Object();
        Test a1 = new Test(a, b, "A");
        Test a2 =new Test(b,c,"B");
        Test a3 =new Test(c,a,"C");



        new Thread(a1).start();
        new Thread(a2).start();
        new Thread(a3).start();

    }

    public Test(Object pre, Object prev, String name) {
        this.pre = pre;
        this.prev = prev;
        this.name = name;
    }

    private Object pre;
    private Object prev;
    private String name;

    @Override
    public void run() {
        int i =30;
        while(i > 0) {
            synchronized (pre) {
                synchronized (prev) {
                    System.out.println(name);
                    i--;
                    try{
                        Thread.sleep(1);
                    }
                    catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    prev.notify();
                }

                try {
                    pre.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
