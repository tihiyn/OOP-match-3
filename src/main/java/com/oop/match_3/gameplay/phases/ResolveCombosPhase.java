package com.oop.match_3.gameplay.phases;

import com.oop.match_3.field.Combo;

public class ResolveCombosPhase extends Phase {
    private final Combo[] combos;

    public ResolveCombosPhase(final GameADT game, final Combo[] combos) {
        super(game);
        this.combos = combos;
    }

    // постусловие: из родительского класса + Game переведена в GravityPhase
    @Override
    public void advance() {
        game.resolve(combos);
        game.setPhase(new GravityPhase(game));
        advanceStatus = ADVANCE_OK;
    }
}
