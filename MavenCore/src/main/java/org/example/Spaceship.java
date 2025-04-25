package org.example;

public class Spaceship implements Based {

    int time;

    public Spaceship(int time) {
        this.time = time;
    }

//    public Spaceship(){
//        System.out.println("Spaceship object created");
//    }
    public void landed() {
        System.out.println("spaceship has landed !! at time "+ this.time);
    }

    @Override
    public void test() {
        System.out.println("Iam in test of a spceship!!");
    }
}
