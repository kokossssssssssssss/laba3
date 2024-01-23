package phenomenons;

import enums.Status;
import people.*;

public class Wind {
    public Wind (int temperature){
        this.temperature = temperature;
    }
    private int temperature;

    public void blow(Human human){
        if(temperature < 20) {
            human.getHand()[0].setStatus(Status.COLD);
            human.getHand()[1].setStatus(Status.COLD);
            System.out.println("Ветер охладил руки " + human.getName());
        }
    }
}
