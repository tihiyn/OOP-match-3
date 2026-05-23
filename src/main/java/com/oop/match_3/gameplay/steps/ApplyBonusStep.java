package com.oop.match_3.gameplay.steps;

import com.oop.match_3.gameplay.phases.Game;
import com.oop.match_3.statistics.Bonus;

public class ApplyBonusStep extends Step {

    public ApplyBonusStep Step(Bonus bonus) {

    }

    public String print() {
        return null;
    }

    // постусловие: `bonus` применён к Grid, `game` переведён в FindCombosPhase
    public void execute(Game game) {

    }
}
