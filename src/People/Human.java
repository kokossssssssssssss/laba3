package People;

import Enums.Gender;
import Enums.Side;
import Enums.Status;
import Exceptions.CoordsException;
import Exceptions.DontSeeException;
import Exceptions.HandIsBusyException;
import Interfaces.Wearable;
import Things.Thing;
import Things.Tree;

import java.util.ArrayList;

public abstract class Human {
    private String name;
    private Gender gender;
    private final ArrayList<String> feelings = new ArrayList<>();
    private final ArrayList<Wearable> clothes = new ArrayList<>();
    private final Hand[] hands;
    private final Brain brain;
    private int x;
    private int y;

    {
        Hand handL = new Hand(Side.LEFT);
        Hand handR = new Hand(Side.RIGHT);
        hands = new Hand[]{handL, handR};//массив из 2 рук
        brain = new Brain();//мозг
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }



    public void feelTired() {
        if (!feelings.contains("уставший")) {
            feelings.add("уставший");
        }
    }

    public void feelScared() {
        if (!feelings.contains("испуганный")) {
            feelings.add("испуганный");
        }
    }

    public void feelSurprised() {
        if (!feelings.contains("удивленный")) {
            feelings.add("удивленный");
        }
    }
    public Brain getBrain() {
        return this.brain;
    }

    public Hand[] getHand() {
        return this.hands;
    }

    public Thing whatInHandL() {
        return getHand()[0].getThing();
    }

    public Thing whatInHandR() {
        return getHand()[1].getThing();
    }

    public void setClothes(Wearable clothes) {
        this.clothes.add(clothes);
    }

    public ArrayList<Wearable> getClothes() {
        return this.clothes;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getX() {
        return x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getY() {
        return y;
    }

    public void think(String thoughts) {
        brain.setThoughts(thoughts);
    }

    public ArrayList<String> getThoughts() {
        return brain.getThoughts();
    }

    public void take(Thing thing, Hand hand) {//взять вещь в руку
        try {
            checkIfSee(thing);//надо ее сначала увидеть
            checkCoordX(thing);//чтобы совпадала координата X
            checkCoordY(thing);//и координата Y
            hand.take(thing);//потом можно взять (при условии, что рука свободна)
        } catch (DontSeeException e) {
            System.err.println(name + " не видит " + thing.getTitle());
            System.exit(0);
        } catch (CoordsException e) {
            System.err.println(thing.getTitle() + " находится в другом месте");
            System.exit(0);
        }
    }

    public void take(Tree.Trunk trunk, Hand hand) {
        try {
            checkIfSee(trunk);//надо ее сначала увидеть
            checkCoordX(trunk);//чтобы совпадала координата X
            hand.take(trunk);//потом можно взять (при условии, что рука свободна)
        } catch (DontSeeException e) {
            System.err.println(name + " не видит " + trunk.getTitle());
            System.exit(0);
        } catch (CoordsException e) {
            System.err.println(trunk.getTitle() + " находится в другом месте");
            System.exit(0);
        }
    }// переопределяем метод для взятия ствола дерева; чтобы его взять, нужно проверить только X

    public void checkIfSee(Thing thing) throws DontSeeException {//проверить, что человек увидел вещь перед тем, как ее взять
        if (!getBrain().getThoughts().contains(thing.getTitle())) {
           throw new DontSeeException();
        }
    }

    public void checkCoordX(Thing thing) throws CoordsException {//проверить, чтобы координаты x человека и вещи совпадали, перед тем как взять вещь
        if (x != thing.getX()) {
            throw new CoordsException();
        }
    }

    public void checkCoordY(Thing thing) throws CoordsException {//проверить, чтобы координаты y человека и вещи совпадали, перед тем как взять вещь
        if (y != thing.getY()) {
            throw new CoordsException();
        }
    }

    public void release(Thing thing, Hand hand) {
        hand.release(thing);
        if ((thing.getClass().equals(Tree.Twig.class) || thing.getClass().equals(Tree.Trunk.class)) && y > 0) {
            int z = 0;
            for (int i = 0; i < 2; i++) {
                if (getHand()[i].getThing() == null) {
                    z++;
                }
            }
            if (z == 2) {
                this.y = 0;

            }
        }//проверка, что когда человек висит на дереве он должен держаться хотя бы одной рукой за ствол или за ветку, иначе упадет
    }



    public void see(Thing thing) {
        System.out.println(name + " увидел " + thing.getTitle());
        brain.setThoughts(thing.getTitle());//если человек что-то видит, это добавляется к нему в мозг в мысли
    }

    @Override
    public String toString() {
        return "Человек{" +
                "Имя: '" + name +
                "', Пол: '" + this.gender +
                "', Состояние: '" + feelings +
                "', Местоположение: x = '" + getX() + "', y = '" + getY() + "'}";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Human o = (Human) obj;
        return this.name.equals(o.name) && this.gender.equals(o.gender);
    }

    public static class Hand {
        public Hand(Side side) {
            this.side = side;
        }

        private final Side side;
        private Thing thing;
        private Status status = Status.WARM;

        public Thing getThing() {
            return this.thing;
        }


        public void setStatus(Status status) {
            this.status = status;
        }

        public Status getStatus() {
            return this.status;
        }

        public void take(Thing thing) {
            try {
                checkHandIsLeer();
                this.thing = thing;
            } catch (HandIsBusyException e) {
                System.err.println("в " + side + " руке " + this.thing.getTitle() + "; освободите руку");
                System.exit(0);
            }
        }//если рука пустая, то можно взять объект

        public void checkHandIsLeer() throws HandIsBusyException {
            if (thing != null) throw new HandIsBusyException();
        }//проверяет, пустая ли рука

        public void checkHandIsBusy(Thing thing) throws HandIsBusyException {
            if (!this.thing.getTitle().equals(thing.getTitle())) throw new HandIsBusyException();
        }//проверяет, есть ли в руке вещь

        public void release(Thing thing) {
            try {
                checkHandIsBusy(thing);
                this.thing = null;
            } catch (HandIsBusyException e) {
                System.err.println("в " + side + " руке нет " + thing.getTitle());
                System.exit(0);
            }
        }//отпустить объект, если он есть в руке
    }

    public static class Brain {
        private final ArrayList<String> thoughts = new ArrayList<>();// массив мыслей человека

        public void setThoughts(String thought) {
            if (!this.thoughts.contains(thought)) {
                this.thoughts.add(thought);
            }

        }//если еще нет этой мысли, то она добавляется в массив мыслей

        public ArrayList<String> getThoughts() {
            return this.thoughts;
        }
    }
}
