package org.example;

import java.util.Objects;

abstract public class Cell {


    protected final Position position;
    protected int neighboursCount;

    public Cell(Position position) {
        this.position = position;
    }

    public Cell(Cell cell) {
        this.position = cell.getPosition();
        this.neighboursCount = cell.getNeighboursCount();
    }

    abstract Cell updateState();
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cell cell = (Cell) o;
        return neighboursCount == cell.neighboursCount && position.equals(cell.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, neighboursCount);
    }

    public void setNeighboursCount(int neighboursCount) {
        this.neighboursCount = neighboursCount;
    }

    public Position getPosition() {
        return position;
    }

    public int getNeighboursCount() {
        return neighboursCount;
    }
}
