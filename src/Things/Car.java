package Things;

import Enums.Direction;
import People.Human;

public class Car extends Thing {
    private int number;
    private int x;
    private int y;
    private Human owner; //хозяин машины

    public Car(Human owner) {
        this.owner = owner;
    }

    public Car(Human owner, int number) {
        this.owner = owner;
        this.number = number;
    }

    public void drive(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void turn(Direction direction) {
        switch (direction) {

            case RIGHT:
                System.out.println("машина " + this.owner + " повернула вправо");
                break;
            case LEFT:
                System.out.println("машина " + this.owner + " повернула влево");
                break;
        }
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

    public void setNumber(int number) {
        this.number = number;
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
