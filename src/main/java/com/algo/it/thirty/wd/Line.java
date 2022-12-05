package com.algo.it.thirty.wd;

import java.util.HashMap;

/**
 * @author ：yanpeidong371
 * @description：
 * @date : 2022年11月16日
 * @since: 1.0.0
 */
public class Line {

    String name;
    Integer distance;

    public Line(String name, Integer distance) {
        this.name = name;
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public static final HashMap<String,Integer> lineMap = new HashMap(){{
        put("A-B",14);
        put("B-C",9);
        put("C-A",5);
    }};

    public static Line getLine(Subway subway){
        String lineName = lineMap.keySet().stream().filter(name -> name.contains(subway.getName())).findAny().get();
        return new Line(lineName, lineMap.get(lineName));
    }
}