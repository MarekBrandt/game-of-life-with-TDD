package org.example;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DeadCellTest {
    @Test
    public void shouldGetRevivedWhenOptimalNeighbourCount() {
        DeadCell cell = new DeadCell();
        cell.setNeighboursCount(3);
        Cell newCell = cell.updateState();

        assertEquals(AliveCell.class, newCell.getClass());
    }
}