package org.example;

public class DeadCell extends Cell {

    public static final int neighboursCountToGetRevived = 3;

    public DeadCell(Position position) {
        super(position);
    }

    public DeadCell(AliveCell cell) {
        super(cell);
    }

    @Override
    public DeadCell deepCopy() {
        DeadCell deadCell = new DeadCell(this.getPosition());
        deadCell.setNeighboursCount(this.getNeighboursCount());
        return deadCell;
    }

    public boolean shouldGetRevived() {
        return neighboursCount == neighboursCountToGetRevived;
    }

    @Override
    public Cell updateState() {
        if(this.shouldGetRevived()) {
            return new AliveCell(this);
        }
        return this;
    }

    @Override
    public void show() {
        System.out.print("-");
    }
}
