package org.example;

import java.util.List;

public class AliveCell extends Cell{

    public static final List<Integer> neighboursCountToStayAlive = List.of(2,3);

    public AliveCell() { super();}

    private AliveCell(DeadCell cell) {
        super(cell);
    }

    private DeadCell kill() {
        DeadCell deadCell = new DeadCell();
        deadCell.setNeighboursCount(getNeighboursCount());
        return deadCell;
    }

    public boolean isUnderpopulated() {
        return neighboursCount < neighboursCountToStayAlive.get(0); //todo introduce range
    }

    public boolean isOverpopulated() {
        return neighboursCount > neighboursCountToStayAlive.get(1); //todo introduce range
    }

    @Override
    public Cell updateState(){
        if(shouldDie()) {
            return this.kill();
        }
        return this;
    }

    @Override
    public void show() {
        System.out.print("*");
    }

    private boolean shouldDie() {
        return this.isUnderpopulated() || this.isOverpopulated();
    }
}
