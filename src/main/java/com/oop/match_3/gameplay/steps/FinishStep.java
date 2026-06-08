package com.oop.match_3.gameplay.steps;

import com.oop.match_3.gameplay.phases.GameADT;
import com.oop.match_3.gameplay.phases.Phase;

public class FinishStep extends Step {
    public FinishStep() {}

    public String print() {
        return "finish";
    }

    // постусловие: из родительского класса + `game` переведена в EndPhase
    public void execute(final GameADT game) {
        super.execute(game);
    }

    // постусловие: на `phase` вызван `onFinish(this)`; фаза сама решает, как реагировать
    public void dispatchOn(final Phase phase) {
        phase.onFinish(this);
    }
}
