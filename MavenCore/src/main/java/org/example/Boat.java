package org.example;

public class Boat implements Based{

    int speed;


    public Boat() {
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Boat(int speed) {
        this.speed = speed;
    }

    @Override
    public void test() {
        System.out.println("Iam in test of boat !!");
    }
}
