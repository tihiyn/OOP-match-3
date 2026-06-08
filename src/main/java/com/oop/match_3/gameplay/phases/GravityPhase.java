package com.oop.match_3.gameplay.phases;

public class GravityPhase extends Phase {

    public GravityPhase(final GameADT game) {
        super(game);
    }

    // постусловие: из родительского класса + Game переведена в RefillPhase
    public void advance() {
        game.gravity();
        game.setPhase(new RefillPhase(game));
        advanceStatus = ADVANCE_OK;
    }
}
