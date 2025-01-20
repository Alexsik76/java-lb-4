import java.util.ArrayList;
import java.util.List;

public abstract class Cage <Animal> {
    private final int capacity;
    private final List<Animal> animals = new ArrayList<>();

    Cage(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be positive");
        }
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
        if (!animals.remove(animal)) {
            throw new UnsupportedOperationException("Animal not found in the cage!");
        }
    }
}
class BirdCage extends Cage<Bird> {
    BirdCage(int capacity) {
        super(capacity);
    }

    @Override
    public void add(Bird bird) {
        super.add(bird);
    }

    @Override
    public void remove(Bird bird) {
        super.remove(bird);
    }
}

abstract class AnimalCage<Mammal> extends Cage<Mammal> {
    AnimalCage(int capacity) {
        super(capacity);
    }
}

class LionCage extends AnimalCage <Lion>{
    LionCage(int capacity) {
        super(capacity);
    }

    @Override
    public void add(Lion animal) {

    }

    @Override
    public void remove(Lion animal) {

    }
}
class UngulatesCage<Ungulates extends AnimalCage<Mammal>> extends AnimalCage<Ungulates>{
    UngulatesCage(int capacity) {
        super(capacity);
    }

    @Override
    public void add(Ungulates animal) {

    }

    @Override
    public void remove(Ungulates animal) {

    }
}
