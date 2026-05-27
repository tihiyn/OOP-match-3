package com.oop.match_3.gameplay.phases;

import com.oop.match_3.gameplay.steps.Step;

public class StartPhase extends Phase {

    public StartPhase(final GameADT game) {
        super(game);
    }

    // постусловие: из родительского класса + Game переведена в InputPhase
    public void advance() {}

    public void accept(final Step step) {}

    public int getAdvanceStatus() {}

    public int getAcceptStatus() {}
}
