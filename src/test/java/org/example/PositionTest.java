package org.example;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

public class PositionTest {
    @ParameterizedTest
    @MethodSource("provideValidPositions")
    public void shouldCreatePositionWhenValidPositions(int validX, int validY) {
        Position validPosition = new Position(validX, validY);
        Assertions.assertNotNull(validPosition);
    }

    @ParameterizedTest
    @MethodSource("provideInvalidPositions")
    public void shouldNotCreatePositionWhenInvalidPositions(int invalidX, int invalidY) {
        assertThrows(IllegalArgumentException.class, () -> new Position(invalidX, invalidY));
    }

    private static Stream<Arguments> provideValidPositions() {
        return Stream.of(
                Arguments.of(0, 0),
                Arguments.of(1, 7),
                Arguments.of(100, 7210)
        );
    }

    @Test
    public void shouldReturnTrueIfInLastColumn() {
        //given
        BoardSize boardSize = new BoardSize(2, 2);
        Position position = new Position(1, 1);

        //when
        boolean inTheLastColumn = position.isInTheLastColumn(boardSize);

        //then
        assertTrue(inTheLastColumn);
    }

    @Test
    public void shouldReturnFalseIfNotInLastColumn() {
        //given
        BoardSize boardSize = new BoardSize(2, 2);
        Position position = new Position(0, 1);

        //when
        boolean inTheLastColumn = position.isInTheLastColumn(boardSize);

        //then
        assertFalse(inTheLastColumn);
    }

    @Test
    public void shouldReturnTrueIfInLastRow() {
        //given
        BoardSize boardSize = new BoardSize(2, 2);
        Position position = new Position(1, 1);

        //when
        boolean theLastRow = position.isInTheLastRow(boardSize);

        //then
        assertTrue(theLastRow);
    }

    @Test
    public void shouldReturnFalseIfNotInLastRow() {
        //given
        BoardSize boardSize = new BoardSize(2, 2);
        Position position = new Position(0, 0);

        //when
        boolean inTheLastRow = position.isInTheLastRow(boardSize);

        //then
        assertFalse(inTheLastRow);
    }

    //next pos test cases: normal, last column, last cell
    @ParameterizedTest
    @MethodSource("nextPositionTestCases")
    public void shouldReturnValidNextPosition(Position current, Position expected, BoardSize boardSize) {
        //when
        Position nextPosition = current.nextPosition(boardSize);

        //then
        assertEquals(expected, nextPosition);
    }


    private static Stream<Arguments> nextPositionTestCases() {
        BoardSize boardSize = new BoardSize(3, 3);
        return Stream.of(
                Arguments.of(new Position(1,1), new Position(2,1), boardSize),
                Arguments.of(new Position(2,1), new Position(1,2), boardSize),
                Arguments.of(new Position(2,2), new Position(2,2), boardSize)
        );
    }

    private static Stream<Arguments> provideInvalidPositions() {
        return Stream.of(
                Arguments.of(-10, 0),
                Arguments.of(1, -700),
                Arguments.of(-100, -7210)
        );
    }

}