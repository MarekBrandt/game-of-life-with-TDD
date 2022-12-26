package org.example;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BoardInitializerTest {
    @Test
    public void shouldInitializeBoardGivenSize() {
        //given
        BoardSize boardSize = new BoardSize(2,3);
        BoardInitializer boardInitializer = BoardInitializer.getInstance();

        //when
        List<Cell> initialziedCells = boardInitializer.initialize(boardSize);

        //then
        assertEquals(6, initialziedCells.size());
    }

    @Test
    public void initializedBoardShouldBeMadeOfDeadCells() {
        //given
        BoardSize boardSize = new BoardSize(2,3);
        BoardInitializer boardInitializer = BoardInitializer.getInstance();

        //when
        List<Cell> initialziedCells = boardInitializer.initialize(boardSize);

        //then
        assertEquals(DeadCell.class, initialziedCells.get(0).getClass());
    }

}