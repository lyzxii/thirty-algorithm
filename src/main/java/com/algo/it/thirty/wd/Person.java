package com.algo.it.thirty.wd;

/**
 * @author ：yanpeidong371
 * @description：
 * @date : 2022年11月16日
 * @since: 1.0.0
 */
public class Person implements Runnable{

    SubwayManager subwayManager;

    Subway subway;

    Line line;

    int distance;

    public Person(SubwayManager subwayManager) {
        Subway subway = subwayManager.getSubway();
        Line line = Line.getLine(subway);
        this.subwayManager =subwayManager;
        this.subway = subway;
        this.line = line;
        this.distance = line.getDistance();
        subwayManager.down(subway.getName());
        System.out.println("在地铁站" + subway.getName() +"出发,路线是："+ line.getName());
    }

    public Line getLine() {
        return line;
    }

    public void setLine(Line line) {
        this.line = line;
    }

    public Person countDown(){
        distance = distance -1;
        String[] lineArr = line.getName().split("-");
        if(distance ==0){
            subwayManager.add(lineArr[1]);
            return null;
        }
        return this;
    }

    public boolean over(){
        return distance ==0;
    }

    public void to(Subway subway){
        subway.setBikeNum(subway.getBikeNum() + 1);
    }

    @Override
    public void run() {

    }
}
