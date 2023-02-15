import Wordle.main;

import java.util.Scanner;
public class Battle {
  

    public static void initialize(String[][] board) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                board[i][j] = "-";
            }
        }
    }

    public static void main(String[] args) {
        String [][] shipBoard = new String[10][10];
        String [][] battleBoard = new String[10][10];
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to BATTLESHIP!");
        System.out.println("Player one, place your ships!");
        System.out.println("Play two, look away!");
        initialize(shipBoard);
        System.out.println(getShipBoard(shipBoard));


    }

    public static String getShipBoard(String[][] shipBoard) {
        String buff = "  ";
        //Top loop to get collum 
        for(int x = 1; x <= 10; x++) {
            buff += x + " ";
        }
        buff += '\n';
        char c = 'A';
        
        for(String [] row : shipBoard) {
            buff += c + " ";
            for(String item : row){
                buff += item + " ";
            }
            buff += "\n";
            c++;
        }


        return buff;
    }
    
}
