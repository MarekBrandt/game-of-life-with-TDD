package org.example;

import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class AliveCellTest {
    @ParameterizedTest
    @MethodSource("provideValidNeighboursCountToStayAlive")
    public void shouldStayAliveWhenInOptimalNeighbourhood(int neighboursCount) {
        Cell cell = new AliveCell(new Position(3, 3));
        cell.setNeighboursCount(neighboursCount);
        Cell newCell = cell.updateState();

        assertEquals(cell, newCell);
    }

    @Test
    public void shouldDieWhenUnderpopulated() {
        Cell cell = new AliveCell(new Position(3,3));
        cell.setNeighboursCount(1);
        Cell newCell = cell.updateState();

        assertEquals(DeadCell.class, newCell.getClass());
    }

    @Test
    public void shouldDieWhenOverpopulated() {
        Cell cell = new AliveCell(new Position(3,3));
        cell.setNeighboursCount(5);
        Cell newCell = cell.updateState();

        assertEquals(DeadCell.class, newCell.getClass());
    }

    private static Stream<Integer> provideValidNeighboursCountToStayAlive() {
        return AliveCell.neighboursCountToStayAlive.stream();
    }
}