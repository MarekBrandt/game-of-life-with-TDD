package org.example;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class BoardInitializerTest {
    @Test
    public void shouldInitializeBoardGivenSize() {
        //given
        BoardSize boardSize = new BoardSize(2,3);
        BoardInitializer boardInitializer = BoardInitializer.getInstance();

        //when
        Map<Position, Cell> initialziedCells = boardInitializer.initialize(boardSize);

        //then
        assertEquals(6, initialziedCells.size());
    }

    @Test
    public void initializedBoardShouldBeMadeOfDeadCells() {
        //given
        BoardSize boardSize = new BoardSize(2,3);
        BoardInitializer boardInitializer = BoardInitializer.getInstance();

        //when
        Map<Position, Cell> initializedCells = boardInitializer.initialize(boardSize);

        //then
        initializedCells.forEach(
                (position, cell) -> assertEquals(DeadCell.class, cell.getClass())
        );
    }

}