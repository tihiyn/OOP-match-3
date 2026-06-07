package com.oop.match_3.gameplay.phases;

import com.oop.match_3.gameplay.steps.Step;

public class StartPhase extends Phase {

    public StartPhase(final GameADT game) {
        super(game);
    }

    // постусловие: из родительского класса + Game переведена в InputPhase
    public void advance() {}

    public void accept(final Step step) {}

    public int getAdvanceStatus() {
        return ADVANCE_OK;
    }

    public int getAcceptStatus() {
        return ACCEPT_OK;
    }
}
