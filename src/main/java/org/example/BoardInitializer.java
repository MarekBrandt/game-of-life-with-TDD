package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BoardInitializer {

    private static BoardInitializer boardInitializer;

    private BoardInitializer() {}

    public static BoardInitializer getInstance() {
        if (boardInitializer == null) {
            boardInitializer = new BoardInitializer();
        }
        return boardInitializer;
    }
    public Map<Position, Cell> initialize(BoardSize boardSize) {

        Map<Position, Cell> cells = new HashMap<>();

        for(int h = 0; h < boardSize.getHeight(); h++) {
            for(int w = 0; w < boardSize.getWidth(); w++) {
                Position position = new Position(w, h);
                cells.put(position, new DeadCell());
            }
        }
        return cells;
    }
}
