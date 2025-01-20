import java.util.Map;
import java.util.Scanner;

// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Zoo zoo = new Zoo();
        BirdCage birdCage = new BirdCage(10);
        LionCage lionCage = new LionCage(10);
        UngulatesCage ungulatesCage = new UngulatesCage(20);
        zoo.addCage(birdCage);
        zoo.addCage(lionCage);
        zoo.addCage(ungulatesCage);
        System.out.println("Welcome to the Zoo Management System!");

        Scanner scanner = new Scanner(System.in);

        boolean running = true;
        while (running) {
            System.out.println("Zoo Management System:");
            System.out.println("1. Create and Add Animal");
            System.out.println("2. Count All Animals");
            System.out.println("3. Remove Animal from Cage");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter animal type (number) (1: Eagle, 2: Lion, 3: Zebra, 4: Giraffe): ");
                    String type = scanner.nextLine();
                    System.out.println("Enter animal name: ");
                    String name = scanner.nextLine();

                    switch (type.toLowerCase()) {
                        case "1":
                            Bird bird = new Eagle(name);
                            birdCage.add(bird);
                            break;
                        case "2":
                            Lion lion = new Lion(name);
                            lionCage.add(lion);
                            break;
                        case "3":
                            Ungulates zebra = new Zebra(name);
                            ungulatesCage.add(zebra);
                            break;
                        case "4":
                            Ungulates giraffe = new Giraffe(name);
                            ungulatesCage.add(giraffe);
                            break;
                        default:
                            System.out.println("Invalid animal type!");
                            continue;
                    }
                    System.out.println("Animal and cage added successfully!");
                    break;

                case 2:
                    System.out.println("Total animals in the zoo: " + zoo.getCountOfAnimals());
                    break;

                case 3:
                    Map<Integer, ? extends Animal> animals_map = zoo.get_animals_map();
                    System.out.println("Enter animal (number): ");
                    String entered = scanner.nextLine();
                    int animal_number;
                    try {
                        animal_number = Integer.parseInt(entered);
                    } catch (Exception e) {
                        System.out.println("Invalid animal number!");
                        continue;
                    }
                    try {
                        animals_map.get(animal_number);
                        Animal animal = animals_map.get(animal_number);
                        zoo.remove_animal(animal);
                    } catch (Exception e) {
                        System.out.println("Animal not found!");
                        continue;
                    }
                    break;

                case 4:
                    running = false;
                    System.out.println("Exiting Zoo Management System. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

        scanner.close();
    }
}
