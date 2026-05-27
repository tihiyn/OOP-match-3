package com.oop.match_3.field;

import com.oop.match_3.math.UnsignedIntADT;
import com.oop.match_3.statistics.Bonus;

public class LinearCombo extends Combo {
    // конструктор
    // предусловие: предусловия из родительского класса + все ячейки лежат на одной строке или на одном столбце,
    // подряд, без пропусков
    public LinearCombo(CellADT... cells) {
        super(cells);
    }

    public boolean hasBonus() {
        return false;
    }

    public Bonus bonus() {
        return null;
    }
}
