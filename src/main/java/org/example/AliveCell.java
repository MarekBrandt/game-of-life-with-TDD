package org.example;

import java.util.List;

public class AliveCell extends Cell{

    public static final List<Integer> neighboursCountToStayAlive = List.of(2,3);

    public AliveCell(Position position) {
        super(position);
    }

    public AliveCell(DeadCell cell) {
        super(cell);
    }

    @Override
    public AliveCell deepCopy() {
        AliveCell aliveCell = new AliveCell(this.getPosition());
        aliveCell.setNeighboursCount(this.getNeighboursCount());
        return aliveCell;
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
            return new DeadCell(this);
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
