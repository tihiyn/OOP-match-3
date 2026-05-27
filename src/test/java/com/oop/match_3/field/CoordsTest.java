package com.oop.match_3.field;

import com.oop.match_3.math.UnsignedInt;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class CoordsTest {

    private Coords at(int col, int row) {
        return new Coords(new UnsignedInt(col), new UnsignedInt(row));
    }

    @Test
    void given_sameRowAndCol_when_eq_then_true() {
        assertThat(at(1, 2).eq(at(1, 2)), is(true));
    }

    @Test
    void given_differentRow_when_eq_then_false() {
        assertThat(at(1, 2).eq(at(1, 3)), is(false));
    }

    @Test
    void given_differentCol_when_eq_then_false() {
        assertThat(at(1, 2).eq(at(2, 2)), is(false));
    }

    @Test
    void given_sameInstance_when_eq_then_true() {
        Coords a = at(3, 4);
        assertThat(a.eq(a), is(true));
    }

    @Test
    void given_horizontalRightNeighbour_when_isNeighbour_then_true() {
        assertThat(at(1, 2).isNeighbour(at(2, 2)), is(true));
    }

    @Test
    void given_horizontalLeftNeighbour_when_isNeighbour_then_true() {
        assertThat(at(1, 2).isNeighbour(at(0, 2)), is(true));
    }

    @Test
    void given_verticalDownNeighbour_when_isNeighbour_then_true() {
        assertThat(at(1, 2).isNeighbour(at(1, 3)), is(true));
    }

    @Test
    void given_verticalUpNeighbour_when_isNeighbour_then_true() {
        assertThat(at(1, 2).isNeighbour(at(1, 1)), is(true));
    }

    @Test
    void given_diagonal_when_isNeighbour_then_false() {
        assertThat(at(1, 2).isNeighbour(at(2, 3)), is(false));
    }

    @Test
    void given_sameCoords_when_isNeighbour_then_false() {
        assertThat(at(1, 2).isNeighbour(at(1, 2)), is(false));
    }

    @Test
    void given_farCoords_when_isNeighbour_then_false() {
        assertThat(at(0, 0).isNeighbour(at(5, 7)), is(false));
    }
}
