package Things;


import People.Human;

public class Fence extends Thing {
    Fence(int x){
        super.setX(x);
        this.x=x;
    }
    static int x;
    public void kill(Human human){
        human = null;
    }
}
