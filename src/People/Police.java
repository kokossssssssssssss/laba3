package People;


public class Police extends Human {
    public void arest (Human human){
        human.think("о нет .... меня арестовали");
        human.feelScared();//человек пугается, когда его арестовывают

    }

}
