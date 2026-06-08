package com.oop.match_3.gameplay.phases;

import com.oop.match_3.field.Combo;

public class FindCombosPhase extends Phase {

    public FindCombosPhase(final GameADT game) {
        super(game);
    }

    // постусловие: из родительского класса + если есть комбинации - Game переведена в ResolveCombosPhase с этими комбинациями,
    // иначе если есть возможные ходы - Game переведена в InputPhase,
    // иначе - Game переведена в EndPhase
    @Override
    public void advance() {
        advanceStatus = ADVANCE_OK;
        Combo[] combos = game.combos();
        if (hasCombos(combos)) {
            transitionToResolve(combos);
            return;
        }
        if (game.hasMoves()) {
            game.setPhase(new InputPhase(game));
            return;
        }
        game.setPhase(new EndPhase(game));
    }

    private boolean hasCombos(final Combo[] combos) {
        return combos.length > 0;
    }

    private void transitionToResolve(final Combo[] combos) {
        game.scoreCombos(combos);
        game.setPhase(new ResolveCombosPhase(game, combos));
    }
}
