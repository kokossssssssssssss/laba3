package things;




public class Fence extends Thing {
    public Fence(int x){
        super.setX(x);
    }

    public int build(){//возвращает количество досок, необходимых для строительства забора
        class Board{//локальный класс досок, из которых строим забор
           public int howManyBoards(){//сколько нужно досок
               return (int) ((Math.random() * (10)) + 1);
           }
        }
        Board board = new Board();
        return board.howManyBoards();
    }


}
