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

        //Inital

        int[] infoArr = new int[4];

        infoArr = getInfo(scan, "Place your Carrier(5).", 5);

        


        System.out.println("Place your Battleship(4).");

        System.out.println("Place your Destroyer(3).");

        System.out.println("Place your Submarine(3).");

        System.out.println("Place your Patrol Boat(2).");


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


    //Row, Collum, Direction(0 H, 1 V), Length
    public static int[] getInfo(Scanner scan, String message, int len){
        boolean parameters = true;
        int uRow = 0;
        int uCol = 0;
        while(parameters){
            System.out.println(message);
            String uInput  = scan.nextLine();
            String[] uInputArr = uInput.split("");
            uRow = (uInputArr[0].toLowerCase().charAt(0) - 'a');
            uCol = Integer.parseInt(uInputArr[1]) - 1;
            if(uRow <= 10 && uCol <= 10){
                parameters = false;
            }
        }
        parameters = true;
        int dirBuff = 0;
        while(parameters){
            System.out.println("Horizontaly(0) or Vertically(1)?");
            dirBuff = Integer.parseInt(scan.nextLine());
            if(dirBuff != 0 || dirBuff != 1){
                parameters = false;
            }
        }
        int[] arr = {uRow, uCol, dirBuff, len}; 
        return arr;
    }
    
    public static void placeShip(int[] arr, char symbol, String[][] shipBoard){
        
    }
}
