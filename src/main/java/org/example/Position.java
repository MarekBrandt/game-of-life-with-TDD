package org.example;

import java.util.Objects;

public class Position {

    public final static Position FIRST = new Position(0,0);
    private final int x;
    private final int y;

    public Position(int x, int y) {
        if( x < 0 || y < 0) {
            throw new IllegalArgumentException("Neither x: "+x+" nor y: "+y+" can be negative");
        }
        this.x = x;
        this.y = y;
    }

    public boolean isInTheLastColumn(BoardSize boardSize) {
        return x == boardSize.getLastColumnIndex();
    }

    public boolean isInTheLastRow(BoardSize boardSize) {
        return y == boardSize.getLastRowIndex();
    }

    public boolean isInTheLastCell(BoardSize boardSize) {
        return isInTheLastColumn(boardSize) && isInTheLastRow(boardSize);
    }

    public boolean hasNext(BoardSize boardSize) {
        return !this.nextPosition(boardSize).equals(this);
    }

    public Position nextPosition(BoardSize boardSize) {
        int newX = this.x;
        int newY = this.y;
        newX++;
        if(isInTheLastCell(boardSize)) {
            return new Position(this.x, this.y);
        }
        if (isInTheLastColumn(boardSize)) {
            newX = Position.FIRST.x;
            newY++;
        }
        return new Position(newX, newY);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x && y == position.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
