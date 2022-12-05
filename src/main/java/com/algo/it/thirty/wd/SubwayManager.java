package com.algo.it.thirty.wd;

import java.util.Random;

/**
 * @author ：yanpeidong371
 * @description：
 * @date : 2022年11月16日
 * @since: 1.0.0
 */
public class SubwayManager {


    private volatile Subway subwayA;
    private volatile Subway subwayB;
    private volatile Subway subwayC;

    public SubwayManager() {
        this.subwayA = new Subway(30, "A",1);
        this.subwayB = new Subway(40,"B",2);
        this.subwayC = new Subway(30,"C",3);
    }

    public Subway getSubway() {
        Random random = new Random();
        int i = random.nextInt(3) + 1;
        if(i==subwayA.getId()){
            return subwayA;
        }
        if(i==subwayC.getId()){
            return subwayC;
        }
        if(i==subwayB.getId()){
            return subwayB;
        }
        return null;
    }


    public synchronized void add(String name){
        Subway subway = getSubway(name);
        subway.setBikeNum(subway.getBikeNum() + 1);
    }

    public synchronized void down(String name){
        Subway subway = getSubway(name);
        subway.setBikeNum(subway.getBikeNum() - 1);
    }


    public void check(){
        if(subwayA.getBikeNum()<=15){
            if(subwayB.getBikeNum() > 40){

            }
        }
    }





    public Subway getSubwayA() {
        return subwayA;
    }

    public void setSubwayA(Subway subwayA) {
        this.subwayA = subwayA;
    }

    public Subway getSubwayB() {
        return subwayB;
    }

    public void setSubwayB(Subway subwayB) {
        this.subwayB = subwayB;
    }

    public Subway getSubwayC() {
        return subwayC;
    }

    public void setSubwayC(Subway subwayC) {
        this.subwayC = subwayC;
    }

    public Subway getSubway(String name){
        switch (name){
            case "A":
                return subwayA;
            case "B":
                return subwayB;
            case "C":
                return subwayC;
        }
        return null;
    }
}
