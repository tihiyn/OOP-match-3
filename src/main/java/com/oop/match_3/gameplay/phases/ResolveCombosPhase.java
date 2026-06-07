package com.oop.match_3.gameplay.phases;

import com.oop.match_3.field.Combo;
import com.oop.match_3.gameplay.steps.Step;

public class ResolveCombosPhase extends Phase {

    public ResolveCombosPhase(final GameADT game, final Combo[] combos) {
        super(game);
    }

    // постусловие: из родительского класса + Game переведена в GravityPhase
    public void advance() {}

    public void accept(final Step step) {}

    public int getAdvanceStatus() {
        return ADVANCE_OK;
    }

    public int getAcceptStatus() {
        return ACCEPT_OK;
    }
}
