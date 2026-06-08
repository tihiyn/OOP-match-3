package com.oop.match_3.field;

import com.oop.match_3.math.UnsignedInt;
import com.oop.match_3.math.UnsignedIntADT;
import com.oop.match_3.statistics.Bonus;
import com.oop.match_3.statistics.RemoveColumnBonus;
import com.oop.match_3.statistics.RemoveRowBonus;

public class LinearCombo extends Combo {
    private static final UnsignedIntADT BONUS_THRESHOLD = new UnsignedInt(4);

    // конструктор
    // предусловие: предусловия из родительского класса + все ячейки лежат на одной строке или на одном столбце,
    // подряд, без пропусков
    public LinearCombo(CellADT... cells) {
        super(cells);
    }

    public boolean hasBonus() {
        return size.compare(BONUS_THRESHOLD) >= 0;
    }

    public Bonus bonus() {
        bonusStatus = BONUS_EMPTY;
        if (hasBonus()) {
            bonusStatus = BONUS_OK;
            return chooseBonus();
        }
        return null;
    }

    private Bonus chooseBonus() {
        if (isHorizontal()) {
            return new RemoveRowBonus(new UnsignedInt(0)); // FIXME нужно как-то передавать номер строки
        }
        return new RemoveColumnBonus(new UnsignedInt(0)); // FIXME нужно как-то передавать номер столбца
    }

    private boolean isHorizontal() {
        Cell first = (Cell) cells[0];
        return first.sharesRowWith(cells[1]);
    }
}
