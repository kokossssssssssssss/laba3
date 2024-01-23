package things;

import interfaces.Wearable;

public class Shoes extends Thing implements Wearable {
    {
        super.title = "теннисные туфли";
    }

    @Override
    public String getTitle() {
        return super.getTitle();
    }
}
