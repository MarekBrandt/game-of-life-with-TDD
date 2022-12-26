package org.example;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
    public void shouldReturnTrueIfEndOfTheRow() {
        //given
        BoardSize boardSize = new BoardSize(2, 2);
        Position position = new Position(1, 1);

        //when
        boolean endOfTheRow = position.isAtTheEndOfTheRow(boardSize);

        //then
        assertTrue(endOfTheRow);
    }

    @Test
    public void shouldReturnFalseIfNotEndOfTheRow() {
        //given
        BoardSize boardSize = new BoardSize(2, 2);
        Position position = new Position(0, 1);

        //when
        boolean endOfTheRow = position.isAtTheEndOfTheRow(boardSize);

        //then
        assertFalse(endOfTheRow);
    }


    private static Stream<Arguments> provideInvalidPositions() {
        return Stream.of(
                Arguments.of(-10, 0),
                Arguments.of(1, -700),
                Arguments.of(-100, -7210)
        );
    }

}