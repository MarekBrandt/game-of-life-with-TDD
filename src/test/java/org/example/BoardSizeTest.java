package org.example;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BoardSizeTest {

    @Test
    public void shouldNotInstantiateIfWidthOrHeightNegative() {
        assertThrows(IllegalArgumentException.class, () -> new BoardSize(-1, -1));
        assertThrows(IllegalArgumentException.class, () -> new BoardSize(-1, 1));
        assertThrows(IllegalArgumentException.class, () -> new BoardSize(1, -1));
    }

    @Test
    public void shouldInstantiateIfBothParametersPositive() {
        assertDoesNotThrow(() -> new BoardSize(1,1));
    }

    @Test
    public void shouldCalculateNumberOfTiles() {
        //given
        BoardSize boardSize = new BoardSize(2, 5);

        //when
        int numberOfTiles = boardSize.getNumberOfTiles();

        //then
        assertEquals(10, numberOfTiles);
    }

    @Test
    public void shouldCalculateLastRowIndex() {
        //given
        BoardSize boardSize = new BoardSize(2, 3);

        //when
        int lastRowIndex = boardSize.getLastRowIndex();

        //then
        assertEquals(2, lastRowIndex);
    }

    @Test
    public void shouldCalculateLastColumnIndex() {
        //given
        BoardSize boardSize = new BoardSize(2, 3);

        //when
        int lastColumnIndex = boardSize.getLastColumnIndex();

        //then
        assertEquals(1, lastColumnIndex);
    }
}