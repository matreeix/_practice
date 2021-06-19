package _leetcode._CONTEST._biweekly._36;

/**
 * @Description: 5515. 设计停车系统
 * * 请你给一个停车场设计一个停车系统。停车场总共有三种不同大小的车位：大，中和小，每种尺寸分别有固定数目的车位。
 * * 请你实现 ParkingSystem 类：
 * * <p>
 * * ParkingSystem(int big, int medium, int small) 初始化 ParkingSystem 类，三个参数分别对应每种停车位的数目。
 * * bool addCar(int carType) 检车是否有 carType 对应的停车位。 carType 有三种类型：大，中，小，分别用数字 1， 2 和 3 表示。
 * * 一辆车只能停在  carType 对应尺寸的停车位中。如果没有空车位，请返回 false ，否则将该车停入车位并返回 true 。
 * @Author: matreeix
 * @Date: 2020/10/3
 */

public class ParkingSystem {
    private int big;
    private int medium;
    private int small;
    private int curBig;
    private int curMedium;
    private int curSmall;

    public ParkingSystem(int big, int medium, int small) {
        this.big = big;
        this.medium = medium;
        this.small = small;
    }

    public boolean addCar(int carType) {
        if (getCurCar(carType) < getCar(carType)) {
            if (carType == 1) {
                curBig++;
            } else if (carType == 2) {
                curMedium++;
            } else {
                curSmall++;
            }
        } else {
            return false;
        }
        return true;
    }

    public int getCurCar(int carType) {
        return carType == 1 ? curBig : (carType == 2 ? curMedium : curSmall);
    }

    public int getCar(int carType) {
        return carType == 1 ? big : (carType == 2 ? medium : small);
    }

    public static void main(String[] args) {
        ParkingSystem obj = new ParkingSystem(1, 1, 0);
        boolean param_1 = obj.addCar(1);
    }
}

/**
 * Your ParkingSystem object will be instantiated and called as such:
 * ParkingSystem obj = new ParkingSystem(big, medium, small);
 * boolean param_1 = obj.addCar(carType);
 */