package src.main.java.battleship;
import java.util.Arrays;
import java.util.Scanner;

public class Board{
    public static final char hit = '☒';
    public static final char miss = '☸';
    public static final char ship = '☐';
    public static final char water = '~';
    ////
    private final int length; 
    private  char[][] board;

    public Board(int length){
        this.length = length;
        board = initializeBoard(length);
    }

    private char[][] initializeBoard(int length){
        char[][] matrix = new char[length][length];
        for(char[] row : matrix){
            Arrays.fill(row, water);
        }
        return matrix;
    }

    public int getLength(){
        return length;
    }

    public char[][] getBoard(){
        return board;
    }

    public char at(Position pos){
        return board[pos.getRow()][pos.getColumn()];
    }

    public void set(char stat, Position pos){
        board[pos.getRow()][pos.getColumn()] = stat;
    }
    
}
