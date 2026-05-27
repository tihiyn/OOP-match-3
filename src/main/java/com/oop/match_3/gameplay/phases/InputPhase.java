package com.oop.match_3.gameplay.phases;

import com.oop.match_3.gameplay.steps.Step;

public class InputPhase extends Phase {
    public InputPhase(final GameADT game) {
        super(game);
    }

    public void advance() {}

    // постусловие: из родительского класса + если SwapStep - Game переведена в SwapPhase,
    // если FinishStep - в EndPhase
    public void accept(final Step step) {}

    public int getAdvanceStatus() {}

    public int getAcceptStatus() {}
}
