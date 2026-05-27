package com.oop.match_3.field;

import com.oop.match_3.math.UnsignedInt;
import com.oop.match_3.statistics.RemoveTypeBonus;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;

class CrossComboTest {

    private CellADT cellAt(int col, int row, Element e) {
        return new Cell(new Coords(new UnsignedInt(col), new UnsignedInt(row)), e);
    }

    private CrossCombo centralCross() {
        return new CrossCombo(
                cellAt(0, 1, Element.A),
                cellAt(1, 1, Element.A),
                cellAt(2, 1, Element.A),
                cellAt(1, 0, Element.A),
                cellAt(1, 2, Element.A)
        );
    }

    @Test
    void given_crossCombo_when_hasBonus_then_true() {
        assertThat(centralCross().hasBonus(), is(true));
    }

    @Test
    void given_crossCombo_when_bonus_then_returnsRemoveTypeBonus() {
        assertThat(centralCross().bonus(), instanceOf(RemoveTypeBonus.class));
    }

    @Test
    void given_crossCombo_when_getBonusStatus_then_bonusOk() {
        CrossCombo combo = centralCross();
        combo.bonus();
        assertThat(combo.getBonusStatus(), is(Combo.BONUS_OK));
    }

    @Test
    void given_crossCombo_when_clear_then_allCellsBecomeNone() {
        CellADT h0 = cellAt(0, 1, Element.A);
        CellADT center = cellAt(1, 1, Element.A);
        CellADT h2 = cellAt(2, 1, Element.A);
        CellADT v0 = cellAt(1, 0, Element.A);
        CellADT v2 = cellAt(1, 2, Element.A);
        CrossCombo combo = new CrossCombo(h0, center, h2, v0, v2);
        combo.clear();
        CellADT empty = cellAt(5, 5, Element.NONE);
        assertThat(h0.hasSameElementAs(empty), is(true));
        assertThat(center.hasSameElementAs(empty), is(true));
        assertThat(h2.hasSameElementAs(empty), is(true));
        assertThat(v0.hasSameElementAs(empty), is(true));
        assertThat(v2.hasSameElementAs(empty), is(true));
    }
}
