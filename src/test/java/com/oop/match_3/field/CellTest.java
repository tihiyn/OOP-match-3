package com.oop.match_3.field;

import com.oop.match_3.math.UnsignedInt;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class CellTest {

    private CoordsADT at(int col, int row) {
        return new Coords(new UnsignedInt(col), new UnsignedInt(row));
    }

    @Test
    void given_sameElement_when_hasSameElementAs_then_true() {
        Cell a = new Cell(at(0, 0), Element.A);
        Cell b = new Cell(at(1, 1), Element.A);
        assertThat(a.hasSameElementAs(b), is(true));
    }

    @Test
    void given_differentElement_when_hasSameElementAs_then_false() {
        Cell a = new Cell(at(0, 0), Element.A);
        Cell b = new Cell(at(1, 1), Element.B);
        assertThat(a.hasSameElementAs(b), is(false));
    }

    @Test
    void given_oneIsNone_when_hasSameElementAs_then_false() {
        Cell a = new Cell(at(0, 0), Element.A);
        Cell empty = new Cell(at(1, 1), Element.NONE);
        assertThat(a.hasSameElementAs(empty), is(false));
    }

    @Test
    void given_ownCoords_when_isAt_then_true() {
        Cell cell = new Cell(at(3, 4), Element.A);
        assertThat(cell.isAt(at(3, 4)), is(true));
    }

    @Test
    void given_otherCoords_when_isAt_then_false() {
        Cell cell = new Cell(at(3, 4), Element.A);
        assertThat(cell.isAt(at(4, 3)), is(false));
    }

    @Test
    void given_twoCells_when_swap_then_elementsExchanged() {
        Cell a = new Cell(at(0, 0), Element.A);
        Cell b = new Cell(at(1, 1), Element.B);
        a.swap(b);
        Cell wasB = new Cell(at(0, 0), Element.B);
        Cell wasA = new Cell(at(1, 1), Element.A);
        assertThat(a.hasSameElementAs(wasB), is(true));
        assertThat(b.hasSameElementAs(wasA), is(true));
    }

    @Test
    void given_cell_when_assignElement_then_valueReplaced() {
        Cell cell = new Cell(at(0, 0), Element.A);
        cell.assignElement(Element.NONE);
        Cell empty = new Cell(at(1, 1), Element.NONE);
        assertThat(cell.hasSameElementAs(empty), is(true));
    }

    @Test
    void given_nonEmptyCell_when_print_then_statusIsPrintOk() {
        Cell cell = new Cell(at(0, 0), Element.A);
        cell.print();
        assertThat(cell.getPrintStatus(), is(CellADT.PRINT_OK));
    }

    @Test
    void given_emptyCell_when_print_then_statusIsPrintEmpty() {
        Cell cell = new Cell(at(0, 0), Element.NONE);
        cell.print();
        assertThat(cell.getPrintStatus(), is(CellADT.PRINT_EMPTY));
    }
}
