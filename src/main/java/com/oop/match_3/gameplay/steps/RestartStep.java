package com.oop.match_3.gameplay.steps;

import com.oop.match_3.gameplay.phases.GameADT;

public class RestartStep extends Step {
    public RestartStep () {}

    public String print() {}

    // постусловие: из родительского класса + `game` переведена в StartPhase
    public void execute(final GameADT game) {}
}
