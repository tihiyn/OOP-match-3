package com.oop.match_3.statistics;

import com.oop.match_3.field.Element;
import com.oop.match_3.field.GridADT;

public class RemoveTypeBonus extends Bonus {
    public RemoveTypeBonus(final Element type) {}

    @Override
    public String print() {
        return "удаление типа";
    }

    // постусловие: все ячейки `grid` с элементом `type` получили значение Element.NONE
    @Override
    public void apply(final GridADT grid) {}
}
