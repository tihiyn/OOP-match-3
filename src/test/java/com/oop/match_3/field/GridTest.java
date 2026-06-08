package com.oop.match_3.field;

import com.oop.match_3.math.UnsignedInt;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.emptyArray;
import static org.hamcrest.Matchers.is;

class GridTest {

    private Grid freshGrid() {
        return new Grid(ElementsFactory.instance());
    }

    private CoordsADT at(int col, int row) {
        return new Coords(new UnsignedInt(col), new UnsignedInt(row));
    }

    @Test
    void given_freshGrid_when_combos_then_empty() {
        assertThat(freshGrid().combos(), emptyArray());
    }

    @Test
    void given_freshGrid_when_isStable_then_true() {
        assertThat(freshGrid().isStable(), is(true));
    }

    @Test
    void given_freshGrid_when_hasMoves_then_true() {
        assertThat(freshGrid().hasMoves(), is(true));
    }

    @Test
    void given_validNeighbours_when_swap_then_statusIsSwapOk() {
        Grid grid = freshGrid();
        grid.swap(at(0, 0), at(1, 0));
        assertThat(grid.getSwapStatus(), is(GridADT.SWAP_OK));
    }

    @Test
    void given_outOfBoundsCoords_when_swap_then_statusIsSwapOutOfBounds() {
        Grid grid = freshGrid();
        grid.swap(at(0, 0), at(100, 100));
        assertThat(grid.getSwapStatus(), is(GridADT.SWAP_OUT_OF_BOUNDS));
    }

    @Test
    void given_diagonalCoords_when_swap_then_statusIsSwapNotNeighbours() {
        Grid grid = freshGrid();
        grid.swap(at(0, 0), at(1, 1));
        assertThat(grid.getSwapStatus(), is(GridADT.SWAP_NOT_NEIGHBOURS));
    }

    @Test
    void given_farApartCoords_when_swap_then_statusIsSwapNotNeighbours() {
        Grid grid = freshGrid();
        grid.swap(at(0, 0), at(3, 0));
        assertThat(grid.getSwapStatus(), is(GridADT.SWAP_NOT_NEIGHBOURS));
    }

    @Test
    void given_gridWithNoCombos_when_resolve_then_remainsStable() {
        Grid grid = freshGrid();
        grid.resolve(new Combo[0]);
        assertThat(grid.isStable(), is(true));
    }

    @Test
    void given_gridWithoutEmptyCells_when_gravity_then_combosUnchanged() {
        Grid grid = freshGrid();
        grid.gravity();
        assertThat(grid.combos(), emptyArray());
    }

    @Test
    void given_gridWithoutEmptyCells_when_refill_then_isStableRemainsTrue() {
        Grid grid = freshGrid();
        grid.refill();
        assertThat(grid.isStable(), is(true));
    }
}
