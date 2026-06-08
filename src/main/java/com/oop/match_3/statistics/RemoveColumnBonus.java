package com.oop.match_3.statistics;

import com.oop.match_3.field.GridADT;
import com.oop.match_3.math.UnsignedIntADT;

public class RemoveColumnBonus extends Bonus {
    // конструктор
    // предусловие: `col` в пределах поля
    public RemoveColumnBonus (final UnsignedIntADT col) {}

    public String print() {
        return "удаление столбца";
    }

    // постусловие: все ячейки `grid` в столбце `col` получили значение Element.NONE
    public void apply(final GridADT grid) {}
}
