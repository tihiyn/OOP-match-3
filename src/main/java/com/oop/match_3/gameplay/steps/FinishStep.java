package com.oop.match_3.gameplay.steps;

import com.oop.match_3.gameplay.phases.GameADT;

public class FinishStep extends Step {
    public FinishStep() {}

    public String print() {}

    // постусловие: из родительского класса + `game` переведена в EndPhase
    public void execute(GameADT game) {}
}
