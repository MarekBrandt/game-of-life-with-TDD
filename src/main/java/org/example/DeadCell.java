package org.example;

public class DeadCell extends Cell {

    public static final int neighboursCountToGetRevived = 3;

    public DeadCell(Position position) {
        super(position);
    }

    public DeadCell(Cell cell) {
        super(cell);
    }

    public boolean shouldGetRevived() {
        return neighboursCount == neighboursCountToGetRevived;
    }

    @Override
    Cell updateState() {
        if(this.shouldGetRevived()) {
            return new AliveCell(this);
        }
        return this;
    }
}
