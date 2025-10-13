package org.softwaretechnologies.animals;

public class DOG extends Animal {
    public DOG(String name) {
        super(name);
    }

    @Override
    public String sound() {
        return "woof";
    }
}
