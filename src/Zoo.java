import java.util.*;

public class Zoo implements java.io.Serializable{
    public List<Cage<? extends Animal>> cages = new ArrayList<>();

    public int getCountOfAnimals() {
        int count_of_animals = 0;
        for (Cage<? extends Animal> cage : cages) {
            System.out.println(cage.getClass().getName() + "-->" + cage.getCountOfAnimals());
            count_of_animals += cage.getCountOfAnimals();
        }
        return count_of_animals;
    }

    public void addCage(Cage<? extends Animal> cage) {
        cages.add(cage);
    }

    public Map<Integer,Animal> get_animals_map() {
        Map<Integer,Animal> animals_map = new HashMap<>();
        int index = 1;
        for (Cage<? extends Animal> cage : cages) {
            Collection<? extends Animal> all_animals = cage.getAnimals();
            for (Animal animal : all_animals) {
                animals_map.put(index, animal);
                System.out.println(index + ". " + animal.name + " (" + animal.getClass().getSimpleName() + ")");
                index++;
            }
        }
        return animals_map;
    }

    public Cage<? extends Animal> get_cage_by_animal(Animal animal) {
        for (Cage<? extends Animal> cage : cages) {
            if (cage.getAnimals().contains(animal)) {
                return cage;
            }
        }
        return null;
    }

    public Cage<? extends Animal> get_cage_by_name(String name) {
        for (Cage<? extends Animal> cage : cages) {
            if (cage.name.equals(name)) {
                return cage;
            }
        }
        return null;
    }

    public void remove_animal(Animal animal) {
        Cage<Animal> cage = (Cage<Animal>) get_cage_by_animal(animal);
        if (cage != null) {
            cage.remove(animal);
        }
    }
}
