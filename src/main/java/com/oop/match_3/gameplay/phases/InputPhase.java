package com.oop.match_3.gameplay.phases;

import com.oop.match_3.gameplay.steps.FinishStep;
import com.oop.match_3.gameplay.steps.SwapStep;

public class InputPhase extends Phase {
    public InputPhase(final GameADT game) {
        super(game);
    }

    // предусловие: интерактивная фаза, advance() недопустима
    public void advance() {
        advanceStatus = ADVANCE_WRONG_PHASE;
    }

    // постусловие: из родительского класса + если SwapStep - Game переведена в SwapPhase,
    // если FinishStep - в EndPhase
    public void onSwap(final SwapStep step) {
        game.setPhase(new SwapPhase(game, step));
        acceptStatus = ACCEPT_OK;
    }

    public void onFinish(final FinishStep step) {
        game.setPhase(new EndPhase(game));
        acceptStatus = ACCEPT_OK;
    }

    public boolean isInteractive() {
        return true;
    }
}
