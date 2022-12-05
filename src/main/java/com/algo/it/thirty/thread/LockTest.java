package com.algo.it.thirty.thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ：yanpeidong371
 * @description：
 * @date : 2022年11月13日
 * @since: 1.0.0
 */
public class LockTest {

    public static void main(String[] args){
        LockTest threadTest = new LockTest();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0; i < 10;i++)
                threadTest.set();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0; i < 10;i++)
                threadTest.get();
            }
        }).start();
    }

    ReentrantLock lock = new ReentrantLock();
    Condition condition = lock.newCondition();
    public boolean flag =true;

    public void set(){
        try{
            lock.lock();
            while(flag){
                condition.await();
            }
            System.out.println("A");
            flag = !flag;
            condition.signal();
        }catch (Exception err){

        }finally {
            lock.unlock();
        }

    }

    public void get(){
        try{
            lock.lock();
            while(!flag){
                condition.await();
            }
            System.out.println("B");
            flag = !flag;
            condition.signal();
        }catch (Exception err){

        }finally {
            lock.unlock();
        }
    }
}
