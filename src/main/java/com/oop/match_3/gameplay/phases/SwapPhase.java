package com.oop.match_3.gameplay.phases;

import com.oop.match_3.gameplay.steps.SwapStep;

public class SwapPhase extends Phase {
    private final SwapStep step;

    // постусловие: фаза привязана к игре `game` и хранит `step` для последующего применения в advance()
    public SwapPhase(final GameADT game, final SwapStep step) {
        super(game);
        this.step = step;
    }

    // постусловие: из родительского класса + Game переведена в FindCombosPhase
    public void advance() {
        step.applyTo(game);
        game.setPhase(new FindCombosPhase(game));
        advanceStatus = ADVANCE_OK;
    }
}
