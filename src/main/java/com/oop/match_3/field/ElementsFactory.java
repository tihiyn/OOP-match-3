package com.oop.match_3.field;

public abstract class ElementsFactory {
    // конструктор
    // постусловие: создана фабрика элементов
    public abstract ElementsFactory ElementsFactory();

    //----------------запросы----------------
    public abstract Element generate();
}
