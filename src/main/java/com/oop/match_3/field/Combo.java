package com.oop.match_3.field;

import com.oop.match_3.math.UnsignedInt;
import com.oop.match_3.math.UnsignedIntADT;
import com.oop.match_3.statistics.Bonus;

import java.util.Arrays;

// класс поведения
public abstract class Combo {
    public static final int BONUS_OK = 1; // последний bonus() отработал нормально
    public static final int BONUS_EMPTY = 2; // для данной комбинации бонус отсутствует

    private final CellADT[] cells;
    private final UnsignedIntADT size;

    private static final UnsignedIntADT MIN_COMBO_LENGTH = new UnsignedInt(3);
    private static final UnsignedIntADT BASE_POINTS_PER_CELL = new UnsignedInt(10);
    private static final UnsignedIntADT POINTS_PER_CELL_GROWTH = new UnsignedInt(5);

    private int bonusStatus;

    // конструктор
    // предусловие: `cells` содержит не менее 3 ячеек, все ячейки имеют одинаковое значение Element
    // постусловие: создана комбинация из `cells`
    public Combo(final CellADT... cells) {
        this.cells = cells;
        this.size = new UnsignedInt(cells.length);
        this.bonusStatus = BONUS_EMPTY;
    }

    //----------------запросы----------------

    public UnsignedIntADT score() {
        UnsignedIntADT cellPrice = size.subtract(MIN_COMBO_LENGTH).multiply(POINTS_PER_CELL_GROWTH).add(BASE_POINTS_PER_CELL);
        return cellPrice.multiply(size);
    }

    public abstract boolean hasBonus();

    // предусловие: hasBonus()
    public abstract Bonus bonus();

    //----------------команды----------------

    // постусловие: все ячейки данной комбинации содержат элемент Element.NONE
    public void clear() {
        Arrays.stream(this.cells).forEach(cell -> cell.assignElement(Element.NONE));
    }

    //----------------дополнительные запросы----------------

    public int getBonusStatus() { // возвращает значение BONUS_*
        return bonusStatus;
    }
}
