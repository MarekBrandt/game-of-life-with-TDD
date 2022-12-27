package org.example;

import java.util.Objects;

abstract public class Cell {

    protected int neighboursCount;

    public Cell() {}

    protected Cell(Cell cell) {
        this.neighboursCount = cell.getNeighboursCount();
    }

    abstract public Cell updateState();

    abstract public void show();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cell cell = (Cell) o;
        return neighboursCount == cell.neighboursCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(neighboursCount);
    }

    public void setNeighboursCount(int neighboursCount) {
        this.neighboursCount = neighboursCount;
    }

    public int getNeighboursCount() {
        return neighboursCount;
    }
}
