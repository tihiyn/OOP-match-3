package com.oop.match_3.gameplay.steps;

import com.oop.match_3.gameplay.phases.GameADT;
import com.oop.match_3.gameplay.phases.Phase;

public class FinishStep extends Step {
    public FinishStep() {}

    @Override
    public String print() {
        return "finish";
    }

    // постусловие: из родительского класса + `game` переведена в EndPhase
    @Override
    public void execute(final GameADT game) {
        super.execute(game);
    }

    // постусловие: на `phase` вызван `onFinish(this)`
    @Override
    public void dispatchOn(final Phase phase) {
        phase.onFinish(this);
    }
}
