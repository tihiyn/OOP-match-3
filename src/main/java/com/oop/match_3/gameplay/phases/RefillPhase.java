package com.oop.match_3.gameplay.phases;

public class RefillPhase extends Phase {

    public RefillPhase(final GameADT game) {
        super(game);
    }

    // постусловие: из родительского класса + Game переведена в FindCombosPhase
    public void advance() {
        game.refill();
        game.setPhase(new FindCombosPhase(game));
        advanceStatus = ADVANCE_OK;
    }
}
