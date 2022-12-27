package org.example;

public class DeadCell extends Cell {

    public static final int neighboursCountToGetRevived = 3;

    public DeadCell() {super();}

    public DeadCell(AliveCell cell) {
        super(cell);
    }

    private AliveCell revive() {
        AliveCell aliveCell = new AliveCell();
        aliveCell.setNeighboursCount(getNeighboursCount());
        return aliveCell;
    }

    public boolean shouldGetRevived() {
        return neighboursCount == neighboursCountToGetRevived;
    }

    @Override
    public Cell updateState() {
        if(this.shouldGetRevived()) {
            return this.revive();
        }
        return this;
    }

    @Override
    public void show() {
        System.out.print("-");
    }
}
