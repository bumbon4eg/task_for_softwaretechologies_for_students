package org.softwaretechnologies;

import org.softwaretechnologies.animals.*;

public class AnimalFactory {

    /**
     * Метод для создания животных по типу
     * @param name - имя животного
     * @param type - тип животного
     * @return животное, соответствующее каждому из типов.
     */


    public static Animal createAnimal(String name, AnimalType type) {
        switch (type) {
            case CAT -> {
                return new CAT(name);
            }
            case DOG -> {
                return new DOG(name);
            }
            case COW -> {
                return new COW(name);
            }
            default -> throw new IllegalStateException("Unexpected value: " + type);
        }
    }
}
