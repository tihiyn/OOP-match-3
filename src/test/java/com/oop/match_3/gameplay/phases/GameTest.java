package com.oop.match_3.gameplay.phases;

import com.oop.match_3.field.CoordsADT;
import com.oop.match_3.field.Coords;
import com.oop.match_3.math.UnsignedInt;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.emptyArray;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

class GameTest {

    private CoordsADT at(int col, int row) {
        return new Coords(new UnsignedInt(col), new UnsignedInt(row));
    }

    @Test
    void given_freshGame_when_isOver_then_false() {
        Game game = new Game();
        assertThat(game.isOver(), is(false));
    }

    @Test
    void given_freshGame_when_combos_then_empty() {
        Game game = new Game();
        assertThat(game.combos(), emptyArray());
    }

    @Test
    void given_freshGame_when_hasMoves_then_true() {
        Game game = new Game();
        assertThat(game.hasMoves(), is(true));
    }

    @Test
    void given_freshGame_when_print_then_notNull() {
        Game game = new Game();
        assertThat(game.print(), notNullValue());
    }

    @Test
    void given_game_when_swap_then_doesNotChangeIsOver() {
        Game game = new Game();
        game.advance();
        game.swap(at(0, 0), at(1, 0));
        assertThat(game.isOver(), is(false));
    }

    @Test
    void given_game_when_reset_then_isOverFalse() {
        Game game = new Game();
        game.reset();
        assertThat(game.isOver(), is(false));
    }

    @Test
    void given_game_when_reset_then_hasMovesTrue() {
        Game game = new Game();
        game.reset();
        assertThat(game.hasMoves(), is(true));
    }
}
