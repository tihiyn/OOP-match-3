package com.oop.match_3.field;

import com.oop.match_3.math.UnsignedInt;
import com.oop.match_3.statistics.RemoveColumnBonus;
import com.oop.match_3.statistics.RemoveRowBonus;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;

class LinearComboTest {

    private CellADT cellAt(int col, int row, Element e) {
        return new Cell(new Coords(new UnsignedInt(col), new UnsignedInt(row)), e);
    }

    private LinearCombo horizontal(int length) {
        CellADT[] cells = new CellADT[length];
        for (int i = 0; i < length; i++) {
            cells[i] = cellAt(i, 0, Element.A);
        }
        return new LinearCombo(cells);
    }

    private LinearCombo vertical(int length) {
        CellADT[] cells = new CellADT[length];
        for (int i = 0; i < length; i++) {
            cells[i] = cellAt(0, i, Element.A);
        }
        return new LinearCombo(cells);
    }

    @Test
    void given_comboOfThree_when_hasBonus_then_false() {
        assertThat(horizontal(3).hasBonus(), is(false));
    }

    @Test
    void given_comboOfFour_when_hasBonus_then_true() {
        assertThat(horizontal(4).hasBonus(), is(true));
    }

    @Test
    void given_comboOfFive_when_hasBonus_then_true() {
        assertThat(horizontal(5).hasBonus(), is(true));
    }

    @Test
    void given_horizontalComboOfFour_when_bonus_then_returnsRemoveRowBonus() {
        assertThat(horizontal(4).bonus(), instanceOf(RemoveRowBonus.class));
    }

    @Test
    void given_verticalComboOfFour_when_bonus_then_returnsRemoveColumnBonus() {
        assertThat(vertical(4).bonus(), instanceOf(RemoveColumnBonus.class));
    }

    @Test
    void given_comboOfThree_when_getBonusStatus_then_bonusEmpty() {
        LinearCombo combo = horizontal(3);
        combo.bonus();
        assertThat(combo.getBonusStatus(), is(Combo.BONUS_EMPTY));
    }

    @Test
    void given_comboOfFour_when_getBonusStatus_then_bonusOk() {
        LinearCombo combo = horizontal(4);
        combo.bonus();
        assertThat(combo.getBonusStatus(), is(Combo.BONUS_OK));
    }

    @Test
    void given_combo_when_clear_then_allCellsBecomeNone() {
        CellADT a = cellAt(0, 0, Element.A);
        CellADT b = cellAt(1, 0, Element.A);
        CellADT c = cellAt(2, 0, Element.A);
        LinearCombo combo = new LinearCombo(a, b, c);
        combo.clear();
        CellADT empty = cellAt(5, 5, Element.NONE);
        assertThat(a.hasSameElementAs(empty), is(true));
        assertThat(b.hasSameElementAs(empty), is(true));
        assertThat(c.hasSameElementAs(empty), is(true));
    }
}
