import java.util.ArrayList;
public class Person extends LivingEntity{

    private ArrayList<Possession> possessions;
    private ArrayList<Pet> pets;

    public Person (String name, Image image) {
        super(name, image);
    }

    public void setPossessions(ArrayList<Possession> possessions) {
        this.possessions = possessions;
    }

    public void setPets(ArrayList<Pet> pets) {
        this.pets = pets;
    }
}