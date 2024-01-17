package Phenomenons;

import Enums.Status;
import People.*;

public class Wind {

    public void blow(Human human){
        human.getHand()[0].setStatus(Status.COLD);
        human.getHand()[1].setStatus(Status.COLD);
        System.out.println("Ветер охладил руки " + human.getName());
    }

}
