import java.util.ArrayList;
import java.util.List;

public class Zoo {
    public List<Cage<? extends Animal>> cages = new ArrayList<>();

    public int getCountOfAnimals (){
        return 0;
    }
    public void addCage(Cage<? extends Animal> cage){
        cages.add(cage);
    }
}
