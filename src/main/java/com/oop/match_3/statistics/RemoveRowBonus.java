package com.oop.match_3.statistics;

import com.oop.match_3.field.GridADT;
import com.oop.match_3.math.UnsignedIntADT;

public class RemoveRowBonus extends Bonus {
    // конструктор
    // предусловие: `row` в пределах поля
    public RemoveRowBonus(final UnsignedIntADT row) {}

    @Override
    public String print() {
        return "удаление ряда";
    }

    // постусловие: все ячейки `grid` в ряду `row` получили значение Element.NONE
    @Override
    public void apply(final GridADT grid) {}
}
