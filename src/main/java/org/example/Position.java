package org.example;

public class Position {
    private final int x;
    private final int y;

    public Position(int x, int y) {
        if( x < 0 || y < 0) {
            throw new IllegalArgumentException("Neither x: "+x+" nor y: "+y+" can be negative");
        }
        this.x = x;
        this.y = y;
    }

    public boolean isAtTheEndOfTheRow(BoardSize boardSize) {
        return x == boardSize.getWidth() - 1;
    }
}
