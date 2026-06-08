package com.oop.match_3.gameplay.steps;

import com.oop.match_3.gameplay.phases.GameADT;
import com.oop.match_3.gameplay.phases.Phase;

public class RestartStep extends Step {
    public RestartStep () {}

    public String print() {
        return "restart";
    }

    // постусловие: из родительского класса + `game` переведена в StartPhase
    public void execute(final GameADT game) {
        super.execute(game);
    }

    // постусловие: на `phase` вызван `onRestart(this)`; фаза сама решает, как реагировать
    public void dispatchOn(final Phase phase) {
        phase.onRestart(this);
    }
}
