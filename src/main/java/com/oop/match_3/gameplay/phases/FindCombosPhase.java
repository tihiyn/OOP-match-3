package com.oop.match_3.gameplay.phases;

import com.oop.match_3.gameplay.steps.Step;

public class FindCombosPhase extends Phase {

    public FindCombosPhase(final GameADT game) {
        super(game);
    }

    // постусловие: из родительского класса + если есть комбинации - Game переведена в ResolveCombosPhase с этими комбинациями,
    // иначе если есть возможные ходы - Game переведена в InputPhase,
    // иначе - Game переведена в EndPhase
    public void advance() {}

    public void accept(final Step step) {}

    public int getAdvanceStatus() {}

    public int getAcceptStatus() {}
}
