package com.algo.it.thirty.wd;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author ：yanpeidong371
 * @description：
 * @date : 2022年11月16日
 * @since: 1.0.0
 */
public class TestMain {

    static List<Person> list = new LinkedList<>();
    volatile static int carOnWay =0;
    volatile static int carOnTransfer =0;

    public static void main(String[] args) {
        SubwayManager  subwayManager= new SubwayManager();
        new Thread(new Monitor(subwayManager)).start();
        for (int i =0; i <200; i++){
            Person person = new Person(subwayManager);
            carOnWay = carOnWay +1;
            push(person, carOnWay);
            transfer(subwayManager, i);
            System.out.println("A 站车" +  subwayManager.getSubwayA().getBikeNum() +
                    "，B 站车 "+  subwayManager.getSubwayB().getBikeNum()  +
                    ",C 站车" +  subwayManager.getSubwayC().getBikeNum() +
                    ",路上车" + carOnWay);
        }
    }

    private static void transfer(SubwayManager subwayManager, int i) {
        if(subwayManager.getSubwayA().getBikeNum() <= 20){
            if(subwayManager.getSubwayC().getBikeNum() >= 30){

            }
        }
    }

    public static void push(Person person, Integer carOnWay){
        list.add(person);
        List<Person> newList = list.stream().map(Person::countDown).collect(Collectors.toList());
        List<Person> collect = newList.stream().filter(e -> e == null).collect(Collectors.toList());
        carOnWay = carOnWay - (collect.size());
        list = newList.stream().filter(Person::over).collect(Collectors.toList());
        //

    }
}
