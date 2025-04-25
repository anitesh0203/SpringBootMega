package org.example;

public class Alien {



    Spaceship spaceship;

    Boat boat;

    int val;


    public Alien() {
    }

    public Alien(Spaceship spaceship, Boat boat) {
        this.spaceship = spaceship;
        this.boat = boat;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        System.out.println("setter has been called ");
        this.val = val;
    }

    public void run() {
        System.out.println("Alien is running !!"+this.val);
        this.spaceship.landed();
        this.boat.getSpeed();
    }

    public Spaceship getSpaceship() {
        return spaceship;
    }

    public void setSpaceship(Spaceship spaceship) {
        this.spaceship = spaceship;
    }
}
