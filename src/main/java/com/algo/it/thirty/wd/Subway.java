package com.algo.it.thirty.wd;

/**
 * @author ：yanpeidong371
 * @description：
 * @date : 2022年11月16日
 * @since: 1.0.0
 */
public class Subway {

    private int id;
    private String name;
    private int bikeNum;

    public Subway(int bikeNum, String name, int id) {
        this.bikeNum = bikeNum;
        this.id = id;
        this.name =name;
    }






    public int getBikeNum() {
        return bikeNum;
    }

    public void setBikeNum(int bikeNum) {
        this.bikeNum = bikeNum;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
