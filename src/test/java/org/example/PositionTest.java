package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.Assert.assertThrows;

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

    private static Stream<Arguments> provideInvalidPositions() {
        return Stream.of(
                Arguments.of(-10, 0),
                Arguments.of(1, -700),
                Arguments.of(-100, -7210)
        );
    }

}