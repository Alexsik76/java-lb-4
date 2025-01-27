import java.util.ArrayList;
import java.util.List;

public abstract class Cage<Animal> implements java.io.Serializable {
    protected final String name;
    protected final int capacity;
    protected final List<Animal> animals = new ArrayList<>();

    Cage(String name, int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be positive");
        }
        this.name = name;
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public void add(Animal animal) {
        if (animals.size() >= capacity) {
            throw new UnsupportedOperationException("Cage is full!");
        }
        animals.add(animal);
    }

    public void remove(Animal animal) {
        if (animals.isEmpty()) {
            throw new UnsupportedOperationException("Animal not found in the cage!");
        }
        animals.remove(animal);
    }

    public List<? extends Animal> getAnimals() {
        return animals;
    }

    public int getCountOfAnimals() {
        return animals.size();
    }
}

class BirdCage extends Cage<Bird> {
    BirdCage(String name, int capacity) {
        super(name, capacity);
    }
}

abstract class MammalCage<Mammal> extends Cage<Mammal> {
    MammalCage(String name, int capacity) {
        super(name, capacity);
    }
}

class LionCage extends MammalCage<Lion> {
    LionCage(String name, int capacity) {
        super(name, capacity);
    }
}

class UngulatesCage extends MammalCage<Ungulates> {
    UngulatesCage(String name, int capacity) {
        super(name, capacity);
    }
}
