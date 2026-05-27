package com.oop.match_3.field;

public abstract class ElementsFactoryADT {
    // конструктор
    // постусловие: если фабрика до этого не создавалась - создана фабрика, иначе - возвращает существующую
    public ElementsFactoryADT() {}

    //----------------запросы----------------

    public abstract Element generate();
}
