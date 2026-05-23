package com.oop.match_3.gameplay.phases;

import com.oop.match_3.field.Combo;
import com.oop.match_3.gameplay.steps.Step;

public class RemoveCombosPhase extends Phase {

    public RemoveCombosPhase Phase(Game game, Combo[] combos) {

    }

    // постусловие: ячейки всех `combos` очищены на Grid, очки за каждую комбинацию начислены в Stats игры,
    // бонусы (где hasBonus) выданы игроку, Game переведён в GravityPhase
    public void advance() {

    }

    // постусловие: статус ACCEPT_WRONG_PHASE
    public void accept(Step step) {

    }

    public int getAcceptStatus(){

    }
}
