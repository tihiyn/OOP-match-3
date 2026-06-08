package com.oop.match_3.gameplay.phases;

import com.oop.match_3.gameplay.steps.FinishStep;
import com.oop.match_3.gameplay.steps.SwapStep;

public class InputPhase extends Phase {
    public InputPhase(final GameADT game) {
        super(game);
    }

    @Override
    public boolean isInteractive() {
        return true;
    }

    @Override
    public void advance() {
        advanceStatus = ADVANCE_WRONG_PHASE;
    }

    // постусловие: из родительского класса + `game` переведена в SwapPhase
    @Override
    public void onSwap(final SwapStep step) {
        game.recordStep(step);
        game.setPhase(new SwapPhase(game, step));
        acceptStatus = ACCEPT_OK;
    }

    // постусловие: из родительского класса + `game` переведена в EndPhase
    @Override
    public void onFinish(final FinishStep step) {
        game.setPhase(new EndPhase(game));
        acceptStatus = ACCEPT_OK;
    }
}
