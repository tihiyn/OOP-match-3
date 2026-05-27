package com.oop.match_3.gameplay.phases;

import com.oop.match_3.gameplay.steps.Step;

public class GravityPhase extends Phase {

    public GravityPhase(final GameADT game) {
        super(game);
    }

    // постусловие: из родительского класса + Game переведена в RefillPhase
    public void advance() {}

    public void accept(final Step step) {}

    public int getAdvanceStatus() {}

    public int getAcceptStatus() {}
}
