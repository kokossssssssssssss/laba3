package Things;

import Exceptions.HeightOfTreeException;

import java.util.ArrayList;

public class Tree extends Thing{
    public Tree(int height, int x) {
        this.height = height;
        super.setX(x);
    }
    {
       super.title = "дерево";
       Trunk trunk = new Trunk();
       trunk.setX(this.getX());
       setTrunk(trunk);
    }

    public Trunk getTrunk() {
        return trunk;
    }
    public void setTrunk(Trunk trunk) {
        this.trunk = trunk;
    }

    private int height;



    private Trunk trunk;
    private ArrayList<Twig> twigs = new ArrayList<>();//список, содержащий все ветки дерева

    public int getHeight() {
        return height;
    }

    public void setTwigs(Twig twig){
        try{
            checkHeightOfTwig(twig);
            twigs.add(twig);//добавляем ветку к дереву
            twig.setX(this.getX());
            twig.setY(twig.getHeight());//устанавливаем координаты
        }catch(HeightOfTreeException e){
            System.err.println("опустите ветку");
            System.exit(0);
        }
    }
    public void checkHeightOfTwig (Twig twig) throws HeightOfTreeException {//проверяем, чтобы высота ветки не превышала высоту дерева
        if  (twig.getHeight() > this.height) throw new HeightOfTreeException();
    }
    public ArrayList<Twig> getTwigs(){
        return this.twigs;
    }
    public int getNumOfTwigs(){//метод возвращает количество веток, исходя из количества элементов в списке twigs
        return twigs.size();
    }
    public class Trunk extends Thing{
        {
            super.title = "ствол";
            super.getX();
        }
    }
    public static class Twig extends Thing{


        public Twig(int height, int length){
            this.height = height;
            this.length = length;
        }
        {
            super.title = "ветка";
        }
        private int height;
        private int length;

        public int getLength() {
            return length;
        }

        public int getHeight(){
            return height;
        }

    }
}
