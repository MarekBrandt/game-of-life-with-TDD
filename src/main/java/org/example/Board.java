package org.example;

import java.util.List;

public class Board {
    private BoardSize boardSize;
    private List<Cell> cells;

    public Board(BoardSize boardSize) {
        this.boardSize = boardSize;
        BoardInitializer boardInitializer = BoardInitializer.getInstance();
        cells = boardInitializer.initialize(boardSize);
    }

//    public Board(Board board) {
//        this.boardSize = board.boardSize;
//        this.cells = deepCopyCells(board.cells);
//    }
//
//    private List<Cell> deepCopyCells(List<Cell> cells) {
//        ArrayList<Cell> newCells = new ArrayList<>();
//        cells.stream().map(cell -> {
//            newCells.add()
//        })
//    }

    public void show() {
        for(Cell cell : cells) {
            cell.show();
            if (cell.isLastInRow(boardSize)){
                System.out.println();
            }
        }
    }
}
