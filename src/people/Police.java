package people;


import enums.Gender;
import things.Handcuffs;

public class Police extends Human {
    private Gender gender;
    public Police(){}
    public Police(Gender gender){
        this.gender = gender;
    }
    public void arest (Human human){
        Handcuffs handcuffs = new Handcuffs();
        human.take(handcuffs, human.getHand()[0]);
        human.take(handcuffs, human.getHand()[1]);//надели наручники
        human.think("о нет .... меня арестовали");
        human.feelScared();//человек пугается, когда его арестовывают

    }

}
