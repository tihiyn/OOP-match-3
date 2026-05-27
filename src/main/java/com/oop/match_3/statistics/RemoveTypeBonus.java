package com.oop.match_3.statistics;

import com.oop.match_3.field.Element;
import com.oop.match_3.field.GridADT;

public class RemoveTypeBonus extends Bonus {
    public RemoveTypeBonus(final Element type) {}

    public String print() {}

    // постусловие: все ячейки `grid` с элементом `type` получили значение Element.NONE
    public void apply(final GridADT grid) {}
}
