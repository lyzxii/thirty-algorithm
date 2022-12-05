package com.algo.it.thirty.wd;

/**
 * @author ：yanpeidong371
 * @description：
 * @date : 2022年11月16日
 * @since: 1.0.0
 */
public class Monitor implements Runnable {

    SubwayManager subwayManager;

    public Monitor(SubwayManager subwayManager) {
        this.subwayManager = subwayManager;
    }

    @Override
    public void run() {
        while(Thread.currentThread().isInterrupted()){

        }
    }
}
