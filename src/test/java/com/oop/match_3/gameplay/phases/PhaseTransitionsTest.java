package com.oop.match_3.gameplay.phases;

import com.oop.match_3.gameplay.steps.FinishStep;
import com.oop.match_3.gameplay.steps.RestartStep;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class PhaseTransitionsTest {

    @Test
    void given_startPhase_when_advance_then_inputPhaseAccepted() {
        Game game = new Game();
        game.advance();
        game.accept(new FinishStep());
        Phase phase = currentPhase(game);
        assertThat(phase.getAcceptStatus(), is(Phase.ACCEPT_OK));
    }

    @Test
    void given_inputPhase_when_acceptFinishStep_then_isOverTrue() {
        Game game = new Game();
        game.advance();
        game.accept(new FinishStep());
        assertThat(game.isOver(), is(true));
    }

    @Test
    void given_endedGame_when_acceptRestartStep_then_isOverFalse() {
        Game game = new Game();
        game.advance();
        game.accept(new FinishStep());
        game.accept(new RestartStep());
        assertThat(game.isOver(), is(false));
    }

    @Test
    void given_anyPhase_when_reset_then_hasMovesTrue() {
        Game game = new Game();
        game.advance();
        game.accept(new FinishStep());
        game.reset();
        assertThat(game.hasMoves(), is(true));
    }
}
