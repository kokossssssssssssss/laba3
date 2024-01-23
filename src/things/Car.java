package things;

import people.Human;

public class Car extends Thing {
    private int number;
    private int x;
    private int y;
    private final Human owner; //хозяин машины

    public Car(Human owner) {
        this.owner = owner;
    }


    public void drive(int x) {
        this.x = x;
    }


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }


    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }
        Car car = (Car) o;
        return this.owner.getClass().equals(car.owner.getClass());
    }

    @Override
    public int hashCode() {
        return this.number;
    }
}
