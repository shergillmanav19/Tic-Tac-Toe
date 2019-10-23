import java.util.Scanner;
public class MYGAME{
 
    public static void main(String[] args){
        
        System.out.println("Let the games begin");
        System.out.println("-----X will go first------");
        
        Board Gameboard = new Board();
        int[] array = new int[2];
        boolean Win = false;
        int count = 0;
        while(Gameboard.checkwin()==false){
            array = Gameboard.Player1move();
            Gameboard.updatedboardX(array[0],array[1]);
            Gameboard.printBoard();
            if(Gameboard.checkwin()==true){
                System.out.println("Game Over, we have winner!!!");
                break;
            }
            if(Gameboard.checkDraw()==true){
                System.out.println("Game Over, it's a draw!");
                break;
            }
            array = Gameboard.Player2move();
            Gameboard.updatedboardO(array[0],array[1]);
            Gameboard.printBoard();
            
            if(Gameboard.checkwin()==true){
                System.out.println("Game Over, we have winner!!!");
                break;
            }
            if(Gameboard.checkDraw()==true){
                System.out.println("Game Over, it's a draw!");
                break;
            }
        }
    }
}
