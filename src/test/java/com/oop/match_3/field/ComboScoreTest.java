package com.oop.match_3.field;

import com.oop.match_3.math.UnsignedInt;
import com.oop.match_3.math.UnsignedIntADT;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class ComboScoreTest {

    private CellADT cellAt(int col, int row) {
        return new Cell(new Coords(new UnsignedInt(col), new UnsignedInt(row)), Element.A);
    }

    private LinearCombo horizontal(int length) {
        CellADT[] cells = new CellADT[length];
        for (int i = 0; i < length; i++) {
            cells[i] = cellAt(i, 0);
        }
        return new LinearCombo(cells);
    }

    @Test
    void given_comboOfThree_when_score_then_30() {
        UnsignedIntADT score = horizontal(3).score();
        assertThat(score.eq(new UnsignedInt(30)), is(true));
    }

    @Test
    void given_comboOfFour_when_score_then_60() {
        UnsignedIntADT score = horizontal(4).score();
        assertThat(score.eq(new UnsignedInt(60)), is(true));
    }

    @Test
    void given_comboOfFive_when_score_then_100() {
        UnsignedIntADT score = horizontal(5).score();
        assertThat(score.eq(new UnsignedInt(100)), is(true));
    }

    @Test
    void given_comboOfSix_when_score_then_150() {
        UnsignedIntADT score = horizontal(6).score();
        assertThat(score.eq(new UnsignedInt(150)), is(true));
    }

    @Test
    void given_comboOfSeven_when_score_then_210() {
        UnsignedIntADT score = horizontal(7).score();
        assertThat(score.eq(new UnsignedInt(210)), is(true));
    }
}
