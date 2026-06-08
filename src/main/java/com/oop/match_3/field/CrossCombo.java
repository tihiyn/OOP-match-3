package com.oop.match_3.field;

import com.oop.match_3.statistics.Bonus;
import com.oop.match_3.statistics.RemoveTypeBonus;

public class CrossCombo extends Combo {
    // конструктор
    // предусловие: предусловия из Combo + `cells` образуют ровно две полоски (одну горизонтальную и одну вертикальную)
    // одного значения, обе длины >= 3, пересекающиеся ровно в одной общей ячейке, которая является центром каждой из
    // полосок
    public CrossCombo(CellADT... cells) {
        super(cells);
    }

    public boolean hasBonus() {
        return true;
    }

    public Bonus bonus() {
        bonusStatus = BONUS_OK;
        return new RemoveTypeBonus(Element.A); // FIXME нужно как-то передавать тип элементов комбинации
    }
}
