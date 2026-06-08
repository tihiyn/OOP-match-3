package com.oop.match_3.gameplay.phases;

public class StartPhase extends Phase {

    public StartPhase(final GameADT game) {
        super(game);
    }

    // постусловие: из родительского класса + Game переведена в InputPhase
    public void advance() {
        game.setPhase(new InputPhase(game));
        advanceStatus = ADVANCE_OK;
    }
}
