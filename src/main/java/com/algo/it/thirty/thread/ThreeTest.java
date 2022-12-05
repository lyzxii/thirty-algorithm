package com.algo.it.thirty.thread;

/**
 * @author ：yanpeidong371
 * @description：
 * @date : 2022年11月13日
 * @since: 1.0.0
 */
public class ThreeTest implements Runnable {
    public static void main(String[] args) throws Exception {
        Object a = new Object();
        Object b = new Object();
        Object c = new Object();
        ThreeTest pa = new  ThreeTest("A", c, a);
        ThreeTest pb = new  ThreeTest("B", a, b);
        ThreeTest pc = new  ThreeTest("C", b, c);


        new Thread(pa).start();
        Thread.sleep(100);
        new Thread(pb).start();
        Thread.sleep(100);
        new Thread(pc).start();
        Thread.sleep(100);
    }
    private String name;
    private Object prev;
    private Object self;

    private  ThreeTest(String name, Object prev, Object self) {
        this.name = name;
        this.prev = prev;
        this.self = self;
    }

    @Override
    public void run() {
        int count = 10;
        while (count > 0) {
            synchronized (prev) {
                synchronized (self) {
                    System.out.print(name);
                    count--;
                    try{
                        Thread.sleep(1);
                    }
                    catch (InterruptedException e){
                        e.printStackTrace();
                    }

                    self.notify();
                }
                try {
                    prev.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    }


}
