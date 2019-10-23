import java.util.Scanner;
import java.util.LinkedList;

public class Board{
    String[][]board;
    int[] moves;
    int index;
    
public Board(){
        board = new String[3][3];
        moves = new int[100];
        index = 0;
    }
public void updatedboardX(int x , int y){

        board[x][y] = "X";
       
    }
public void updatedboardO(int x , int y){
        board[x][y] = "O";
        
    }
public void printBoard(){
        int w = 0;
        int count =0;
        int w1 = 0;
        for(int i =0; i<3;i++){
            for(int j = 0;j<3;j++){
                if(board[i][j]!="X"&&board[i][j]!="O"){
                     board[i][j] = "-";
                }
                
            }
        }
        while(w!=3){
            System.out.print(board[w1][w]);
            if(w!=2){
                System.out.print("|");
            }
            if(w==2){
                w1++;
            }
            if(w==2){
                System.out.println();
            }
            w++;
            count++;
            if(w==3){
                w=0;
            }
            if(count == 9){
                break;
            }
        }
    }
public int[] Player1move(){
        int[] array = new int[2];
        boolean flag = false;
        Scanner obj1 = new Scanner(System.in);
        System.out.println("Enter the coordinates you want to place your move");
        int P1 = obj1.nextInt();
        int P = obj1.nextInt();
        array[0] = P1;
        array[1] = P;
    for(int i = 0;i<moves.length-1;i++){
        if(moves[i]==P1&&moves[i+1]==P){
            flag = true;
        }
    }

    if((moves[index]==P1&&moves[index+1]==P)==false){
        moves[index] = P1;
        index++;
        moves[index] = P;
        index++;
        return array;
    }else{
        System.out.println("That move is invalid");
        System.out.println("Please pick new coordinates");
        return Player1move();
        
    }
        
    }
public int[] Player2move(){
        int[] array = new int[2];
        boolean flag = false;
        Scanner obj2 = new Scanner(System.in);
        System.out.println("Enter the coordinates you want to place your move");
        int P2 = obj2.nextInt();
        int P = obj2.nextInt();
        array[0] = P2;
        array[1] = P;
    for(int i = 0;i<moves.length-1;i++){
        if(moves[i]==P2&&moves[i+1]==P){
            flag = true;
        }
    }

    if(flag==false){
        moves[index] = P2;
        index++;
        moves[index] = P;
        index++;
        return array;
    }else{
        System.out.println("That move is invalid");
        System.out.println("Please pick new coordinates");
        return Player1move();
        
    }
    

    }
public boolean checkwin(){
  
   
        for(int i =0;i<3;i++){
            for(int j=0;j<1;j++){
                if(board[i][j]=="X"&&board[i][j+1]=="X"&&board[i][j+2]=="X"){
                    return true;
                }
                if(board[i][j]=="O"&&board[i][j+1]=="O"&&board[i][j+2]=="O"){
                    return true;
                }
            }
        }
        boolean win = checkwinColumns();
        boolean win1 = checkwinDiagonal();
    
        if(win==true){
            return true;
        }else if(win1==true){
            return true;
        }
        else{
            return false;
        }
    
    }
public boolean checkwinColumns(){
            
        
        for(int j =0;j<3;j++){
            for(int i=0;i<1;i++){
                if(board[i][j]=="X"&&board[i+1][j]=="X"&&board[i+2][j]=="X"){
                    return true;
                }
                if(board[i][j]=="O"&&board[i+1][j]=="O"&&board[i+2][j]=="O"){
                    return true;
                }
            }
        }
    return false;
    }
public boolean checkwinDiagonal(){
        int i = 0;
        int j = 0;
        
        
            if(board[i][j]=="X"&&board[i+1][j+1]=="X"&&board[i+2][j+2]=="X"){

                return true;
            }
            if(board[i][j]=="O"&&board[i+1][j+1]=="O"&&board[i+2][j+2]=="O"){
        
                return true;
            }
            if(board[i][j+2]=="X"&&board[i+1][j+1]=="X"&&board[i+2][j]=="X"){
              
                return true;
            }
            if(board[i][j+2]=="O"&&board[i+1][j+1]=="O"&&board[i+2][j]=="O"){
     
                return true;
            }
        
        return false;
        
}
    public boolean checkDraw(){
        int count = 0;
        int i =0;
        int j =0;
        while(i<3){

        if(board[i][j]=="X"||board[i][j]=="O"){
                    count++;
            }
            j++;
            if(j==3){
                i++;
                j=0;
            }
        }
        if(count==9){
            return true;
        }else{
            return false;
        }
    }
    
}

