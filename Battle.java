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
        int[] statusArr = new int[5];
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to BATTLESHIP!");
        System.out.println("Player one, place your ships!");
        System.out.println("Play two, look away!");
        initialize(shipBoard);
        System.out.println(getShipBoard(shipBoard));

        //Inital
        int[] infoArr = new int[4];

        infoArr = getInfo(scan, "Place your Carrier(5).", 5);
        placeShip(infoArr, "C", shipBoard);

        System.out.println(getShipBoard(shipBoard));
        infoArr = getInfo(scan, "Place your Battleship(4).", 4);
        placeShip(infoArr, "B", shipBoard);

        System.out.println(getShipBoard(shipBoard));
        infoArr = getInfo(scan, "Place your Destroyer(3).", 3);
        placeShip(infoArr, "D", shipBoard);

        System.out.println(getShipBoard(shipBoard));
        infoArr = getInfo(scan, "Place your Submarine(3).", 3);
        placeShip(infoArr, "S", shipBoard);


        System.out.println(getShipBoard(shipBoard));
        infoArr = getInfo(scan, "Place your Patrol Boat(2).", 2);
        placeShip(infoArr, "P", shipBoard);

        //Battle

        initialize(battleBoard);
        System.out.println("Player 2, its up to you to find and destroy the 5 ships of player 1");

        boolean notWon = true;
        int count = 0;

        while(notWon){
            System.out.println(getShipBoard(battleBoard));
            System.out.print("Please enter the row and collum of your attack:");

            String uAttack = scan.nextLine();
            String[] uInputArr = uAttack.split("");
            int uAttackRow = (uInputArr[0].toLowerCase().charAt(0) - 'a');
            int uAttackCol = Integer.parseInt(uInputArr[1]) - 1;

            int[] uAttackArr = {uAttackRow, uAttackCol};

            hitShip(shipBoard, battleBoard, uAttackArr, statusArr);
            count++;

            int x = 0;
            if(statusArr[0] == 5){
                x++;
            }
            if(statusArr[1] == 4){
                x++;
            }
            if(statusArr[2] == 3){
                x++;
            }
            if(statusArr[3] == 3){
                x++;
            }
            if(statusArr[4] == 2){
                x++;
            }

            if(x==5){
                notWon = false;
            }
        }

        System.out.println("You did it!");
        System.out.println("Your score was: " + count);

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
        int dirBuff = 0;
        boolean fits = true;
        while(fits){
            parameters = true;

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
            
            while(parameters){
                System.out.println("Horizontaly(0) or Vertically(1)?");
                dirBuff = Integer.parseInt(scan.nextLine());
                if(dirBuff == 0 || dirBuff == 1){
                    parameters = false;
                }
            }
            if((uRow + len < 10 && dirBuff == 1)){
                fits = false;
            }else if((uCol + len < 10 && dirBuff == 0)){
                fits = false;
            }
        }
        int[] arr = {uRow, uCol, dirBuff, len}; 
        return arr;
    }
    
    public static void placeShip(int[] arr, String symbol, String[][] shipBoard){
        shipBoard[arr[0]][arr[1]] = symbol;
        if(arr[2] == 1){
            for(int i = 1; i < arr[3]; i++){
                shipBoard[arr[0]+i][arr[1]] = symbol;
            }
        }else{
            for(int i = 1; i < arr[3]; i++){
                shipBoard[arr[0]][arr[1]+i] = symbol;
            }
        }

    }

    public static void hitShip(String[][] shipBoard, String[][] battleBoard, int[] arr, int[] status){
        if(shipBoard[arr[0]][arr[1]].equals("-")){
            battleBoard[arr[0]][arr[1]] = "M";
            System.out.println("You did not hit a ship!");
        }else{
            battleBoard[arr[0]][arr[1]] = "X";
            System.out.println("Direct Hit!");
            if(shipBoard[arr[0]][arr[1]].equals("C")){
                status[0]++;
            }else if(shipBoard[arr[0]][arr[1]].equals("B")){
                status[1]++;
            }else if(shipBoard[arr[0]][arr[1]].equals("D")){
                status[2]++;
            }else if(shipBoard[arr[0]][arr[1]].equals("S")){
                status[3]++;
            }else{
                status[4]++;
            }

            if(status[0] == 5){
                System.out.println("The Crusier has sunk!");
            }
            if(status[1] == 4){
                System.out.println("The Battleship has sunk!");
            }
            if(status[2] == 3){
                System.out.println("The Destroyer has sunk!");
            }
            if(status[3] == 3){
                System.out.println("The Submarine has sunk!");
            }
            if(status[4] == 2){
                System.out.println("The Patrol Boat has sunk!");
            }
        }
    }

}

class Ships{
    private String name;
    private Boolean sunk;
    public Ships(){
        name = "john";
        sunk = false;
    }
    public Ships(String na, Boolean su){
        name = na;
        sunk = su;
    }
}
