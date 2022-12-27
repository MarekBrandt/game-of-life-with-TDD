package org.example;

import java.util.Map;

public class Board {
    private BoardSize boardSize;
    private Map<Position, Cell> cells;

    public Board(BoardSize boardSize) {
        this.boardSize = boardSize;
        BoardInitializer boardInitializer = BoardInitializer.getInstance();
        cells = boardInitializer.initialize(boardSize);
    }

    public void show() {
        Position position = Position.FIRST;
        while (position.hasNext(boardSize)){
            showCellOnPosition(position);
            position = position.nextPosition(boardSize);
        }
        showCellOnPosition(position);
    }

    private void showCellOnPosition(Position position) {
        Cell cell = cells.get(position);
        cell.show();
        if (position.isInTheLastColumn(boardSize)) {
            System.out.println();
        }
    }


}
