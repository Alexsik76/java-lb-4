public abstract class Animal {
    public String name;

    Animal(String name) {
        this.name = name;
    }
}

abstract class Bird extends Animal {
    Bird(String name) {
        super(name);
    }
}

class Eagle extends Bird {
    Eagle(String name) {
        super(name);
    }
}

abstract class Mammal extends Animal {

    Mammal(String name) {
        super(name);
    }
}

class Lion extends Animal {
    Lion(String name) {
        super(name);
    }
}

abstract class Ungulates extends Animal {
    Ungulates(String name) {
        super(name);
    }
}

class Giraffe extends Ungulates {
    Giraffe(String name) {
        super(name);
    }
}

class Zebra extends Ungulates {
    Zebra(String name) {
        super(name);
    }
}