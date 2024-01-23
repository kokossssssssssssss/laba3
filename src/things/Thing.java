package things;

public abstract class Thing {
    protected String title;
    private int x;
    private int y;

    public String getTitle() {
        return title;
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
}
