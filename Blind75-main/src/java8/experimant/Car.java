package java8.experimant;

public class Car {
    int serial;
    String name;

    public Car(int serial, String name) {
        this.serial = serial;
        this.name = name;
    }

    public int getSerial() {
        return serial;
    }

    public void setSerial(int serial) {
        this.serial = serial;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
