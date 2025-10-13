package org.softwaretechnologies.animals;

public class CAT extends Animal {
    public CAT(String name) {
        super(name);
    }

    @Override
    public String sound() {
        return "meow";
    }
}
