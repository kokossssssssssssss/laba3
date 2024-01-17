package People;

import Enums.Gender;
import Exceptions.HeightOfTreeException;
import Exceptions.OutOfTwigException;
import Exceptions.ShoesException;
import Interfaces.CrowlingOnATree;
import Phenomenons.Shadow;
import Things.*;

public class Luis extends Human implements CrowlingOnATree {


    {
        super.setName("Льюис");
        super.setGender(Gender.MALE);
    }


    @Override
    public void see(Thing thing) {
        if (thing.equals(new Car(new Police()))) {
            think("О Господи, машина едет!");
            feelScared();
            System.out.println(getName() + " увидел полицейскую машину");//если Льюис видит полицейскую машину, то пугается
        }
        if(thing.getClass().equals(Fence.class)){
            think("О нет, острый забор!");
            feelScared();
        }else {
            think(thing.getTitle());
        }
    }

    public void see(Shadow shadow) {//переопределяем метод, если Льюис видит тень; если это тень Льюиса, то он удивляется
        if (shadow.getWhoose().equals("Льюис")) {
            think("Это моя тень");
            feelSurprised();
            System.out.println(getName() + " увидел собственную тень");
        } else {
            think("тень");
        }
    }

    public Shadow makeShadow() {
        return new Shadow("Льюис");
    }


    @Override
    public void climbOnTree(Tree tree, int height) {
        try {
            checkHeightOfTree(tree, height);
        } catch (HeightOfTreeException e) {//проверяем, чтобы высота не превышала высоту дерева
            System.err.println("проверьте высоту");
            System.exit(0);
        }

        if (getHand()[0].getThing() == null) take(tree.getTrunk(), getHand()[0]);
        if (getHand()[1].getThing() == null) take(tree.getTrunk(), getHand()[1]);
         else if (!getHand()[0].getThing().getTitle().equals(tree.getTrunk().getTitle()) && getHand()[1].getThing().getTitle().equals( tree.getTrunk().getTitle())) {
            take(tree.getTrunk(), getHand()[1]);
        } else if (!getHand()[0].getThing().getTitle().equals(tree.getTrunk().getTitle()) && getHand()[1].getThing().getTitle().equals(tree.getTitle())) {
            take(tree.getTrunk(), getHand()[0]);
        } else {
            take(tree.getTrunk(), getHand()[0]);
            take(tree.getTrunk(), getHand()[1]);
        }
        //если в руках нет ствола дерева, то Льюис берет его
        try {
            checkShoes();
        } catch (ShoesException e) {
            System.err.println("наденьте туфли, без туфлей " + getName() + " не может забраться на дерево");
            System.exit(0);
        }//проверяем, чтобы на Льюисе были туфли
        setY(height);//забирается на указанную высоту
    }

    public void checkHeightOfTree(Tree tree, int height) throws HeightOfTreeException {//проверка, чтобы введенная высота не превышала высоту дерева
        if (height <= 0 || height > tree.getHeight()) throw new HeightOfTreeException();
    }

    public void checkShoes() throws ShoesException {//проверка, чтобы на Льюисе были туфли
        boolean ifContainsShoes = false;
        for (int i = 0; i < getClothes().size(); i++) {
            if (getClothes().get(i).getClass().equals(Shoes.class)) {
                ifContainsShoes = true;
                break;
            }
        }
        if (!ifContainsShoes) throw new ShoesException();
    }
    @Override
    public void crowlOnTwig(Tree.Twig twig, int distance) {//льюис может передвигаться в горизонтальном направлении по ветке
        try {
            checkLengthOfTwig(twig, distance);
        } catch (
                OutOfTwigException e) {//проверяем, можно ли проползти на такое расстояние, сравнивая это расстояние с длиной ветки
            System.err.println("проверьте длину ветки, она слишком короткая");
            System.exit(0);
        }

        if (getHand()[0].getThing() == null){
            take(twig, getHand()[0]);
        }if (getHand()[1].getThing() == null){
            take(twig, getHand()[1]);
        }


         else if (getHand()[0].getThing().getTitle().equals(twig.getTitle()) && !getHand()[1].getThing().getTitle().equals(twig.getTitle()) || getHand()[0].getThing().getTitle().equals(twig.getTitle()) && getHand()[1].getThing().getTitle() == null) {
            take(twig, getHand()[1]);
        } else if (!getHand()[0].getThing().getTitle().equals(twig.getTitle()) && getHand()[1].getThing().getTitle().equals(twig.getTitle()) || getHand()[0].getThing().getTitle() == null && getHand()[1].getThing().getTitle().equals(twig.getTitle())) {
            take(twig, getHand()[0]);
        } else {
            take(twig, getHand()[0]);
            take(twig, getHand()[1]);
        }//если в руках нет ветки, то Льюис берет ветку
        setX(getX() + distance);//ползет по ветке
        think("Это было в 12 лет...");//вспоминает детство
    }

    public void checkLengthOfTwig(Tree.Twig twig, int distance) throws OutOfTwigException {//проверяем, чтобы введенная дисстанция не превышала размера ветки (иначе Льюис выйдет за пределы ветки, т.е. упадет)
        if (distance > twig.getLength()) throw new OutOfTwigException();
    }

}

