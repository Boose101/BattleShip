package src.main.java.battleship;

public class Ship{
    private String name;
    private ShipCell[] cells; // Composition
    private int length;
    private int hitsLeft;

    public Ship(String name, int length){
        this.name = name;
        this.length = length;
        this.cells = new ShipCell[length];
        hitsLeft = length;
    }
    public String getName(){
        return name;
    }
    public boolean getSunk(){
        return hitsLeft == 0;
    }



}

class ShipCell{
    private String symbol;
    private boolean sunk;
    public ShipCell(String symbol){
        this.symbol = symbol;
        sunk = false;
    }

    public String getSymbol(){
        return symbol;
    }
    public boolean getSunk(){
        return sunk;
    }
    public void setSunk(boolean sSunk){
        sunk = sSunk;
    }
}

