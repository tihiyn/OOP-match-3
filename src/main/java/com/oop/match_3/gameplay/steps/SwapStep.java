package com.oop.match_3.gameplay.steps;

import com.oop.match_3.field.CoordsADT;
import com.oop.match_3.gameplay.phases.GameADT;

public class SwapStep extends Step {
    public SwapStep(CoordsADT first, CoordsADT second) {}

    public String print() {}

    // постусловие: из родительского класса + `game` переведена в SwapPhase
    public void execute(final GameADT game) {}
}
