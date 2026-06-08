package com.oop.match_3.gameplay.steps;

import com.oop.match_3.field.CoordsADT;
import com.oop.match_3.gameplay.phases.GameADT;
import com.oop.match_3.gameplay.phases.Phase;

public class SwapStep extends Step {
    private final CoordsADT first;
    private final CoordsADT second;

    public SwapStep(final CoordsADT first, final CoordsADT second) {
        this.first = first;
        this.second = second;
    }

    public String print() {
        return "swap";
    }

    // постусловие: из родительского класса + `game` переведена в SwapPhase
    public void execute(final GameADT game) {
        super.execute(game);
    }

    // постусловие: на `phase` вызван `onSwap(this)`; фаза сама решает, легален ли swap и куда переходить
    public void dispatchOn(final Phase phase) {
        phase.onSwap(this);
    }

    // постусловие: `game` выполнил swap координат, хранящихся в шаге
    public void applyTo(final GameADT game) {
        game.swap(first, second);
    }
}
