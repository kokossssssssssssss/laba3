import enums.Gender;
import interfaces.GetReadyToCrowl;
import interfaces.Wearable;
import people.Luis;
import people.Police;
import phenomenons.Wind;
import things.Car;
import things.Fence;
import things.Shoes;
import things.Tree;

public class Main {
    public static void main(String[] args) {
        Luis luis = new Luis();
        Tree tree = new Tree(5, 0);
        Tree.Twig twig1 = new Tree.Twig(2, 10);
        Tree.Twig twig2 = new Tree.Twig(3, 15);
        tree.setTwigs(twig1);
        tree.setTwigs(twig2);//сделали дерево с двумя ветками
        Wind wind = new Wind(15);
        Police police = new Police(Gender.FEMALE);
        Car car = new Car(police);//машина полицейских
        Fence fence = new Fence(5);
        luis.see(tree.getTrunk());//увидел ствол дерева
        System.out.println(luis.getThoughts());//о чем думает
        GetReadyToCrowl getReady = new GetReadyToCrowl() {//анонимный клас, чтобы экипироваться перед тем как лезть на дерево
            @Override
            public void setNecessaryClothes() {
                Shoes shoes = new Shoes();
                luis.setClothes(shoes);
            }
        };
        getReady.setNecessaryClothes();//надевает необходимую одежду(туфли)
        for (int i =0 ; i < luis.getClothes().size(); i++) System.out.println(luis.getClothes().get(i).getTitle());//что надето на Льюисе
        luis.climbOnTree(tree,2);//забрался на дерево
        luis.see(twig1);//увидел ветку
        System.out.println(luis.whatInHandL().getTitle());
        System.out.println(luis.whatInHandR().getTitle());//что в руках
        luis.release(tree.getTrunk(), luis.getHand()[0]);//отпускает ствол дерева левой рукой
        luis.take(twig1, luis.getHand()[0]);//берет ветку левой рукой
        luis.release(tree.getTrunk(), luis.getHand()[1]);//отпускает ствол дерева правой рукой
        luis.crowlOnTwig(twig1, 5);//ползет по ветке на 5 метров
        System.out.println(luis.whatInHandL().getTitle());
        System.out.println(luis.whatInHandR().getTitle());//что в руках
        System.out.println(luis.getThoughts());//о чем думает
        luis.see(luis.makeShadow());//видит свою тень
        System.out.println(luis.getThoughts());//о чем думает
        System.out.println(luis);//удивился, когда увидел тень
        System.out.println(luis.getHand()[0].getStatus());
        System.out.println(luis.getHand()[1].getStatus());//состояние рук до ветра
        wind.blow(luis);//ветер дует на Льюиса
        System.out.println(luis.getHand()[0].getStatus());
        System.out.println(luis.getHand()[1].getStatus());//состояние рук после ветра
        luis.feelTired();
        luis.see(car);
        car.drive(20);
        System.out.println(luis.getThoughts());//о чем думает Льюис, когда увидел полицию
        System.out.println(luis);//состояние после того, как увидел полицию
        luis.see(fence);













    }
}
