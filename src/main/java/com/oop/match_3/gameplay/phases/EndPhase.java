package com.oop.match_3.gameplay.phases;

import com.oop.match_3.gameplay.steps.FinishStep;
import com.oop.match_3.gameplay.steps.RestartStep;

public class EndPhase extends Phase {

    public EndPhase(final GameADT game) {
        super(game);
    }

    @Override
    public boolean isTerminal() {
        return true;
    }

    @Override
    public boolean isInteractive() {
        return true;
    }

    @Override
    public void advance() {
        advanceStatus = ADVANCE_WRONG_PHASE;
    }

    // постусловие: из родительского класса + Game переведена в StartPhase
    @Override
    public void onRestart(final RestartStep step) {
        game.setPhase(new StartPhase(game));
        acceptStatus = ACCEPT_OK;
    }

    // постусловие: из родительского класса + Game остаётся в EndPhase
    @Override
    public void onFinish(final FinishStep step) {
        acceptStatus = ACCEPT_OK;
    }
}
