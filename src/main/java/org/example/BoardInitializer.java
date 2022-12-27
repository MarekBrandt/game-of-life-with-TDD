package org.example;

import java.util.ArrayList;
import java.util.List;

public class BoardInitializer {

    private static BoardInitializer boardInitializer;

    private BoardInitializer() {}

    public static BoardInitializer getInstance() {
        if (boardInitializer == null) {
            boardInitializer = new BoardInitializer();
        }
        return boardInitializer;
    }
    public List<Cell> initialize(BoardSize boardSize) {

        List<Cell> cells = new ArrayList<>();

        for(int h = 0; h < boardSize.getHeight(); h++) {
            for(int w = 0; w < boardSize.getWidth(); w++) {
                Position position = new Position(w, h);
                cells.add(new DeadCell());
            }
        }
        return cells;
    }
}
