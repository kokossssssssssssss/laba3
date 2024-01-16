import Enums.Gender;
import People.Luis;
import People.Police;
import Phenomenons.Wind;
import Things.Car;
import Things.Shoes;
import Things.Tree;

public class Main {
    public static void main(String[] args) {
        Luis luis = new Luis();
        Shoes shoes = new Shoes();
        luis.setClothes(shoes);
        for (int i =0 ; i < luis.getClothes().size(); i++) System.out.println(luis.getClothes().get(i).getTitle());//что надето на Льюисе
        Tree tree = new Tree(5, 0);
        Tree.Twig twig1 = new Tree.Twig(2, 10);
        Tree.Twig twig2 = new Tree.Twig(3, 15);
        tree.setTwigs(twig1);
        tree.setTwigs(twig2);//сделали дерево с двумя ветками
        luis.see(tree.getTrunk());//увидел ствол дерева
        System.out.println(luis.getThoughts());//о чем думает
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
        System.out.println(luis.toString());//удивился, когда увидел тень
        System.out.println(luis.getHand()[0].getStatus());
        System.out.println(luis.getHand()[1].getStatus());//состояние рук до ветра
        Wind wind = new Wind();
        wind.blow(luis);//ветер дует на Льюиса
        System.out.println(luis.getHand()[0].getStatus());
        System.out.println(luis.getHand()[1].getStatus());//состояние рук после ветра
        luis.feelTired();
        Police police = new Police();
        Car car = new Car(police);//машина полицейских
        luis.see(car);
        System.out.println(luis.getThoughts());//о чем думает Льюис, когда увидел полицию
        System.out.println(luis.toString());//состояние после того, как увидел полицию









    }
}
